package kr.or.ddit.controller.board;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.service.IBoardService;
import kr.or.ddit.vo.Board;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/crud/board")
@Slf4j
public class CrudBoardController {
	
	@Inject
	private IBoardService service;
	
	// 빈이 등록되고 초기화 단계에서 바로 확인할때 사용
	@PostConstruct
	public void init() {
		log.info("aopProxy 상태(interface 기반) : {} " + AopUtils.isAopProxy(service));
		log.info("aopProxy 상태(class 기반) : {} " + AopUtils.isCglibProxy(service));
	}

	@GetMapping("/register")
	public String crudRegisterForm(Model model) {
		log.info("crudRegisterForm() 실행...!");
		model.addAttribute("board", new Board());
		return "crud/register";
	}
	
	@PostMapping("/register")
	public String crudRegister(@Validated Board board, Model model) {
		log.info("crudRegister() 실행...!");
		
		try {
			service.register(board);
		} catch (IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("msg", "등록이 완료되었습니다!");
		return "crud/success";
	}
	
	@GetMapping("/list")
	public String crudList(Model model) {
		log.info("crudList() 실행...!");
		
		List<Board> boardList = service.list();
		model.addAttribute("boardList", boardList);
		return "crud/list";
	}
	
	@GetMapping("/read")
	public String crudRead(int boardNo, Model model) {
		log.info("crudRead() 실행...!");
		Board board = service.read(boardNo);
		
		model.addAttribute("board",board);
		return "crud/read";
	}
	
	@GetMapping("/modify")
	public String crudModifyForm(int boardNo, Model model) {
		log.info("crudModifyForm() 실행...!");
		Board board = service.read(boardNo);
		
		model.addAttribute("board", board);
		model.addAttribute("status", "u");
		return "crud/register";
	}
	
	@PostMapping("/modify")
	public String crudModify(Board board, Model model) {
		log.info("crudModify() 실행...!");
		service.update(board);
		model.addAttribute("msg", "수정이 완료되었습니다.");
		return "crud/success";
	}
	
	@PostMapping("/remove")
	public String crudDelete(int boardNo, Model model) {
		log.info("crudDelete() 실행...!");
		service.delete(boardNo);
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		return "crud/success";
	}
	
	@PostMapping("/search")
	public String crudSearch(String title, Model model) {
		log.info("crudSearch() 실행...!");
		Board board = new Board();
		board.setTitle(title);
		
		List<Board> boardList = service.search(board);
		model.addAttribute("board", board);
		model.addAttribute("boardList", boardList);
		return "crud/list";
	}
}
