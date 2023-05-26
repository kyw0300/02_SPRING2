package kr.or.ddit.service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.MemberVO;

public interface IMemberService {
	public ServiceResult insertMember(MemberVO member);

	public MemberVO loginCheck(MemberVO member);
}
