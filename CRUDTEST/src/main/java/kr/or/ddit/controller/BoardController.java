package kr.or.ddit.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.service.IBoardService;
import kr.or.ddit.vo.BoardVO;
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
	public String update(BoardVO board) {
		log.info("update() 실행...!");
		log.info("boNo : " + boNo);
		String goPage = "";
		ServiceResult result = service.updateBoard(board);
		
		if(result.equals(ServiceResult.OK)) {
			goPage = "redirect:/board/detail?boNo="+boNo;
		} else {
			goPage = "redirect:/board/updateForm?boNo="+boNo;
		}
		
		return goPage;
	}
	
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form() {
		
		return "pages/ddit_form";
	}
	
}
