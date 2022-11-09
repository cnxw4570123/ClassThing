package service;

import java.util.ArrayList;
import java.util.StringTokenizer;

import dao.BoardDao;
import dto.BoardDto;

public class Bservice {
	private BoardDao bDao = new BoardDao();
	
	public ArrayList<BoardDto> selectBoardInfo() {
		System.out.println("Bservice selectBoardInfo() 호출");
		ArrayList<BoardDto> BoardList =  bDao.selectBoard();
		return BoardList;
	}

	public int insertBoard(BoardDto board) {
		int insertResult = 0; 
		int bno = bDao.selectMaxBno() + 1;
		if(bno > 0) {
			board.setbNo(bno);
			insertResult = bDao.insertBoardContent(board);
		}
		
		return insertResult;
	}

	public BoardDto selectOneBoard(int bno) {
		System.out.println("bsvc selectOneBoard()실행");
		BoardDto board = null;
		board = bDao.selectOneContent(bno);
		int updateResult = bDao.updateHits(bno);
		if(updateResult > 0) {
			
			String bText = board.getbContent();
			String afterSt = "";
			StringTokenizer st = new StringTokenizer(bText, "\n");
			while(st.hasMoreTokens()) {
				afterSt += st.nextToken()+ "<br>";
			}
			board.setbContent(afterSt);
			return board;
		} else {
			System.out.println("업데이트 실패");
		}
		return board;
	}

	public ArrayList<BoardDto> selectCertainBoardInfo(String searchType, String searchText) {
		System.out.println("bsvc selectCertainBoardInfo() 호출");
		ArrayList<BoardDto> boardList = bDao.selectCertainBoardList(searchType, searchText);
		return boardList;
	}
	
}
