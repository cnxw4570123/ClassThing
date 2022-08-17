package day10;

import java.awt.Menu;
import java.util.Scanner;

public class Ex04_CoffeeMachine {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String[] menu = { "바닐라라떼", "카페라떼", "아이스티", "아메리카노", "종료" };
//		int[] price = { 5000, 4000, 3000, 2500 };
//		int[] order = new int[price.length]; // 몇 개 시켰는지 체크하기 위한 용도
//		int sum = 0;
//		int valid;
//		boolean run = true;
//		while (run) {
//			System.out.println("=====================================================");
//			for (int i = 0; i < menu.length; i++) {
//				System.out.print("[" + (i + 1) + "]" + menu[i] + " ");
//			}
//			System.out.println("");
//			System.out.println("=====================================================");
//			
//			System.out.print("메뉴선택>>");
//			int choice = sc.nextInt();
//			
//			switch (choice) {
//			case 1:
//				System.out.println("[" + menu[(choice - 1)] + " 선택]");
//				System.out.println("가격은 " + price[(choice - 1)] + "원입니다.");
//				System.out.print("주문하시겠습니까?([1]예 [2]아니오)>>");
//				valid = sc.nextInt();
//				if (valid == 1) {
//					order[choice - 1]++;
//					System.out.println("주문 되었습니다.");
//				} else if (valid == 2)
//					System.out.println("취소되었습니다.");
//				break;
//				
//			case 2:
//				System.out.println("[" + menu[(choice - 1)] + " 선택]");
//				System.out.println("가격은 " + price[(choice - 1)] + "원입니다.");
//				System.out.print("주문하시겠습니까?([1]예 [2]아니오)>>");
//				valid = sc.nextInt();
//				if (valid == 1) {
//					System.out.println("주문 되었습니다.");
//					order[choice - 1]++;
//				} else if (valid == 2)
//					System.out.println("취소되었습니다.");
//				break;
//				
//			case 3:
//				System.out.println("[" + menu[(choice - 1)] + " 선택]");
//				System.out.println("가격은 " + price[(choice - 1)] + "원입니다.");
//				System.out.print("주문하시겠습니까?([1]예 [2]아니오)>>");
//				valid = sc.nextInt();
//				if (valid == 1) {
//					System.out.println("주문 되었습니다.");
//					order[choice - 1]++;
//				} else if (valid == 2)
//					System.out.println("취소되었습니다.");
//				break;
//				
//			case 4:
//				System.out.println("[" + menu[(choice - 1)] + " 선택]");
//				System.out.println("가격은 " + price[(choice - 1)] + "원입니다.");
//				System.out.print("주문하시겠습니까?([1]예 [2]아니오)>>");
//				valid = sc.nextInt();
//				if (valid == 1) {
//					System.out.println("주문 되었습니다.");
//					order[choice - 1]++;
//				} else if (valid == 2)
//					System.out.println("취소되었습니다.");
//				break;
//				
//			case 5:
//				System.out.println("[종료 선택]");
//				System.out.println("주문이 종료되었습니다.");
//				run = false;
//			}
//			
//		}
//		
//		System.out.print("주문하신 메뉴는 ");
//		for (int i = 0; i < order.length; i++) {
//			if (order[i] > 0) {
//				System.out.print("[" + menu[i] + " " + order[i] + "잔]");
//				sum += order[i] * price[i];
//			}
//		}
//		System.out.println("이고\n총 주문 금액은 " + sum + "원 입니다.");

		Scanner sc = new Scanner(System.in);
		String[] menu = { "바닐라라떼", "카페라떼","아이스티", "아메리카노", "종료" };
		int[] price = { 5000, 4000, 3000, 2500 };
		
		int[] order = new int[menu.length - 1]; // 몇 개 시켰는지 체크하기 위한 용도
		int sum = 0;
		int valid;
		boolean run = true;
		while (run) {
			System.out.println("=====================================================");
			for (int i = 0; i < menu.length; i++) {
				System.out.print(" [" + (i + 1) + "]" + menu[i] + " ");
			}
			System.out.println("");
			System.out.println("=====================================================");

			System.out.print("메뉴선택>>");
			int choice = sc.nextInt();
			if (choice > 0 && choice < menu.length) {
				System.out.println("[" + menu[(choice - 1)] + " 선택]");
				System.out.println("가격은 " + price[(choice - 1)] + "원입니다.");
				System.out.print("주문하시겠습니까?([1]예 [2]아니오)>>");
				valid = sc.nextInt();
				if (valid == 1) {
					System.out.println("주문 되었습니다.");
					order[choice - 1]++;
				} else if (valid == 2)
					System.out.println("취소되었습니다.");
			} else if (choice == menu.length) {
				System.out.println("[종료 선택]");
				System.out.println("주문이 종료되었습니다.");
				run = false;
			}else {
				System.out.println("1 ~ " + menu.length + "까지의 수를 입력해주세요.");
			} 
		}
		System.out.print("주문하신 메뉴는 ");
		for (int i = 0; i < order.length; i++) {
			if (order[i] > 0) {
				System.out.print("[" + menu[i] + " " + order[i] + "잔]");
				sum += order[i] * price[i];
			}
		}
		System.out.println("이고\n총 주문 금액은 " + sum + "원 입니다.");
	}

}
