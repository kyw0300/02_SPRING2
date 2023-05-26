package kr.or.ddit.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.dao.IMemberDAO;
import kr.or.ddit.vo.MemberVO;

@Service
public class MemberServiceImpl implements IMemberService {
	
	@Inject
	private IMemberDAO dao;

	@Override
	public ServiceResult insertMember(MemberVO member) {
		ServiceResult result = null;
		int status = dao.insertMember(member);
		if(status > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public MemberVO loginCheck(MemberVO member) {
//		ServiceResult result = null;
		MemberVO loginCheck = dao.loginCheck(member);
	
//		if(loginCheck != null) {
//			result = ServiceResult.EXIST;
//			
//		} else {
//			result = ServiceResult.NOTEXIST;
//		}
		return loginCheck;
	}

}
