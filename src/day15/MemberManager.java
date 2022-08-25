package day15;

import java.util.Scanner;

public class MemberManager {
	// 기능 정의
	private Scanner scan = new Scanner(System.in);
	
	private String loginId = null; // 로그인 처리된 아이디 저장
	
	private int loginIdx = -1;
	
	public String getLoginId() {
		return loginId;
	}

	// 메뉴 출력 및 선택 메소드
	public int showMenu() {
		if( loginId == null) {
			System.out.println("\n===================================================");
			System.out.println(" [1]회원가입 | [2]로그인 | [3]아이디찾기 | [4]종료");
			System.out.println("===================================================");
		} else {
			System.out.println("\n===================================================");
			System.out.println(" [1]내정보 | [2]로그아웃 | [3]내정보수정 | [4]종료");
			System.out.println("===================================================");
		}
		System.out.print("메뉴선택>>");			
		int selectMenu = scan.nextInt(); // 
		return selectMenu;
	}
	
	private MemberInfo[] memberList = new MemberInfo[100];
	private int memberCount = 0;
	
	private String idCheck() {
		String mid;
		while(true) {
			System.out.print("가입할 아이디>>");
			mid = scan.next();
			boolean check = true; 
			for(int i = 0; i < memberList.length; i++) {
				if(memberList[i] != null) {
					if( memberList[i].getMid().equals(mid)  ) {
						//아이디 중복일 경우 실행
						check = false;
					}
				}
			}
			if(check) {
				break;
			} else {
				System.out.println("이미 사용중인 아이디 입니다.");
			}
		}
		
		return mid;
	}
	
	//회원 가입 기능 메소드
	public void memberJoin() {
		System.out.println("[회원가입]");
		String mid = idCheck();
		System.out.print("가입할 비밀번호>>");
		String mpw = scan.next();
		System.out.print("가입할 이름>>");
		String mname = scan.next();
		System.out.print("가입할 이메일>>");
		String memail = scan.next();
		System.out.print("가입할 전화번호>>");
		String mphone = scan.next();
		MemberInfo member = new MemberInfo();
		member.setMid(mid);
		member.setMpw(mpw);
		member.setMname(mname);
		member.setMemail(memail);
		member.setMphone(mphone);
		
		memberList[memberCount] = member;
		memberCount++;
		if(memberCount == memberList.length) {
			memberCount = 0;
		}
		System.out.println("회원가입 되었습니다.");
	}
	
	// 로그인 기능 메소드
	public void memberLogin() {
		System.out.println("[로그인]");
		System.out.print("아이디>>");
		String userId = scan.next();
		System.out.print("비밀번호>>");
		String userPw = scan.next();	
		// 입력한 아이디, 비밀번호
		// 일치하는 회원정보가 있을 경우
		//    "로그인 되었습니다."
		// 일치하는 회원정보가 없을 경우
		//    "아이디/비밀번호가 일치하지 않습니다."
		int idx = -1;
		for( int i = 0; i < memberList.length; i++) {
			if(memberList[i] != null) {
				if( userId.equals(memberList[i].getMid()) 
						&& userPw.equals(memberList[i].getMpw())  ) {
					idx = i;
				}
			}
		}
		if(idx > -1) {
			System.out.println("로그인 되었습니다.");
			loginId = memberList[idx].getMid();
			loginIdx = idx;
		} else {
			System.out.println("아이디/비밀번호가 일치하지 않습니다.");
		}
		
	}

	//로그아웃 기능 메소드
	public void memberLogout() {
		System.out.println("로그아웃 되었습니다.");
		loginId = null;
		loginIdx = -1;
	}
	
	// 내정보 조회 기능 메소드
	public void memberInfo() {
		System.out.println("[내정보]");
		int idx = -1;
		for(int i = 0; i < memberList.length; i++) {
			if(memberList[i] != null) {
				if(loginId.equals(memberList[i].getMid())) {
					idx = i;
				}
			}
		}
		System.out.println("[아이디]" + memberList[idx].getMid());
		System.out.println("[이름]" + memberList[idx].getMname());
		System.out.println("[이메일]" + memberList[idx].getMemail());
		System.out.println("[전화번호]" + memberList[idx].getMphone());
		
		System.out.println();
		System.out.println("[아이디]" + memberList[loginIdx].getMid());
		System.out.println("[이름]" + memberList[loginIdx].getMname());
		System.out.println("[이메일]" + memberList[loginIdx].getMemail());
		System.out.println("[전화번호]" + memberList[loginIdx].getMphone());		
	}
	
	

	public void memberFind() {
		System.out.println("[아이디 찾기]");
		System.out.print("이름 입력>>");
		String userName = scan.next();
		System.out.print("이메일 입력>>");
		String userEmail = scan.next();
		int idx = -1;
		for( int i = 0; i < memberList.length; i++) {
			if(memberList[i] != null) {
				if( userName.equals(memberList[i].getMname()) 
						&& userEmail.equals(memberList[i].getMemail())  ) {
					idx = i;
				}
			}
		}
		if( idx > -1 ) {
			System.out.println("아이디는 [" + memberList[idx].getMid()+ "] 입니다.");
		} else {
			System.out.println("일치하는 회원 정보가 없습니다.");
		}
		
		
		
	}

	public void memberUpdate() {
		System.out.println("[내정보수정]");
		int idx = -1;
		for(int i = 0; i < memberList.length; i++) {
			if(memberList[i] != null) {
				if(loginId.equals(memberList[i].getMid())) {
					idx = i;
				}
			}
		}
		
		
		
		
		System.out.print("새로운 이메일 입력>>");
		String memail = scan.next();
		System.out.print("새로운 전화번호 입력>>");
		String mphone = scan.next();
		memberList[idx].setMemail(memail);
		memberList[idx].setMphone(mphone);
		System.out.println("정보가 수정 되었습니다.");
		
		
		
	}
	
}


















