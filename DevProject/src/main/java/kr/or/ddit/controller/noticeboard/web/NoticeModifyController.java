package kr.or.ddit.controller.noticeboard.web;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.controller.noticeboard.service.INoticeService;
import kr.or.ddit.vo.NoticeVO;

@Controller
@RequestMapping("/notice")
public class NoticeModifyController {
	
	@Inject
	private INoticeService noticeService;

	@GetMapping("/update.do")
	public String noticeModifyForm(int boNo, Model model) {
		NoticeVO noticeVO = noticeService.selectNotice(boNo);
		model.addAttribute("notice", noticeVO);
		model.addAttribute("status", "u");
		return "notice/form";
	}
	
	@PostMapping("/update.do")
	public String noticeModify(
			HttpServletRequest req,
			NoticeVO noticeVO, Model model) {
		String goPage = "";
		ServiceResult result = noticeService.updateNotice(req, noticeVO);
		if(result.equals(ServiceResult.OK)) {
			goPage = "redirect:/notice/detail.do?boNo=" + noticeVO.getBoNo();
		} else {
			model.addAttribute("message", "수정에 실패하였습니다!");
			model.addAttribute("noticeVO", noticeVO);
			model.addAttribute("status", "u");
			goPage = "notice/form";
		}
		return goPage;
	}
	
	@PostMapping("/delete.do")
	public String noticeDelete(
			HttpServletRequest req,
			int boNo, Model model) {
		String goPage = "";
		ServiceResult result = null;
		
		result = noticeService.deleteNotice(req, boNo);
		if(result.equals(ServiceResult.OK)) {
			goPage = "redirect:/notice/list.do";
		} else {
			model.addAttribute("message", "서버오류, 다시 시도해주세요!");
			goPage = "redirect:/notice/detail.do?boNo="+boNo;
		}
		return goPage;
	}
}
