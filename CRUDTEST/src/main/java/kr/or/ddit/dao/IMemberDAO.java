package kr.or.ddit.dao;

import kr.or.ddit.vo.MemberVO;

public interface IMemberDAO {
	public int insertMember(MemberVO member);

	public MemberVO loginCheck(MemberVO member);
}
