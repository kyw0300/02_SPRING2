package kr.or.ddit.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.MemberVO;

@Repository
public class MemberDAOImpl implements IMemberDAO {

	@Inject
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertMember(MemberVO member) {
		return sqlSession.insert("Member.insertMember",member);
	}

	@Override
	public MemberVO loginCheck(MemberVO member) {
		return sqlSession.selectOne("Member.loginCheck",member);
	}

}
