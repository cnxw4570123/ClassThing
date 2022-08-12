package day08;

import java.util.Scanner;

public class Ex03_vendingMachine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("커피 자판기");
		
		int stock = 10; // 커피 재고
		int price = 500; // 커피 가격
		boolean run = true; // 커피자판기 실행 여부
		while(run) {
			System.out.println("\n==========");
			System.out.println("||[1]구매||\n||[2]취소||"); //개행문자
			System.out.println("==========");
			System.out.print("메뉴 선택>>");
			int select = sc.nextInt();
			
			if(select == 1) {
				System.out.print("돈을 넣어주세요>>");
				int coin = sc.nextInt();
				if(coin >= price) {
					System.out.println("커피 한잔을 판매");
					coin -= price;
					stock--;
					if(coin > 0) 
						System.out.println("거스름돈 " + coin + "원을 돌려줍니다.");
				}
				else {
					System.out.println("잔액이 부족합니다.");
					System.out.println(coin + "원을 되돌려 줍니다.");
//					run = false;
//					System.out.println("종료");
//					break;
				}
			}
			else
				System.out.println("취소되었습니다.");
			
			System.out.println("남은 커피의 재고는 " + stock + "잔 입니다.");
			
			if(stock <= 0) {
				System.out.println("커피의 재고가 모두 소진되었습니다.");
				run = false;
			}
		}
	}
		/*
		 * while loop 한번 더
		 * if select = 1 then
		 * 	while coin < price do
		 * 		print "금액을 넣어주세요"
		 * 		coin += sc.nextInt();
		 * 		if coin < price then
		 * 			print "금액이 부족합니다."
		 * 		else
		 * 			coin -= price;
		 * 			print "커피 한잔을 판매하고 거스름돈 " + coin + "원을 되돌려 줍니다."
		 * 
		 */
}
