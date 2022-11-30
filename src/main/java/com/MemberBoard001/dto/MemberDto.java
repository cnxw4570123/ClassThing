package com.MemberBoard001.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MemberDto {
	private String mid;
	private String mpw;
	private String mname;
	private String mbirth;
	private String memail;
	private String maddr;
	private String mprofile;
	
	private MultipartFile mfile; //파일 형식 담을 필드
}
