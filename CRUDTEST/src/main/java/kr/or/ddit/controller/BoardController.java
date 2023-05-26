package kr.or.ddit.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String detail(int bono, Model model) {
		log.info("detail() 실행...!");
		log.info("bono : " + bono);
		
		
		return "pages/ddit_detail";
	}
	
	
	
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form() {
		return "pages/ddit_form";
	}
	
}
