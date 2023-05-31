package kr.or.ddit.controller.form.selectbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.vo.CodeLabelValue;
import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/formtag/selectbox")
@Slf4j
public class JSPFormSelectboxTagController {

	/*
	 * 8장 스프링 폼 태그
	 * 
	 * 11. 셀렉트 박스 요소
	 * - HTML 셀렉트 박스를 출력하려면 <form:select> 요소를 사용한다.
	 */
	
	@GetMapping("/registerFormSelectbox01")
	public String registerFormSelectbox01(Model model) {
		log.info("registerFormSelectbox01() 실행...!");
		
		Map<String, String> nationalityCodeMap = new HashMap<String, String>();
		nationalityCodeMap.put("01", "Korea");
		nationalityCodeMap.put("02", "USA");
		nationalityCodeMap.put("03", "Japan");
		nationalityCodeMap.put("04", "Russia");
		nationalityCodeMap.put("05", "Canada");
		
		model.addAttribute("nationalityCodeMap",nationalityCodeMap);
		model.addAttribute("member", new Member());
		return "form/selectbox/registerFormSelectbox01";
	}
	
	//모델에 List 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
	@GetMapping("/registerFormSelectbox02")
	public String registerFormSelectbox02(Model model) {
		log.info("registerFormSelectbox02() 실행...!");
		
		List<CodeLabelValue> nationalityCodeList = new ArrayList<CodeLabelValue>();
		nationalityCodeList.add(new CodeLabelValue("Korea", "한국"));
		nationalityCodeList.add(new CodeLabelValue("USA", "일본"));
		nationalityCodeList.add(new CodeLabelValue("Japan", "홍콩"));
		nationalityCodeList.add(new CodeLabelValue("Russia", "러시아"));
		nationalityCodeList.add(new CodeLabelValue("Southeast Asia", "동남아"));
		
		model.addAttribute("nationalityCodeList",nationalityCodeList);
		model.addAttribute("member", new Member());
		return "form/selectbox/registerFormSelectbox02";
	}
	
	@GetMapping("/registerFormSelectbox03")
	public String registerFormSelectbox03(Model model) {
		log.info("registerFormSelectbox03() 실행...!");
		
		List<CodeLabelValue> carCodeList = new ArrayList<CodeLabelValue>();
		carCodeList.add(new CodeLabelValue("01", "Lamborghini"));
		carCodeList.add(new CodeLabelValue("02", "Ferrari"));
		carCodeList.add(new CodeLabelValue("03", "Porsche AG"));
		
		model.addAttribute("carCodeList",carCodeList);
		model.addAttribute("member", new Member());
		return "form/selectbox/registerFormSelectbox03";
	}
	
	@PostMapping("/result")
	public String registerFormSelectResult(Member member, Model model) {
		log.info("registerFormSelectResult() 실행...!");
		log.info("nationality : " + member.getNationality());
		
		model.addAttribute("nationality", member.getNationality());
		return "form/selectbox/result";
		
		
	}
}
