package day15;

public class MemberMain {

	public static void main(String[] args) {
		//
		MemberManager manager = new MemberManager();
		
		boolean run = true;
		while(run) {
			String loginId = manager.getLoginId();
			// 메뉴 출력 및 선택 메소드 호출
			int selectMenu = manager.showMenu();
			System.out.println("선택한 메뉴 : " + selectMenu);
			switch(selectMenu) {
			case 1: 
				if(loginId == null) {
					// 회원가입 기능 메소드 호출
					manager.memberJoin();
				} else {
					manager.memberInfo();
				}
				
				break;
			case 2: 
				if(loginId == null) { // 로그인 기능 메소드 호출
					manager.memberLogin();
				} else {
					   //로그 아웃 기능 메소드 호출
					manager.memberLogout();
				}
				break;
			case 3: 
				if(loginId == null) {
					// 아이디 찾기 기능 메소드 호출
					manager.memberFind();
				} else {
					// 내정보 수정 기능 메소드 호출
					manager.memberUpdate();
				}
				
				break;
			case 4: // 종료
				run = false;
				break;
				
			}
			
			
			
			
		}

		
		
	}

}
