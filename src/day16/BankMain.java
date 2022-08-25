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
			 break;
		 case 3:
			 break;
		 case 4:
			 break;
		 case 5:
			 break;
		 case 6:
			 break;
			 default:
				 System.out.println("종료");
				 run = false;
		 }
	 }
	}

}
