package com.MemberBoard001.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.MemberBoard001.dao.MemberDao;
import com.MemberBoard001.dto.MemberDto;

@Service
public class Mservice {
	@Autowired 
	private MemberDao mDao;
	
	@Autowired
	private ServletContext context;
	
	
	public int memberJoin(MemberDto member) throws IllegalStateException, IOException {
		System.out.println("msvc memberJoin()");
		MultipartFile mfile = member.getMfile(); //member 객체에서 파일 정보 뽑기
		String mprofile = "";

		//2. 파일을 저장 => 저장할 경로 설정
		if(mfile.isEmpty()) { // 프로필 이미지 파일을 업로드 하지 않았을 경우
			System.out.println("첨부 파일이 없습니다.");
		} else {
			System.out.println("첨부 파일이 없습니다.");
			UUID uuid = UUID.randomUUID();// universal unique id 즉, 임의 고유번호 만들어준다.
			//System.out.println(mfile.getOriginalFilename() + "_" + uuid.toString());
			mprofile = uuid.toString()+  "_" + mfile.getOriginalFilename(); // + 넘버링하는 것이 좋다. 중복 가능성 있기 때문
			//파일 저장
			// 1. 저장위치
			//J:\spring_workspace\MemberBoard001\src\main\webapp\resources\MemberProfile 이는 본인컴퓨터 기준이므로 실제로 사용시에는 부적합
			String savePath = context.getRealPath("resources\\MemberProfile"); // 각 host마다 path를 잡아주므로 문제가 생기지 x
			System.out.println("주소 : " + savePath);
			// 2. 파일 저장기능 호출
			File file = new File(savePath, mprofile);
			mfile.transferTo(file);
		}
		System.out.println("mprofile : " +mprofile);
		member.setMprofile(mprofile);
		
		//3. 회원가입처리
		int insertRs = 0;
		try {
			insertRs = mDao.insertMember(member); 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return insertRs;
	}

	public String memberIdCheck(String inputID) {
		System.out.println("msvc memberIdCheck()");
		String retId = null;
		try {
			retId = mDao.selectMid(inputID);
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("returnID : " + retId);
		return retId;
	}
	
	public MemberDto getMemberLogin(String mid, String mpw) {
		System.out.println("msvc getMemberLogin()");
		MemberDto member = null;
		
		try {
			member = mDao.selectLogResult(mid, mpw);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}
	
	public MemberDto getMemberInfo(String mid) { //세션 아이디로 회원정보 조회
		System.out.println("msvc getMemberInfo()");
		MemberDto member = null;
		
		try {
			member = mDao.selectMember(mid);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return member;
	}

}
