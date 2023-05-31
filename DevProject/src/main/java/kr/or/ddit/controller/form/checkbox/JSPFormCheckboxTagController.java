package kr.or.ddit.controller.form.checkbox;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/formtag/checkbox")
@Slf4j
public class JSPFormCheckboxTagController {

	/*
	 * 8장 스프링 폼 태그
	 * 
	 * 8. 체크박스 요소
	 * - HTML 체크박스를 출력하려면 <form:checkbox> 요소를 사용한다.
	 */
	
	// 1) 모델에 기본생성자로 생성한 폼 객체를 추가한 후에 화면에 전달한다.
	@GetMapping("/registerForm01")
	public String registerForm01(Model model) {
		log.info("registerForm01() 실행...!");
		model.addAttribute("member", new Member());
		return "form/checkbox/registerForm01";
	}
	
	@GetMapping("/registerForm02")
	public String registerForm02(Model model) {
		log.info("registerForm02() 실행...!");
		
		Member member = new Member();
		member.setDeveloper("Y");
		member.setForeigner(true);
		member.setHobby("농구1");
		
		String[] hobbyArray = {"농구2", "축구2"};
		member.setHobbyArray(hobbyArray);
		
		List<String> hobbyList = new ArrayList<String>();
		hobbyList.add("농구3");
		hobbyList.add("탁구3");
		hobbyList.add("축구3");
		member.setHobbyList(hobbyList);
		
		model.addAttribute("member", member);
		return "form/checkbox/registerForm01";
	}
	
	@PostMapping("/result")
	public String registerResult(Member member, Model model) {
		log.info("registerResult() 실행...!");
		log.info("member.developer : " + member.getDeveloper());
		log.info("member.foreigner : " + member.isForeigner());
		log.info("member.hobby : " + member.getHobby());
		
		String[] hobbyArray = member.getHobbyArray();
		if(hobbyArray != null) {
			for(int i=0; i<hobbyArray.length; i++) {
				log.info("hobbyArray["+i+"] : " + hobbyArray[i]);
			}
		} else {
			log.info("hobbyArray is null");
		}
		
		List<String> hobbyList = member.getHobbyList();
		if(hobbyList != null) {
			for(int i=0; i<hobbyList.size(); i++) {
				log.info("hobbyList["+i+"] : " + hobbyList.get(i));
			}
		} else {
			log.info("hobbyList is null");
		}
		
		model.addAttribute("member", member);
		return "form/checkbox/result";
	}
}
