package day16;

import java.util.ArrayList;
import java.util.Scanner;

public class bankManager {
	private Scanner sc = new Scanner(System.in);
	private ArrayList<BankInfo> accountList = new ArrayList<BankInfo>();

	public int ShowMenu() {

		System.out.println("============================================================");
		System.out.print("[1]계좌생성 |[2]입금 | [3]출금 | [4]잔액 | [5]이체 | [6]고객리스트 | [7]종료 ");
		System.out.println("\n============================================================");
		System.out.print("메뉴선택>>");
		return sc.nextInt();
	}
	public void createAccount() {
		
		System.out.println("[계좌생성] :" + accountList.size());
		BankInfo newAccount = new BankInfo();
		newAccount.setAccountNumber(checkAcc());
		System.out.print("고객이름>>");
		newAccount.setClientName(sc.next());
		System.out.print("입금액>>");
		newAccount.setBalance(sc.nextInt());
		accountList.add(newAccount);
		System.out.println(newAccount);
		System.out.println("신규 계좌가 등록 되었습니다.");
	}

	// 계좌 번호 체크
	private int searchIdx(String acc) {
		int idx = -1;
		for (int i = 0; i < accountList.size(); i++) { //겹칠 때만 idx값 변화
			if (accountList.get(i).getAccountNumber().equals(acc)) {
				idx = i;
				break;
			}
		}// 중복이 아니면 -1반환
		return idx;
	}
	private String checkAcc() {
		String acc;
		while (true) {
			System.out.print("계좌번호 입력>>");
			acc = sc.next();
			int idx = searchIdx(acc);
			
			if (idx == -1) {
				break;
			} else
				System.out.println("이미 사용중인 계좌번호입니다.\n다시 입력해주세요.");
		}
		return acc;
	}

	public void deposit() {
		System.out.println("[입금]");
		System.out.print("입금하실 ");
		System.out.print("계좌번호 입력>>");
		int index = searchIdx(sc.next());
		if (index > -1) {
			System.out.print("입금하실 금액을 입력해주세요>>");
			int depo = sc.nextInt();
			accountList.get(index).setBalance(accountList.get(index).getBalance() + depo);
			System.out.println("입금 후 잔액은 " + accountList.get(index).getBalance() + "원입니다.");
		} else {
			System.out.println("없는 계좌번호 입니다.");
		}
	}

	public void withdraw() {
		System.out.println("[출금]");
		System.out.print("출금하실 ");
		System.out.print("계좌번호 입력>>");
		int index = searchIdx(sc.next());
		if (index > -1) {
			System.out.print("출금하실 금액을 입력해주세요>>");
			int with = sc.nextInt();
			if (accountList.get(index).getBalance() >= with) {
				accountList.get(index).setBalance(accountList.get(index).getBalance() - with);
				System.out.println("출금 되었습니다.");
			} else {
				System.out.println("잔액이 부족합니다.");
			}
			System.out.println("현재 잔액은 " + accountList.get(index).getBalance() + "원 입니다.");
		} else {
			System.out.println("없는 계좌번호 입니다.");
		}
	}
	
	public void presBalance() {
		System.out.println("[잔액]");
		System.out.print("계좌 번호 >>");
		int idx = searchIdx(sc.next());
		if(idx > -1) {
			BankInfo account = accountList.get(idx);
			System.out.println(account.getClientName()+"님의 현재 잔액은 " + account.getBalance() + "입니다.");
		} else {
			System.out.println("없는 계좌 번호입니다.");
		}
	}
	
	public void transfer() {
		System.out.println("[이체]");
		int src, dest;
		System.out.print("보내시는 분 계좌 번호 >>");
		src = searchIdx(sc.next());
		if(src> -1) {
			System.out.print("이체할 금액 입력>>");
			int transfB = sc.nextInt();
			int srcB = accountList.get(src).getBalance();
			if(srcB >= transfB) {
				System.out.print("받으시는 분 계좌 번호>>");
				dest = searchIdx(sc.next());
				if(dest > - 1) {
					int destB = accountList.get(dest).getBalance();
					accountList.get(src).setBalance(srcB - transfB);
					accountList.get(dest).setBalance(destB + transfB);
					System.out.println("보내시는 분의 계좌 번호는 " + accountList.get(src).getAccountNumber()+ "이고 이체 후 금액은 "+ accountList.get(src).getBalance()+"원입니다.");
					System.out.println("받으시는 분의 계좌 번호는 " + accountList.get(dest).getAccountNumber()+ "이고 이체 후 금액은 "+ accountList.get(dest).getBalance()+"원입니다.");
				} else {
					System.out.println("등록되지 않은 계좌 번호입니다.");
				}
			} else {
				System.out.println("잔액이 부족합니다.");
			}
		}else {
			System.out.println("등록되지 않은 계좌 번호입니다.");
		}
	}

	public void clientList() {
		for (int i = 0; i < accountList.size(); i++) {
			System.out.print("[" + (i + 1) + "번 고객]");
			System.out.print(" 계좌:" + accountList.get(i).getAccountNumber());
			System.out.print(" 고객명:" + accountList.get(i).getClientName());
			System.out.print(" 잔액:" + accountList.get(i).getBalance() + "\n");
		}
	}



}
