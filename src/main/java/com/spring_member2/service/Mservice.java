package com.spring_member2.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_member2.dao.MemberDao;
import com.spring_member2.dto.MemberDto;


@Service
public class Mservice {
	
	@Autowired
	private MemberDao mDao;
	
	
	public int memberJoin(MemberDto member) {
		int insertResult = 0;
		System.out.println("회원가입 기능 호출");
		//dao - insert
		try {
			insertResult = mDao.insertMember(member);
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("insertResult : " + insertResult);
		
		return insertResult;
	}
	
	//회원목록 조회
	public ArrayList<MemberDto> memberList() {
		System.out.println("msvc memberList()");
		ArrayList<MemberDto> memberList = mDao.selectMemberList();
		System.out.println(memberList);
		return memberList;
	}

	public String MemberCheck(String testId, String testPw) {
		String loginId = "";
		System.out.println("msvc SelectMember()");
		try {
			loginId = mDao.selectMember(testId, testPw);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(loginId);
		return loginId;
	}
	
}
