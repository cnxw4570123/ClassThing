package com.MemberBoard001.dto;

import lombok.Data;

@Data
public class LikeDto {
	private int lbno;
	private String lmid;
	private String lstate;
	//DB에서 따로 가져오기 위한 내용
	/*
	 lhate와 lstate는 쓸지는 모르겠지만 일단 활용해보려고함.
	 DB조회시 컬럼은 두개만 나옴 0, 개수 | 1, 개수 
	 */
	private String lhate;
	private String llike;
	private int lcount;
}
