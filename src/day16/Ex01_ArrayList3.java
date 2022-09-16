package day16;

import java.util.ArrayList;

import day15.MemberInfo;

public class Ex01_ArrayList3 {

	public static void main(String[] args) {
		ArrayList<MemberInfo> memberList = new ArrayList<MemberInfo>();
		
		String mid = "아이디";
		String mpw = "비밀번호";
		String mname = "이름";
		String memail = "이메일";
		String mphone = "전화번호";
		
			MemberInfo member = new MemberInfo();
			member.setMid(mid);
			member.setMpw(mpw);
			member.setMname(mname);
			member.setMemail(memail);
			member.setMphone(mphone);
			memberList.add(member);			
			
			System.out.println("mid : " + memberList.get(0).getMid());
			System.out.println("memail : " + memberList.get(0).getMemail());
			String newEmail = "새 이메일";
			memberList.get(0).setMemail(newEmail);
			System.out.println("memail : " + memberList.get(0).getMemail());
			memberList.get(0);
	}
	
	//제출 날짜랑 수요일이랑 같으면 true(1)
}
