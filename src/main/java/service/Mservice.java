package service;

import dao.MemberDao;
import dto.MemberDto;

public class Mservice {
	private MemberDao mDao = new MemberDao();
	
	public int insertMemberInfo(MemberDto member) {
		System.out.println("msvc insertMemberInfo() 호출");
		int insertResult = mDao.insertMember(member);
		return insertResult;
	}

	public String selectMemberInfo(String logMemId, String logMemPw) {
		System.out.println("msvc selectMemberInfo() 호출");
		String lgResult = mDao.selectMember(logMemId, logMemPw);
		
		return lgResult;
	}

	public String selectIdCheck(String inputId) {
		System.out.println("msvc selectIdCheck() 호출");
		String checkResult = "";
		String selectRs = mDao.selectMemberDto(inputId).getMid();
		System.out.println("결과 " +selectRs);
		if(selectRs == null) {
			checkResult = "ok";
		} else {
			checkResult = "nope";
		}
		return checkResult;
	}

	public MemberDto selectMemInfo(String sesId) {
		MemberDto member = mDao.selectMemberDto(sesId);
		return member;
	}
}
