package com.MemberBoard001.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.MemberBoard001.dto.BoardDto;
import com.MemberBoard001.dto.CommentDto;
import com.MemberBoard001.dto.LikeDto;

public interface BoardDao {

	@Select("SELECT NVL(MAX(BNO), 0) FROM BOARDS") // 마지막 글 번호 조회
	int selectMaxbNum();

	@Insert("INSERT INTO BOARDS(BNO, BTITLE, BWRITER, BCONTENT, BDATE, BHITS, BFILENAME, BSTATE)" // 글 작성
			+ " VALUES(${bno}, #{btitle}, #{bwriter}, #{bcontent}, TO_DATE(SYSDATE, 'YYYY-MM-DD'), 0, #{bfilename}, '0')")
	int insertBoard(BoardDto boardInfo);

	@Select("SELECT BNO, BTITLE, BWRITER, BDATE, BHITS FROM BOARDS") //전체 글 조회
	ArrayList<BoardDto> selectBoardList();

	@Select("SELECT BNO, BTITLE, BWRITER, BCONTENT, BDATE, BHITS, BFILENAME, BSTATE FROM BOARDS WHERE BNO = #{bno}") // 글번호로 글 조회
	BoardDto selectBoard(int bno);

	@Update("UPDATE BOARDS SET BHITS = BHITS + 1 WHERE BNO = #{bno}") //조회수 업데이트
	int updateHits(int bno);

	@Update("UPDATE BOARDS SET BTITLE = #{rtitle}, BCONTENT = #{rcontent} WHERE BNO = ${rbno}")
	int updateBoard(@Param("rtitle") String rtitle, @Param("rcontent")  String rcontent, @Param("rbno") int rbno);

	@Insert("INSERT INTO COMMENTS(CNO, CWRITER, CCONTENT, CHITS, CDATE, C_BNO, CSTATE) "
			+ "VALUES((SELECT NVL(MAX(CNO) , 0) + 1 FROM COMMENTS), #{cwriter}, #{ccontent}, 0, TO_DATE(SYSDATE,'RR-MM-DD'), ${cbno}, '0')")
	int insertComment(CommentDto comment);
	
	@Select("SELECT * FROM COMMENTS WHERE C_BNO = ${cbno} ORDER BY CNO")
	ArrayList<CommentDto> getCommentList(int cbno);

	@Delete("DELETE FROM COMMENTS WHERE CNO = ${cno}")
	int deleteCom(int cno);

	@Update("UPDATE COMMENTS SET CCONTENT = #{ccontent} WHERE CNO = ${cno}")
	int updateComment(@Param("cno") int cno, @Param("ccontent") String ccontent);
	
	@Select("SELECT BNO, BTITLE, BDATE, BHITS FROM BOARDS WHERE BWRITER = #{id}")
	ArrayList<BoardDto> selectMyBoardList(String id);
	
	@Select("SELECT C_BNO AS CBNO, CCONTENT, CDATE, CHITS FROM COMMENTS WHERE CWRITER = #{id}")
	ArrayList<CommentDto> selectMyCommentList(String id);

	@Select("SELECT LSTATE, COUNT(*) AS LCOUNT FROM BOARDLIKE WHERE LBNO =${lbno} GROUP BY LSTATE ")
	ArrayList<LikeDto> selectBoardLike(int lbno);

	@Insert("INSERT INTO BOARDLIKE(LBNO, LMID, LSTATE) VALUES(${lbno},#{lmid},#{lstate})")
	int insertBoardState(LikeDto like);

	@Select("SELECT LMID FROM BOARDLIKE WHERE LBNO = ${lbno} AND LMID = #{lmid}")
	String selectLike(LikeDto like);
}
