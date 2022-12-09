package com.MemberBoard001.dto;

import lombok.Data;

@Data
public class TagoDto {
	//보낼때
	private String serviceKey;
	private int pageNo;
	private String numofRows;
	private String cityCode;
	private String nodeId;
	//받아올 때
	private String nodeid;
	private String routeid;
	private String routeno;
	private String routetp;
	private String arrprevstationcnt;
	private String vehicletp;
	private int arrtime;
}
