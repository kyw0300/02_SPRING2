package kr.or.ddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class EJController {

	@GetMapping("/login")
	public String loginForm() {
		return "page-login";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index/content";
	}
}
