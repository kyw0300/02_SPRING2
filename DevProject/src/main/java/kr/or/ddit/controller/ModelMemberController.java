package kr.or.ddit.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Address;
import kr.or.ddit.vo.Card;
import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ModelMemberController {
	
	/*
	 * 6장. 데이터 전달자 모델
	 * - Model 객체 이용
	 */
	
	// 1) 매개변수에 선언된 Model 객체의 addAttribute() 메서드를 호출하여 데이터를 뷰(View)에 전달한다.
	@RequestMapping(value = "/read01", method = RequestMethod.GET)
	public String read01(Model model) {
		log.info("read01() 실행...!");
		
		model.addAttribute("userId","jdm999");
		model.addAttribute("password","9999");
		model.addAttribute("userName","정대만");
		model.addAttribute("email","jdm999@naver.com");
		model.addAttribute("birthDay","1972-05-22");
		return "member/read01";
	}
	
	// 2) Model 객체에 자바빈즈 클래스 객체를 값으로만 전달할 때는 뷰에서 참조할 이름을 클래스명의 앞글자를 소문자로 변환하여 처리한다.
	@RequestMapping(value = "/read02", method = RequestMethod.GET)
	public String read02(Model model) {
		log.info("read02() 실행...!");
		
		Member member = new Member();
		member.setUserId("jdm999");
		member.setPassword("9999");
		member.setUserName("정대만");
		member.setEmail("jdm999@naver.com");
		member.setBirthDay("1972-05-22");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1972);
		cal.set(Calendar.MONTH, 5);
		cal.set(Calendar.DAY_OF_MONTH, 22);
		
		member.setDateOfBirth(cal.getTime());
		
		model.addAttribute(member); // Member타입이므로 'member'가 키값으로 전달된다.
		return "member/read02";
	}
	
	// 3) Model 객체에 자바빈즈 클래스 객체를 특정한 이름을 지정하여 전달할 수 있다.
	@RequestMapping(value = "/read03", method = RequestMethod.GET)
	public String read03(Model model) {
		log.info("read03() 실행...!");
		
		Member member = new Member();
		member.setUserId("jdm999");
		member.setPassword("9999");
		member.setUserName("정대만");
		member.setEmail("jdm999@naver.com");
		member.setBirthDay("1972-05-22");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1972);
		cal.set(Calendar.MONTH, 5);
		cal.set(Calendar.DAY_OF_MONTH, 22);
		
		member.setDateOfBirth(cal.getTime());
		
		model.addAttribute("user",member);
		return "member/read03";
	}
	
	// 4) Model 객체를 통해 배열과 컬렉션 객체를 전달할 수 있다.
	@RequestMapping(value = "/read04", method = RequestMethod.GET)
	public String read04(Model model) {
		log.info("read04() 실행...!");
		
		String[] carArray = {"jeep","bmw"};
		
		List<String> carList = new ArrayList<String>();
		carList.add("volvo");
		carList.add("benz");
		
		String[] hobbyArray = {"Music","Movie"};
		
		List<String> hobbyList = new ArrayList<String>();
		hobbyList.add("Sports");
		hobbyList.add("Book");
		
		model.addAttribute("carArray", carArray);
		model.addAttribute("carList", carList);
		model.addAttribute("hobbyArray", hobbyArray);
		model.addAttribute("hobbyList", hobbyList);
		return "member/read04";
	}
	
	// 5) Model 객체를 통해 중첩된 자바빈즈 클래스 객체를 전달할 수 있다.
	@RequestMapping(value = "/read05", method = RequestMethod.GET)
	public String read05(Model model) {
		log.info("read05() 실행...!");
		
		Member member = new Member();
		
		Address address = new Address();
		address.setPostCode("098900");
		address.setLocation("서구 도안동");
		
		member.setAddress(address);
		
		List<Card> cardList = new ArrayList<Card>();
		
		Card card1 = new Card();
		card1.setNo("123456");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DAY_OF_MONTH, 8);
		card1.setValidMonth(cal.getTime());
		cardList.add(card1);
		
		Card card2 = new Card();
		card1.setNo("567890");
		
		cal.set(Calendar.YEAR, 2023);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DAY_OF_MONTH, 7);
		card1.setValidMonth(cal.getTime());
		cardList.add(card2);
		
		member.setCardList(cardList);
		model.addAttribute("user", member);
		return "member/read05";
	}
	
	// 6) Model 객체를 통해 다양한 타입의 값을 전달할 수 있다.
	@RequestMapping(value = "/read06", method = RequestMethod.GET)
	public String read06(Model model) {
		log.info("read06() 실행...!");
		
		Member member = new Member();
		member.setUserId("stw777");
		member.setPassword("7777");
		member.setEmail("stw777@naver.com");
		member.setUserName("서태웅");
		member.setBirthDay("1972-05-22");
		member.setGender("남자");
		member.setDeveloper("N");
		member.setForeigner(false);
		member.setNationality("Korea");
		member.setCars("Hyundai");
		
		String[] carArray = {"jeep","bmw"};
		member.setCarArray(carArray);
		
		List<String> carList = new ArrayList<String>();
		carList.add("audi");
		carList.add("benz");
		member.setCarList(carList);
		
		member.setHobby("Basketball, Baseball, football");
		String[] hobbyArray = {"농구","만화책"};
		member.setHobbyArray(hobbyArray);
		
		List<String> hobbyList = new ArrayList<String>();
		hobbyList.add("축구");
		hobbyList.add("야구");
		member.setHobbyList(hobbyList);
		
		Address address = new Address();
		address.setPostCode("789789");
		address.setLocation("북산고등학교");
		member.setAddress(address);
		
		List<Card> cardList = new ArrayList<Card>();
		
		Card card1 = new Card();
		card1.setNo("123123");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2023);
		cal.set(Calendar.MONTH, 7);
		cal.set(Calendar.DAY_OF_MONTH, 21);
		card1.setValidMonth(cal.getTime());
		cardList.add(card1);
		
		Card card2 = new Card();
		card2.setNo("456456");
		cal.set(Calendar.YEAR, 2021);
		cal.set(Calendar.MONTH, 4);
		cal.set(Calendar.DAY_OF_MONTH, 6);
		card2.setValidMonth(cal.getTime());
		cardList.add(card2);
		
		member.setCardList(cardList);
		member.setDateOfBirth(cal.getTime());
		member.setIntroduction("불꽃남자\n정대만!!!");
		
		model.addAttribute("user", member);
		return "member/read06";
	}
}
