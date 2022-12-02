package com.MemberBoard001.dto;

import lombok.Data;

@Data
public class BoardLikeDto {
	private int lbno;
	private String lmid;
	private String lstate;
	//DB에서 따로 가져오기 위한 내용
	private int lcount;
}
