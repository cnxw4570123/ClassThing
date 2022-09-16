package day16;

public class BankMain {

	public static void main(String[] args) {
	 bankManager manager = new bankManager();
	 
	 boolean run = true;
	 
	 while(run) {
		 int selectMenu = manager.ShowMenu();
		 
		 switch(selectMenu) {
		 case 1: //계좌 생성
			 manager.createAccount();
			 break;
		 case 2:
			 manager.deposit();
			 break;
		 case 3:
			 manager.withdraw();
			 break;
		 case 4:
			 manager.presBalance();
			 break;
		 case 5:
			 manager.transfer();
			 break;
		 case 6:
			 manager.clientList();
			 break;
			 default:
				 System.out.println("종료");
				 run = false;
		 }
	 }
	 /*[6] 고객리스트
	   	   -accountList에 있는 모든 고객의 정보를 출력
	   	   -BankInfo타입의 객체 (계좌번호, 이름, 금액)
	   	   
	   [1] 입금
	   	   - 1. 입금할 계좌를 확인
	   	   		사용자로부터 계좌번호 입력 받는다.
	   	   		입력받은 계좌번호가 등록된 계좌인지 확인.(인덱스값 조회)
	   	   		입력받은 금액만큼 해당 계좌의 잔액을 추가
	   	   		입금처리 후 잔액을 출력
	   	   		
	   	   		등록된 계좌가 아닐 경우 "없는 계좌번호 입니다" 출력
	   [2] 출금
	    - 출금할 계좌를 확인
	    - 등록된 계좌로 확인 되면 '출금할 금액'을 입력 받는다.
	    - 계좌의 잔액이 출금액 보다 많으면 출금 처리 및 잔액 출력
	   	  계좌의 잔액이 출금액 보다 적으면 '찬액이 부족합니다' 출력
	   	  
	   	- 등록된 계좌가 아닐 경우 "없는 계좌번호 입니다" 출력
	   	
	   [5] 이체
	   	- 보내는 사람의 계좌(출금), 받는 사람의 계좌(입금)
	   	- 1. 보내는 사람의 계좌 확인
	   	- 2. 보내는 사람의 계좌가 확인 되면 "이체할 금액"을 입력
		- 3. 이 때 잔액 체크해도 됨.
	   	
	   	- 3. 받는 사람의 계좌 확인
	   	- 4. 받는 사람의 계좌가 확인 되면
	   		 보내는 사람의 계좌의 잔액 확인
	   	  5. 보내는 사람의 계좌의 잔액이 충분할 경우
	   	- 	 보내는 사람의 계좌(출금처리), 받는 사람의 계좌(입금처리)
	  */
	}

}
