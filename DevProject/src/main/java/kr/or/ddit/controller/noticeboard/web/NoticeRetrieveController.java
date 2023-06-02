package kr.or.ddit.controller.noticeboard.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.controller.noticeboard.service.INoticeService;
import kr.or.ddit.vo.NoticeVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/notice")
@Slf4j
public class NoticeRetrieveController {
	
	@Inject
	private INoticeService noticeService;

	@GetMapping("/list.do")
	public String noticeList() {
		log.info("noticeList() 실행...!");
		return "notice/list";
	}
	
	@GetMapping("/detail.do")
	public String noticeDetail(int boNo, Model model) {
		log.info("noticeDetail() 실행...!");
		
		NoticeVO noticeVO = noticeService.selectNotice(boNo);
		model.addAttribute("notice", noticeVO);
		
		return "notice/detail";
	}
}
