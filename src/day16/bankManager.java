package day16;

import java.util.ArrayList;
import java.util.Scanner;

public class bankManager {
	private Scanner sc = new Scanner(System.in);
	
	public int ShowMenu() {
		
		System.out.println("============================================================");
		System.out.print("[1]계좌생성 |[2]입금 | [3]출금 | [4]잔액 | [5]이체 | [6]고객리스트 | [7]종료 ");
		System.out.println("\n============================================================");
		System.out.print("메뉴선택>>");
		return sc.nextInt();
	}
	
//	private boolean checkAcc(ArrayList<BankInfo> bk, String num) {
//		for(int i = 0; i < bk.size(); i++) {
//			if(bk.get(i).getAccountNumber().equals(num))
//				return true;
//		}
//		return false;
//	}
	private ArrayList<BankInfo> accountList = new ArrayList<BankInfo>();
	private String checkAcc() {
		String acc;
		while(true) {
			System.out.print("계좌번호 입력>>");
			acc = sc.next();
			boolean check = true;
			for(int i = 0; i < accountList.size(); i++) {
				if(accountList.get(i).getAccountNumber().equals(acc)) {
					check = false;
				}
			}
			if(check) {
				break;
			}
			else
				System.out.println("이미 사용중인 계좌번호입니다.\n다시 입력해주세요.");
		}
		return acc;
	}
	public void createAccount() {
		System.out.println("[계좌생성] :" + accountList.size());
		BankInfo newAccount = new BankInfo();
//		System.out.print("계좌번호>>");
		newAccount.setAccountNumber(checkAcc());
		System.out.print("고객이름>>");
		newAccount.setClientName(sc.next());
		System.out.print("입금액>>");
		newAccount.setBalance(sc.nextInt());
		accountList.add(newAccount);
		System.out.println(newAccount);
		System.out.println("신규 계좌가 등록 되었습니다.");
	}
}
