package kr.or.ddit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Slf4j
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/*
	 * 4. 컨트롤러 응답
	 * 
	 * 1) void 타입
	 * - 호출하는 URL과 동일한 뷰 이름을 나타내기 위해 사용합니다.
	 */
	
	// 요청 경로(/goHome0101)와 동일한 뷰(/goHome0101.jsp)를 가리킨다.
	@RequestMapping(value = "/goHome0101", method = RequestMethod.GET)
	public void goHome0101() {
		log.info("goHome0101() 실행...!");
	}
	
	// 요청 경로(/sub/goHome0102)와 동일한 뷰(/sub/goHome0102.jsp)를 가리킨다.
	@RequestMapping(value = "/sub/goHome0102", method = RequestMethod.GET)
	public void goHome0102() {
		log.info("goHome0102() 실행...!");
	}
	
	/*
	 * 2) String 타입
	 * - 뷰 파일의 경로와 파일 이름을 나타내기 위해 사용합니다.
	 */
	
	// 반환값이 home0201이므로 뷰(/home0201.jsp)를 가리킨다.
	@RequestMapping(value = "/goHome0201", method = RequestMethod.GET)
	public String goHome0201() {
		log.info("goHome0201() 실행...!");
		return "home0201";
	}
	
	// 반환값이 home0202 이므로 뷰(/home0202.jsp)를 가리킨다.
	@RequestMapping(value = "/goHome0202", method = RequestMethod.GET)
	public String goHome0202() {
		log.info("goHome0202() 실행...!");
		return "home0202";
	}
	
	// 반환값이 /sub/home0203 이므로 뷰(sub/home0203.jsp)를 가리킨다.
	@RequestMapping(value = "/sub/goHome0203", method = RequestMethod.GET)
	public String goHome0203() {
		log.info("goHome0203() 실행...!");
		return "sub/home0203";
	}
	
	// 반환값이 "redirect:/"로 시작하면 리다이렉트 방식으로 처리한다.
	@RequestMapping(value = "/sub/goHome0204", method = RequestMethod.GET)
	public String goHome0204() {
		log.info("goHome0204() 실행...!");
		return "redirect:/sub/goHome0203";
	}
	
	// '/'로 시작하면 웹 애플리케이션의 컨텍스트 경로에 영향을 받지 않는 절대경로를 의미한다.
	// 해당경로 : D드라이브 > workspace > .metadata > .plugin > ,,, > DevProject > WEB-INF > views > sub > ,,, .jsp
	@RequestMapping(value = "/sub/goHome0205", method = RequestMethod.GET)
	public String goHome0205() {
		log.info("goHome0205() 실행...!");
		return "/sub/home0205";
	}
	
	/*
	 * 3) 자바빈즈 클래스 타입(VO)
	 * - JSON 객체 타입의 데이터를 만들어서 반환하는 용도로 사용한다.
	 * 
	 * 1) ResponseBody를 이용하는 방식
	 * 2) RestController를 이용하는 방식
	 * 
	 * @ResponseBody를 지정하지 않으면 HTTP 404에러가 발생한다.(jackson-databind 라이브러리가 설정되어 있지 않는 경우도 포함)
	 * @ResponseBody가 객체를 리턴하여 객체를 응답 데이터로 보내는 역할을 합니다.
	 * @ResponseBody의 리턴 default 데이터 형식은 json입니다.
	 * @ResponseBody 대신에 @RestController를 이용하여 대체할 수 있습니다.
	 */
	
	@ResponseBody
	@RequestMapping(value = "/goHome0301", method = RequestMethod.GET)
	public Member goHome0301() {
		log.info("goHome0301() 실행...!");
		// 객체를 리턴하여 데이터를 확인하기 때문에 페이지 정보가 없다.
		Member member = new Member();
		return member;
	}
	
	/*
	 * 4) 컬렉션 List 타입
	 * - JSON 객체 배열 타입의 데이터를 만들어서 반환하는 용도로 사용한다.
	 * 
	 * 1) ResponseBody를 이용하는 방식
	 * 2) RestController를 이용하는 방식
	 */
	
	// 반환값이 컬렉션 List 타입이면 JSON 객체 배열 타입으로 자동 변환된다.
	@ResponseBody
	@RequestMapping(value = "/goHome0401", method = RequestMethod.GET)
	public List<Member> goHome0401() {
		log.info("goHome0401() 실행...!");
		
		// 회원 자바빈즈 클래스(객체)를 넣을 리스트 생성
		List<Member> list = new ArrayList<Member>();
		Member member = new Member();	// 첫번째 회원 자바빈즈 객체
		list.add(member);
		Member member2 = new Member();	// 두번째 회원 자바빈즈 객체
		list.add(member2);
		
		return list;
	}
	
	/*
	 * 5) 컬렉션 Map 타입
	 * - Map 형태의 컬렉션 자료를 JSON 객체 타입의 데이터로 만들어서 반환하는 용도로 사용한다.
	 * 
	 * 1) ResponseBody를 이용하는 방식
	 * 2) RestController를 이용하는 방식
	 */
	
	// 반환값이 컬렉션 Map 타입이면 JSON 객체 타입으로 자동으로 변환된다.
	@ResponseBody
	@RequestMapping(value = "/goHome0501", method = RequestMethod.GET)
	public Map<String, Member> goHome0501() {
		log.info("goHome0501() 실행...!");
		Map<String, Member> map = new HashMap<String, Member>();
		Member member = new Member();
		Member member2 = new Member();
		map.put("key1", member);
		map.put("key2", member2);
		
		return map;
	}
	
	/*
	 * 6) ResponseEntity<void> 타입
	 * - response 할 때 HTTP 헤더 정보와 내용을 가공하는 용도로 사용한다.
	 * 
	 * 1) ResponseBody를 이용하는 방식
	 * 2) RestController를 이용하는 방식
	 */
	
	// 200 OK 상태코드를 전송한다.
	// Void 타입은 아무런 형태가 아닌데 제네릭타입의 뭔가는 채워야겠어서 채우는 placeholder같은 느낌(?)이랄까?
	@RequestMapping(value = "/goHome0601", method = RequestMethod.GET)
	public ResponseEntity<Void> goHome0601() {
		log.info("goHome0601() 실행...!");
		return new ResponseEntity<Void>(HttpStatus.OK);
		// 내가 요청한 url로 응답이 나가면서 응답데이터로 아무런 값이 전달되지 않는다.
		// 해당 URL 요청 후, 브라우저에서 개발자 도구를 이용해서 네트워크 탭을 확인해보면 응답으로 URL이 응답으로 나간걸 확인할 수 있는데,
		// 이때 상태코드 200으로 정상 응답이 나간걸 확인할 수 있다.
		// 그리고, 다른 기능으로 아무런 형태 없이 응답으로 나가지만 응답의 대한 header 정보를 변경하고자 할 때 사용할 수 있다.
	}
	
	/*
	 * 7) ResponseEntity<String> 타입
	 * - response 할 때 HTTP 헤더 정보와 문자열 데이터를 전달하는 용도로 사용한다.
	 * 
	 * 1) ResponseBody를 이용하는 방식
	 * 2) RestController를 이용하는 방식
	 */
	
	// "SUCCESS" 메세지와 200 OK 상태코드를 전송한다.
	@ResponseBody
	@RequestMapping(value = "/goHome0701", method = RequestMethod.GET)
	public ResponseEntity<String> goHome0701() {
		log.info("goHome0701() 실행...!");
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	/*
	 * 8) ResponseEntity<자바빈즈 클래스> 타입
	 * - response 할 때 HTTP 헤더 정보와 객체 데이터를 전달하는 용도로 사용한다.
	 * 
	 * 1) ResponseBody를 이용하는 방식
	 * 2) RestController를 이용하는 방식
	 */
	
	// 객체의 JSON 타입의 데이터와 200 OK 상태코드를 전송한다.
	@ResponseBody
	@RequestMapping(value = "/goHome0801", method = RequestMethod.GET)
	public ResponseEntity<Member> goHome0801() {
		log.info("goHome0801() 실행...!");
		Member member = new Member();
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	/*
	 * 9) ResponseEntity<List> 타입
	 * - response 할 때 HTTP 헤더 정보와 객체 배열 데이터를 전달하는 용도로 사용한다.
	 * 
	 * 1) ResponseBody를 이용하는 방식
	 * 2) RestController를 이용하는 방식
	 */
	
	// 객체의 JSON 객체 배열 타입의 데이터와 200 OK 상태코드를 전송한다.
	@ResponseBody
	@RequestMapping(value = "/goHome0901", method = RequestMethod.GET)
	public ResponseEntity<List<Member>> goHome0901() {
		log.info("goHome0901() 실행...!");
		List<Member> list = new ArrayList<Member>();
		Member member = new Member();
		Member member2 = new Member();
		list.add(member);
		list.add(member2);
		
		return new ResponseEntity<List<Member>>(list, HttpStatus.OK);
	}
	
	/*
	 * 10) ResponseEntity<Map> 타입
	 * - response 할 때 HTTP 헤더 정보와 객체 데이터를 Map형태로 전달하는 용도로 사용한다.
	 * 
	 * 1) ResponseBody를 이용하는 방식
	 * 2) RestController를 이용하는 방식
	 */
	
	@RequestMapping(value = "/goHome1001", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Member>> goHome1001() {
		log.info("goHome1001() 실행...!");
		Map<String, Member> map = new HashMap<String, Member>();
		Member member = new Member();
		Member member2 = new Member();
		map.put("key1", member);
		map.put("key2", member2);
		
		return new ResponseEntity<Map<String,Member>>(map, HttpStatus.OK);
	}
	
	/*
	 * 11) ResponseEntity<byte[]> 타입
	 * - response 할 때 HTTP 헤더 정보와 바이너리 파일 데이터를 전달하는 용도로 사용한다.
	 * - 파일을 처리하기 위해서 의존라이브러리인 commons-io를 추가한다. (pom.xml)
	 * 
	 * > 무료/유료 이미지 다운로드 홈페이지를 사용해보면 이미지 미리보기 또는 미리보기 후 다운로드를 할 수 있는 기능이 제공된다.
	 *   이와 같은 리턴타입의 형태를 설정해서 내보내는 것과 같다.
	 * 
	 * 1) ResponseBody를 이용하는 방식
	 * 2) RestController를 이용하는 방식
	 */
	
	// 바이트 배열로 이미지 파일의 데이터를 전송한다.
	@RequestMapping(value = "/goHome1101", method = RequestMethod.GET)
	public ResponseEntity<byte[]> goHome1101() {
		log.info("goHome1101() 실행...!");
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		HttpHeaders headers = new HttpHeaders();
		try {
			// 파일 경로를 나타내는 방법 2가지
			// 방법 1 ('\\')
			// in = new FileInputStream("D:\\slamimages\\정대만.jpg");
			// 방법 2 ('/')
			in = new FileInputStream("D:/slamimages/lion.jpg");
			headers.setContentType(MediaType.IMAGE_JPEG);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	// 파일의 데이터를 브라우저 다운로드 받도록 한다.
	@RequestMapping(value = "/goHome1102", method = RequestMethod.GET)
	public ResponseEntity<byte[]> goHome1102() throws Exception {
		log.info("goHome1102() 실행...!");
		String fileName = "data.zip";
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		HttpHeaders headers = new HttpHeaders();
		try {
			in = new FileInputStream("D:/slamimages/" + fileName);
			// MediaType.APPLICATION_OCTET_STREAM은 이진 파일을 위한 기본값입니다.
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", "attachment; filename=\"" +
					new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}
}
