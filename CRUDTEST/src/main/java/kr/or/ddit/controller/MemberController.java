package kr.or.ddit.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.service.IMemberService;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/member")
public class MemberController {
	
	@Inject
	private IMemberService service;
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signinForm() {
		log.info("signinForm() 실행...!");
		return "pages/ddit_signin";
	}
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signin(MemberVO member, Model model, HttpServletRequest request, RedirectAttributes redirectattribute) {
		log.info("signin() 실행...!");
		String goPage = "";
		
//		log.info("id : " + member.getMem_id());
//		log.info("pw : " + member.getMem_pw());
		
		Map<String , Object> errors = new HashMap<String, Object>();
		
		if(StringUtils.isBlank(member.getMemId())) {
			errors.put("memId", "아이디를 입력해주세요!");
		}
		if(StringUtils.isBlank(member.getMemPw())) {
			errors.put("memPw", "비밀번호를 입력해주세요!");
		}
		
		if(errors.size() > 0) {
			model.addAttribute("error","누락된 입력 정보가 존재합니다!");
			goPage = "pages/ddit_signin";
		} else {
			MemberVO loginMem = service.loginCheck(member);
//			log.info("loginResult : "+result);
			
			if(loginMem != null) {
				HttpSession session = request.getSession();
				session.setAttribute("member", loginMem);
				
				goPage = "redirect:/board/list";
				
			} else {
//				model.addAttribute("error","존재하지 않는 회원입니다!");
//				goPage = "pages/ddit_signin";
				
				redirectattribute.addFlashAttribute("msg", "존재하지 않는 회원입니다!");
				goPage = "redirect:/member/signin";
			}
			
		}
		return goPage;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupForm() {
		log.info("signupForm() 실행...!");
		return "pages/ddit_signup";
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(MemberVO member, Model model, RedirectAttributes redirectattribute) {
		log.info("signup() 실행...!");
		log.info(member.getMemId());
		log.info(member.getMemPw());
		log.info(member.getMemName());
		log.info(member.getMemPhone());
		log.info(member.getMemEmail());
		String goPage = "";
		Map<String , Object> errors = new HashMap<String, Object>();
		
		if(StringUtils.isBlank(member.getMemId())) {
			errors.put("mem_id", "아이디를 입력해주세요!");
		}
		if(StringUtils.isBlank(member.getMemPw())) {
			errors.put("mem_pw", "비밀번호를 입력해주세요!");
		}
		if(StringUtils.isBlank(member.getMemName())) {
			errors.put("mem_name", "이름을 입력해주세요!");
		}
		if(StringUtils.isBlank(member.getMemPhone())) {
			errors.put("mem_phone", "핸드폰번호를 입력해주세요!");
		}
		if(StringUtils.isBlank(member.getMemEmail())) {
			errors.put("mem_email", "이메일을 입력해주세요!");
		}
		
		if(errors.size() > 0) {
			model.addAttribute("error","누락된 입력 정보가 존재합니다!");
			model.addAttribute("memberVO",member);
			goPage = "pages/ddit_signup";
		} else {
			ServiceResult result = service.insertMember(member);
			log.info("가입 결과 : "+result);
			if(result.equals(ServiceResult.OK)) {
				redirectattribute.addFlashAttribute("msg", "가입이 완료되었습니다!");
				goPage = "redirect:/member/signin";
			} else {
				redirectattribute.addFlashAttribute("msg", "가입이 실패했습니다! 다시 시도해주세요!");
				goPage = "redirect:/member/signin";
				
//				model.addAttribute("error","가입이 실패했습니다! 다시 시도해주세요!");
//				goPage = "pages/ddit_signup";
			}
		}
		
		return goPage;
//		return "start";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		log.info("logout() 실행...!");
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "pages/ddit_signin";
	}
	
	@GetMapping("/start")
	public String hello() {
		return "start";
	}
}
