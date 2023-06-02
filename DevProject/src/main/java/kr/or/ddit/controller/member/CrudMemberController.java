package kr.or.ddit.controller.member;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/crud/member")
@Slf4j
public class CrudMemberController {
	
	@Inject
	private IMemberService service;

	@GetMapping("/register")
	public String crudMemberRegisterForm() {
		log.info("crudMemberRegisterForm() 실행...!");
		return "crud/member/register";
	}
	
	@PostMapping("/register")
	public String crudMemberRegister(MemberVO member, Model model) {
		log.info("crudMemberRegister() 실행...!");
		service.register(member);
		model.addAttribute("msg", "등록이 완료되었습니다!");
		return "crud/member/success";
	}
	
	@GetMapping("/list")
	public String crudMemberList(Model model) {
		log.info("crudMemberList() 실행...!");
		List<MemberVO> memberList = service.list();
		model.addAttribute("memberList", memberList);
		return "crud/member/list";
	}
	
	@GetMapping("/read")
	public String crudMemberRead(int userNo, Model model) {
		log.info("crudMemberRead() 실행...!");
		MemberVO member = service.read(userNo);
		model.addAttribute("member",member);
		return "crud/member/read";
	}
	
	@GetMapping("/modify")
	public String modifyForm(int userNo, Model model) {
		log.info("modifyForm() 실행...!");
		MemberVO member = service.read(userNo);
		model.addAttribute("member", member);
		return "crud/member/modify";
	}
	
	@PostMapping("/modify")
	public String modify(MemberVO member, Model model) {
		log.info("modify() 실행...!");
		service.modify(member);
		model.addAttribute("msg", "수정이 완료되었습니다!");
		return "crud/member/success";
	}
	
	@PostMapping("/remove")
	public String remove(int userNo, Model model) {
		log.info("remove() 실행...!");
		service.remove(userNo);
		model.addAttribute("msg", "삭제가 완료되었습니다!");
		return "crud/member/success"; 
	}
}
