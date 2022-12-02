package com.MemberBoard001.dto;

import lombok.Data;

@Data
public class CommentDto {
	private int cno;
	private String cwriter;
	private String ccontent;
	private int chits;
	private String cdate;
	private String cbno; //참고할 글 번호 
	private String cstate;
	
	private int cLike; // 추천개수
}
