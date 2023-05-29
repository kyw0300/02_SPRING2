package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface IBoardService {

	int selectBoardCount(PaginationInfoVO<BoardVO> pagingVO);

	List<BoardVO> selectBoardList(PaginationInfoVO<BoardVO> pagingVO);

	BoardVO selectBoard(int bono);

	ServiceResult deleteBoard(int boNo);

	ServiceResult updateBoard(BoardVO board);

	ServiceResult insertBoard(BoardVO board);


}
