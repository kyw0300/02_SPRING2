package kr.or.ddit.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Repository
public class BoardDAOImpl implements IBoardDAO {

	@Inject
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int selectBoardCount(PaginationInfoVO<BoardVO> pagingVO) {
		return sqlSession.selectOne("Board.selectBoardCount",pagingVO);
	}

	@Override
	public List<BoardVO> selectBoardList(PaginationInfoVO<BoardVO> pagingVO) {
		return sqlSession.selectList("Board.selectBoardList",pagingVO);
	}

}
