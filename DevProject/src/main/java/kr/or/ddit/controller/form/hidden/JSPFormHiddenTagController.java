package kr.or.ddit.controller.form.hidden;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/formtag/hidden")
@Slf4j
public class JSPFormHiddenTagController {

	/*
	 * 8장 스프링 폼 태그
	 * 
	 * 12. 숨겨진 필드 요소
	 * - HTML 숨겨진 필드를 출력하려면 <form:hidden> 요소를 사용한다.
	 */
	
	@GetMapping("/registerFormHidden01")
	public String registerFormHidden01(Model model) {
		log.info("registerFormHidden01() 실행...!");
		
		Member member = new Member();
		member.setUserId("Jintae");
		member.setUserName("서진태");
		
		model.addAttribute("member", member);
		return "form/hidden/registerFormHidden01";
	}
	
	@PostMapping("/result")
	public String registerFormHiddenResult(Member member, Model model) {
		log.info("registerFormHiddenResult() 실행...!");
		log.info("userId : " + member.getUserId());
		log.info("userName : " + member.getUserName());
		return "form/hidden/result";
	}
}
