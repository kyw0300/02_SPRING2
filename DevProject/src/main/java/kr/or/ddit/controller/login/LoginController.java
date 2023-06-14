package kr.or.ddit.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.ddit.vo.MemberVO;

@Controller
public class LoginController {

	@GetMapping("/login1")
	public String loginForm() {
		return "login/loginForm";
	}
	
	@PostMapping("/login1")
	public String login(String userId, String userPw, Model model) {
		
		MemberVO member = new MemberVO();
		member.setUserId(userId);
		member.setUserPw(userPw);
		member.setUserName("서태웅");
		
		model.addAttribute("user", member);
		return "login/success";
	}
}
