package com.MemberBoard001.dto;

import lombok.Data;

@Data
public class CommentLikeDto {
	private String likemid;
	private int likecno;
	private String likestate;
	private int likecount;
}
