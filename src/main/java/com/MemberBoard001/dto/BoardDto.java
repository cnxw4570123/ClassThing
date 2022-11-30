package com.MemberBoard001.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardDto {
	// form태그로 받아오는 값들
	private String btitle;
	private String bcontent;
	private MultipartFile bfile;
	private String bfilename;
	//생성 해줘야 할 값들
	private int bno;
	private String bwriter;
	private String bdate;
	private int bhits;
	private String bstate;
}
