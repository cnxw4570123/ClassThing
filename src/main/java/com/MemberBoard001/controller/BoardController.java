package com.MemberBoard001.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MemberBoard001.dto.BoardDto;
import com.MemberBoard001.dto.BoardLikeDto;
import com.MemberBoard001.dto.CommentDto;
import com.MemberBoard001.dto.CommentLikeDto;
import com.MemberBoard001.service.Bservice;

@Controller
public class BoardController {

	@Autowired
	private HttpSession session;

	@Autowired
	private Bservice bsvc;
	
	@RequestMapping(value = "/BoardList")
	public ModelAndView boardList() {
		System.out.println("전체글목록 페이지 이동 요청");
		ModelAndView mav = new ModelAndView();
		//1. 글목록 조회
		ArrayList<BoardDto> boardList = bsvc.getBoardList();
		//2. 글목록페이지 지정
		mav.addObject("boardList", boardList);
		mav.setViewName("Board/BoardList");
		return mav;
	}

	
	@RequestMapping(value="/BoardWriteForm")
	public ModelAndView boardWriteForm(RedirectAttributes ra) {
		System.out.println("글 작성 페이지 이동 요청");
		ModelAndView mav = new ModelAndView();
		
		if(session.getAttribute("loginID") != null) { // 1. 세션에 로그인 정보가 있으면
			System.out.println("로그인 정보 있음");
			mav.setViewName("Board/BoardWriteForm");
		} else { // 2. 세션에 로그인 정보가 없으면
			System.out.println("로그인 정보 없음");
			ra.addFlashAttribute("msg", "로그인 후 이용 가능합니다!");
			mav.setViewName("redirect:/MemberLoginForm");
		}
		return mav;
	}
	
	
	@RequestMapping(value="/BoardWrite")
	public ModelAndView boardWrite(BoardDto boardInfo, RedirectAttributes ra) throws IllegalStateException, IOException {
		System.out.println("글 작성 요청");
		ModelAndView mav = new ModelAndView();
		System.out.println(boardInfo);
		
		//세션에서 작성자 정보 가져와 boardInfo에 할당
		String mid = (String)session.getAttribute("loginID");
		System.out.println("아이디 : " + mid); 
		boardInfo.setBwriter(mid);
		int insertRs = bsvc.insertBoardInfo(boardInfo);
		
		if(insertRs > 0) { // 글 작성 완료 시 
			mav.setViewName("redirect:/BoardList");
		} else { // 글 작성 실패 시
			ra.addFlashAttribute("msg", "글 작성에 실패했습니다.");
			mav.setViewName("redirect:/BoardWriteForm");
		}
		return mav;
	}
	
	@RequestMapping(value="/BoardContent")
	public ModelAndView boardContent(@Param("bno") int bno) {
		ModelAndView mav = new ModelAndView();
		System.out.println("글 내용 보기 요청");
		System.out.println("글번호 : " + bno); //글번호 전송 
		BoardDto boardInfo = bsvc.getBoard(bno);
		mav.addObject("board", boardInfo);
		mav.setViewName("/Board/BoardContent");
		return mav;
	}
	
	@RequestMapping(value="/BoardRevise")
	public ModelAndView boardRevise(String rtitle, String rcontent, int rbno, RedirectAttributes ra) {
		System.out.println("글 수정 요청");
		ModelAndView mav = new ModelAndView();
		System.out.println("수정 글 번호 : " + rbno +"\n수정 제목 : " + rtitle + "\n수정 내용 : " + rcontent);
		int updateRs = bsvc.updateBoardInfo(rtitle, rcontent, rbno);
		if(updateRs > 0 ) {
			System.out.println("수정 성공");
			mav.setViewName("redirect:/BoardList");
		} else {
			System.out.println("수정 성공");
			ra.addFlashAttribute("msg", "글 수정에 실패했습니다.");
			mav.setViewName("redirect:/BoardRevise");
		}
		return mav;
	}
	
	@RequestMapping(value="/CommentWrite")
	public @ResponseBody String commentInsert(CommentDto comment) {
		System.out.println("댓글 작성 요청");
		String key = "NOPE";
		System.out.println(comment);
	    int insertRs = bsvc.commentWrite(comment);
	    if(insertRs > 0) {
	    	System.out.println("작성 성공");
	    	key = "OK";
	    }
		
		return key;
	}
	
	@RequestMapping(value="/CommentList")
	public @ResponseBody String commentList(int cbno) {
		System.out.println("댓글 리스트 보기 요청");
		String replyList = bsvc.replyList(cbno);
		System.out.println("글 번호 : "+ cbno);
		return replyList;
	}
	
	@RequestMapping(value="/CommentRevise")
	public @ResponseBody String commentRevise(int cno, String ccontent) {
		System.out.println("댓글 수정 기능 요청");
		String updateMsg = "NOPE";
		
		int updateRs = bsvc.comRevise(cno, ccontent);
		
		if(updateRs > 0) {
			updateMsg = "done";
		}
		return updateMsg;
	}
	
	@RequestMapping(value="/CommentDelete")
	public @ResponseBody String commentDelete(int cno) {
		System.out.println("댓글 삭제 기능 요청");
		String result = "NOPE";
		
		int delRs = bsvc.comDelete(cno);
		
		if(delRs > 0) {
			result ="done";
		}
		return result;
	}
	
	@RequestMapping(value="/BoardStateCount")
	public @ResponseBody String boardStateCount(int lbno) {
		System.out.println("상태 개수 출력 기능 호출");
		String selectRs = bsvc.getBoardLike(lbno);
		System.out.println(selectRs);
		return selectRs;
	}
	
	
	@RequestMapping(value="/BoardLike") //좋아요나 싫어요 버튼 누르면
	public @ResponseBody String boardLike(BoardLikeDto like) {
		String result = "비추천";
		if(like.getLstate().equals("0")) {
			result="추천";
		}
		System.out.println("좋아요 기능 호출");
		System.out.println(like);
		
		//구현할 기능 -> 먼저 같은 아이디와 글에 추천이 있는지 조회 후 없으면 추천 삽입
		int insertRs = bsvc.boardStateInsert(like);
		if(insertRs == -1) {
			result= insertRs +"";
		}
		return result;
	}
	
	@RequestMapping("/ComLikeCount")
	public @ResponseBody String comLikeCount(int cbno){
		System.out.println("댓글 추천수 조회 기능 호출");
		String likeJson = bsvc.getComLikeCount(cbno);
		System.out.println(likeJson);
		return likeJson;
	}
	
	@RequestMapping("/ComLike")
	public @ResponseBody String comLike(CommentLikeDto commentLike) {
		System.out.println("댓글 추천 기능 호출");
		int insertRs = bsvc.doCommentLike(commentLike);
		String likeRs = "Nope";
		if(insertRs > 0) {
			likeRs = "YEPP";
		} else if(insertRs == -1) {
			likeRs = "YOUDID";
		}
		return likeRs;
	}
}
