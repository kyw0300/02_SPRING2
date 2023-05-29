package kr.or.ddit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.service.IBoardService;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PaginationInfoVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	private IBoardService service;

	@RequestMapping(value = "/list")
	public String list(
			@RequestParam(name="page", required = false, defaultValue = "1") int currentPage,
			@RequestParam(required = false, defaultValue = "title") String searchType,
			@RequestParam(required = false) String searchWord,
			Model model) {
		log.info("list() 실행...!");
		
		PaginationInfoVO<BoardVO> pagingVO = new PaginationInfoVO<BoardVO>();
		
		if(StringUtils.isNotBlank(searchWord)) {
			pagingVO.setSearchType(searchType);
			pagingVO.setSearchWord(searchWord);
			model.addAttribute("searchType",searchType);
			model.addAttribute("searchWord",searchWord);
		}
		pagingVO.setCurrentPage(currentPage);
		
		int totalRecord = service.selectBoardCount(pagingVO);
		log.info("boardCount : " + totalRecord);
		
		pagingVO.setTotalRecord(totalRecord);
		List<BoardVO> dataList = service.selectBoardList(pagingVO);
		pagingVO.setDataList(dataList);
		model.addAttribute("pagingVO",pagingVO);
		
		return "pages/ddit_list";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(int boNo, Model model) {
		log.info("detail() 실행...!");
		log.info("bono : " + boNo);
		
		BoardVO board = service.selectBoard(boNo);
		model.addAttribute("detailBoard", board);
		
		return "pages/ddit_detail";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(int boNo) {
		log.info("delete() 실행...!");
		String goPage = "";
		ServiceResult result = service.deleteBoard(boNo);
		
		if(result.equals(ServiceResult.OK)) {
			goPage = "redirect:/board/list";
		} else {
			goPage = "redirect:/board/detail?boNo="+boNo;
		}
		
		return goPage;
	}
	
	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm(int boNo, Model model) {
		log.info("updateForm() 실행...!");
		
		BoardVO board = service.selectBoard(boNo);
		
		model.addAttribute("board",board);
		model.addAttribute("status","u");
		
		return "pages/ddit_form";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO board, RedirectAttributes redirectattribute) {
		log.info("update() 실행...!");
		String goPage = "";
		String msg = "";
		ServiceResult result = service.updateBoard(board);
		
		if(result.equals(ServiceResult.OK)) {
			msg = "수정이 완료되었습니다!";
			goPage = "redirect:/board/detail?boNo="+board.getBoNo();
		} else {
			msg = "수정을 실패하였습니다!";
			goPage = "redirect:/board/updateForm?boNo="+board.getBoNo();
		}
		redirectattribute.addFlashAttribute("msg", msg);
		return goPage;
	}
	
	
	@RequestMapping(value = "/insertForm", method = RequestMethod.GET)
	public String insertForm() {
		log.info("insertForm() 실행...!");
		return "pages/ddit_form";
	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(BoardVO board, Model model, HttpServletRequest request, RedirectAttributes redirectattribute) {
		log.info("insert() 실행...!");
		HttpSession session = request.getSession();
		MemberVO loginMem = (MemberVO) session.getAttribute("member");
		String boWriter = loginMem.getMemId();
		
		String goPage = "";
		String msg = "";
		
		Map<String, Object> errors = new HashMap<String, Object>();
		if(StringUtils.isBlank(board.getBoTitle())) {
			errors.put("boTitle", "제목을 입력해주세요!");
		}
		if(StringUtils.isBlank(board.getBoContent())) {
			errors.put("boContent", "내용을 입력해주세요!");
		}
		
		if(errors.size() > 0) {
			model.addAttribute("error","누락된 입력 정보가 존재합니다!");
			model.addAttribute("boardVO", board);
			goPage = "/board/insertForm";
		} else {
			board.setBoWriter(boWriter);
			ServiceResult result = service.insertBoard(board);
			if(result.equals(ServiceResult.OK)) {
				msg = "글 등록이 완료되었습니다!";
				goPage = "redirect:/board/list";
			} else {
				msg = "글 등록 실패!";
				goPage = "redirect:/board/insertForm";
			}
		}
		redirectattribute.addFlashAttribute("msg", msg);
		return goPage;
	}
	
}
