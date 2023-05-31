package kr.or.ddit.controller.form.radio;

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
@RequestMapping("/formtag/radio")
@Slf4j
public class JSPFormRadioTagController {

	/*
	 * 8장 스프링 폼 태그
	 * 
	 * 9. 여러 개의 라디오 버튼 요소
	 * - HTML 라디오 버튼을 출력하려면 <form:radiobuttons> 요소를 사용한다.
	 */
	
	@GetMapping("/registerFormRadios01")
	public String registerFormRadios01(Model model) {
		log.info("registerFormRadios01() 실행...!");
		
		Map<String, String> genderCodeMap = new HashMap<String, String>();
		genderCodeMap.put("01", "Male");
		genderCodeMap.put("02", "Female");
		genderCodeMap.put("03", "Other");
		
		model.addAttribute("genderCodeMap", genderCodeMap);
		model.addAttribute("member", new Member());
		return "form/radio/registerFormRadios01";
	}
	
	@GetMapping("/registerFormRadios02")
	public String registerFormRadios02(Model model) {
		log.info("registerFormRadios02() 실행...!");
		
		List<CodeLabelValue> genderCodeList = new ArrayList<CodeLabelValue>();
		genderCodeList.add(new CodeLabelValue("01", "Male"));
		genderCodeList.add(new CodeLabelValue("02", "Female"));
		genderCodeList.add(new CodeLabelValue("03", "Other"));
		
		model.addAttribute("genderCodeList", genderCodeList);
		model.addAttribute("member", new Member());
		return "form/radio/registerFormRadios02";
	}
	
	@PostMapping("/result")
	public String registerFormRadioResult(Member member, Model model) {
		log.info("registerFormRadioResult() 실행...!");
		log.info("member.gender : " + member.getGender());
		
		model.addAttribute("gender", member.getGender());
		return "form/radio/result";
	}
	
	// 여기서부터는 단일 radio 버튼입니다.
	
	/*
	 * 8. 스프링 폼 태그
	 * 
	 * 10. 라디오 버튼 요소
	 * - HTML 라디오 버튼을 출력하려면 <form:radiobutton> 요소를 사용한다.
	 */
	
	@GetMapping("/registerFormRadio01")
	public String registerFormRadio01(Model model) {
		log.info("registerFormRadio01() 실행...!");
		model.addAttribute("member", new Member());
		return "form/radio/registerFormRadio01";
	}
	
	@GetMapping("/registerFormRadio02")
	public String registerFormRadio02(Model model) {
		log.info("registerFormRadio02() 실행...!");
		
		Member member = new Member();
		member.setGender("외계인");
		model.addAttribute("member", member);
		return "form/radio/registerFormRadio01";
	}
	
	
}
