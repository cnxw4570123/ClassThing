package com.MemberBoard001.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.MemberBoard001.dao.BoardDao;
import com.MemberBoard001.dto.BoardDto;
import com.MemberBoard001.dto.CommentDto;
import com.google.gson.Gson;

@Service
public class Bservice {
	@Autowired
	BoardDao bDao;
	@Autowired
	ServletContext context;

	public int insertBoardInfo(BoardDto boardInfo) throws IllegalStateException, IOException {
		System.out.println("bsvc boardInfo()");
		//파일 이름 기본 생성 -> myBatis가 null값 처리는 힘들어함.
		String bfileName = "";
		// 파일 정보 받아오기
		MultipartFile bfile = boardInfo.getBfile();
		
		if(bfile.isEmpty()) { //파일이 없으면
			System.out.println("첨부파일 없음");
		} else { //있으면
			System.out.println("첨부 파일 있음");
			// 파일 저장할 위치 지정
			String bfsavePath =  context.getRealPath("resources/BoardUpload");
			// 랜덤넘버 포함한 파일명 생성후 지정
			bfileName = UUID.randomUUID() + "_" + bfile.getOriginalFilename();
			boardInfo.setBfilename(bfileName);
			//파일 객체 생성 후 이전
			File file = new File(bfsavePath, bfileName);
			bfile.transferTo(file);
		}
		int insRs = 0;
		try {
			//글 번호 자동 생성 후 할당
			int bMaxNum = bDao.selectMaxbNum() + 1;
			boardInfo.setBno(bMaxNum);
			System.out.println(boardInfo.toString());
			insRs = bDao.insertBoard(boardInfo);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return insRs;
	}

	public ArrayList<BoardDto> getBoardList() {
		ArrayList<BoardDto> boardList = new ArrayList<BoardDto>();
		try {
			boardList = bDao.selectBoardList();
		} catch(Exception e){
			e.printStackTrace();
		}
		return boardList;
	}

	public BoardDto getBoard(int bno) {
		System.out.println("bsvc getBoard()");
		BoardDto board = null;
		int updateResult= 0; 
		try {
			updateResult = bDao.updateHits(bno); // 글 조회하기 전에 조회수 +1
			board = bDao.selectBoard(bno);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return board;
	}

	public int updateBoardInfo(String rtitle, String rcontent, int rbno) {
		System.out.println("bsvc updateBoardInfo");
		int updateRs = 0;
		try {
			updateRs = bDao.updateBoard(rtitle, rcontent, rbno);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return updateRs;
	}

	public int commentWrite(CommentDto comment) {
		System.out.println("bsvc commentWrite()");
		int insertRs = 0;
		
		try {
			insertRs = bDao.insertComment(comment);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return insertRs;
	}

	public String replyList(int cbno) {
		System.out.println("bsvc replyList()");
		ArrayList<CommentDto> comList = bDao.getCommentList(cbno);
		System.out.println(comList);
		Gson gson = new Gson(); //arrayList를 json으로 변환
		String comList_json = gson.toJson(comList);
		System.out.println(comList_json);
		return comList_json;
	}

	public int comDelete(int cno) {
		System.out.println("bsvc comDelete()");
		int delRs = 0;
		
		try {
			delRs = bDao.deleteCom(cno);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return delRs;
	}

	public int comRevise(int cno, String ccontent) {
		System.out.println("bsvc comRevise()");
		int updateRs = 0;
		
		try {
			updateRs = bDao.updateComment(cno, ccontent);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return updateRs;
	}
}
