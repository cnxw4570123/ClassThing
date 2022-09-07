package day08;

import java.util.Scanner;

public class Ex05_Atm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int bankAcc = 0; // 배열로 여러 명이 관리하는 계좌 잔액으로 바뀐다.
		boolean run = true;
		
		loop : while(run) {
			System.out.println("\n=================================");
			System.out.println("[1]입금 | [2]출금 | [3]잔액 | [4]종료");
			System.out.println("=================================");
			System.out.print("메뉴 선택>>");
			
			int select = sc.nextInt();
			int money = 0;
			switch(select) {
			case 1:
				System.out.println("[입금]");
				System.out.print("입금하실 금액을 입력해주세요>>");
				money = sc.nextInt();
				bankAcc += money;
				System.out.println("입금후 잔액은 "+ bankAcc + "원 입니다.");
				break;
				
			case 2:
				System.out.println("[출금]");
				System.out.print("출금하실 금액을 입력해주세요>>");
				money = sc.nextInt();
				if(bankAcc >= money) {
					bankAcc -= money;
					System.out.println("출금후 잔액은 "+ bankAcc + "원 입니다.");
				} else {
					System.out.println("출금하려는 금액이 잔액보다 큽니다.");
					System.out.println("현재 잔액은 "+ bankAcc + "원 입니다.");
				}
				break;
				
			case 3:
				System.out.println("[잔액]");
				System.out.println("현재 잔액은 "+ bankAcc + "원 입니다.");
				break;
				
			case 4:
				System.out.println("[종료]");
//				run = false;
				break loop;
				
			default:
				System.out.println("1 ~ 4까지의 메뉴를 눌러 주세요.");
				continue loop;
					
			}
		}
		
	}

}
