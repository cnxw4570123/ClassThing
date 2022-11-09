package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.BoardDto;

public class BoardDao {
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "JSP_PROJECT", "1111");
	return con;	
	}
	
	public ArrayList<BoardDto> selectBoard() {
		System.out.println("Bdao selectBoard() 호출");
		ArrayList<BoardDto> boardList = new ArrayList<>();
		BoardDto board = null;
		
		String Sql = "SELECT BNO, BTITLE, BWRITER, BCONTENT, TO_CHAR(BDATE, 'YYYY-MM-DD'), BHITS, BFILENAME, BSTATE FROM BOARDS"
				+ " ORDER BY BNO DESC";
		try {
			Connection con = getConnection();
			pstmt = con.prepareStatement(Sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getInt(6), rs.getString(7), rs.getString(8));
				boardList.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return boardList;
	}

	public int insertBoardContent(BoardDto board) {
		int insertResult = 0;
		String sql = "INSERT INTO BOARDS(BNO, BTITLE, BWRITER, BCONTENT, BDATE, BHITS, BFILENAME, BSTATE)"
				+ " VALUES(?, ?, ?, ?, SYSDATE, 0, '', '0')";
		try {
			Connection con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board.getbNo());
			pstmt.setString(2, board.getbTitle());
			pstmt.setString(3, board.getbWriter());
			pstmt.setString(4, board.getbContent());	
			insertResult = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return insertResult;
	}

	public int selectMaxBno() {
		int bno = -1;
		String sql = "SELECT NVL(MAX(BNO), 0) FROM BOARDS";
		try {
			Connection con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bno = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return bno;
	}

	public BoardDto selectOneContent(int bno) {
		BoardDto board = null;
		String sql = "SELECT BNO, BTITLE, BWRITER, BCONTENT, TO_CHAR(BDATE, 'YYYY-MM-DD')"
				+ ", BHITS, BFILENAME, BSTATE FROM BOARDS WHERE BNO = ?";
		
		try {
			Connection con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				board = new BoardDto();
				board = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getInt(6), rs.getString(7), rs.getString(8));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return board;
	}

	public int updateHits(int bno) {
		int updateResult = 0;
		String sql = "UPDATE BOARDS SET BHITS = BHITS + 1 WHERE BNO = ?";
		try {
			Connection con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			updateResult = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateResult;
	}

	public ArrayList<BoardDto> selectCertainBoardList(String searchType, String searchText) {
		System.out.println("bdao selectCertainBoardList() 호출");
		ArrayList<BoardDto> boardList = new ArrayList<>();
		BoardDto board = null;
		String sql = "";
		System.out.println("title이랑 같아?" + searchType.equals("title"));
		/*
		 * if(searchType.equals("title")) { sql =
		 * "SELECT BNO, BTITLE, BWRITER, BCONTENT, TO_CHAR(BDATE, 'YYYY-MM-DD'), BHITS, BFILENAME, BSTATE FROM BOARDS"
		 * + " WHERE BTITLE LIKE '%?%' ORDER BY BNO DESC"; } else
		 * if(searchType.equals("content")) { sql =
		 * "SELECT BNO, BTITLE, BWRITER, BCONTENT, TO_CHAR(BDATE, 'YYYY-MM-DD'), BHITS, BFILENAME, BSTATE FROM BOARDS"
		 * + " WHERE BCONTENT LIKE '%?%' ORDER BY BNO DESC"; } else
		 * if(searchType.equals("writer")) { sql =
		 * "SELECT BNO, BTITLE, BWRITER, BCONTENT, TO_CHAR(BDATE, 'YYYY-MM-DD'), BHITS, BFILENAME, BSTATE FROM BOARDS"
		 * + " WHERE BCONTENT LIKE '%?%' ORDER BY BNO DESC"; } else { sql =
		 * "SELECT BNO, BTITLE, BWRITER, BCONTENT, TO_CHAR(BDATE, 'YYYY-MM-DD'), BHITS, BFILENAME, BSTATE FROM BOARDS"
		 * + " WHERE BTITLE LIKE '%?%' OR BCONTENT LIKE '%?%' ORDER BY BNO DESC"; }
		 */
		switch(searchType) {
		case "title":
			sql = "SELECT BNO, BTITLE, BWRITER, BCONTENT, TO_CHAR(BDATE, 'YYYY-MM-DD'), BHITS, BFILENAME, BSTATE FROM BOARDS"
					+ " WHERE BTITLE LIKE '%'||?||'%' ORDER BY BNO DESC";
			break;
		case "content":
			sql = "SELECT BNO, BTITLE, BWRITER, BCONTENT, TO_CHAR(BDATE, 'YYYY-MM-DD'), BHITS, BFILENAME, BSTATE FROM BOARDS"
					+ " WHERE BCONTENT LIKE '%'||?||'%' ORDER BY BNO DESC";
			break;
		case "writer":
			sql = "SELECT BNO, BTITLE, BWRITER, BCONTENT, TO_CHAR(BDATE, 'YYYY-MM-DD'), BHITS, BFILENAME, BSTATE FROM BOARDS"
					+ " WHERE BWRITER LIKE '%'||?||'%' ORDER BY BNO DESC";
			break;
		case "titleContent":
			sql = "SELECT BNO, BTITLE, BWRITER, BCONTENT, TO_CHAR(BDATE, 'YYYY-MM-DD'), BHITS, BFILENAME, BSTATE FROM BOARDS"
					+ " WHERE BTITLE LIKE '%'||?||'%' OR BCONTENT LIKE '%'||?||'%' ORDER BY BNO DESC";
			break;
		}
		
	
		try {
			Connection con = getConnection();
			pstmt = con.prepareStatement(sql);
			
			if(!searchType.equals("titleContent")) {
				pstmt.setString(1, searchText);
				rs = pstmt.executeQuery();
				
			} else {
				pstmt.setString(1, searchText);
				pstmt.setString(2, searchText);
				rs = pstmt.executeQuery();
			}
			while(rs.next()) {
				board = new BoardDto();
				board = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getInt(6), rs.getString(7), rs.getString(8));
				boardList.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return boardList;
	}

}
