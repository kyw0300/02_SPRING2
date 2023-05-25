package kr.or.ddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/redirectattribute")
@Slf4j
public class RedirectAttributeMemberController {
	
	/*
	 * 4. RedirectAttribute 타입
	 * - RedirectAttribute는 일회성으로 데이터를 전달하는 용도로 사용한다.
	 */
	
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		return "member/registerRedirectAttributeForm";
	}
	
	@PostMapping("/register")
	// RedirectAttributes redirectattribute 일회성 요청만 넘어감
	// Member member 안넘어감 (redirect이기 떄문)
	public String register(Member member, RedirectAttributes redirectattribute) {
		log.info("register() 실행...!");
		redirectattribute.addFlashAttribute("msg", "success");
		return "redirect:/redirectattribute/result";
	}
	
	@GetMapping("/result")
	public String result() {
		log.info("result() 실행...!");
		return "result";
	}
}
