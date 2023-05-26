package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface IBoardDAO {

	int selectBoardCount(PaginationInfoVO<BoardVO> pagingVO);

	List<BoardVO> selectBoardList(PaginationInfoVO<BoardVO> pagingVO);
}
