package kr.or.ddit.mapper;

import java.util.List;

import kr.or.ddit.vo.MemberAuth;
import kr.or.ddit.vo.MemberVO;

public interface MemberMapper {

	void create(MemberVO member);

	void createAuth(MemberAuth memberAuth);

	List<MemberVO> list();

	MemberVO read(int userNo);

}
