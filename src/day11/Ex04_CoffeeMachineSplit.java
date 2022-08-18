package day11;

import java.util.Scanner;

public class Ex04_CoffeeMachineSplit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] menu = { "바닐라라떼:5000", "카페라떼:4000", "아이스티:3000",
						  "꿀아메리카노:2500", "아메리카노:2500" };

		int[] order = new int[menu.length]; // 몇 개 시켰는지 체크하기 위한 용도
		int sum = 0;
		int valid;
		boolean run = true;
		boolean check = false;
		while (run) {
			System.out.println("=====================================================");
			for (int i = 0; i < menu.length; i++) {
				System.out.print(" [" + (i + 1) + "]" + menu[i].split(":")[0] + " ");
			}
			System.out.print("[" + (menu.length + 1) + "]종료");
			System.out.println("");
			System.out.println("=====================================================");

			System.out.print("메뉴선택>>");
			int choice = sc.nextInt();
			if (choice > 0 && choice <= menu.length) {
				System.out.println("[" + menu[(choice - 1)].split(":")[0] + " 선택]");
				System.out.println("가격은 " + menu[(choice - 1)].split(":")[1] + "원입니다.");
				System.out.print("주문하시겠습니까?([1]예 [2]아니오)>>");
				valid = sc.nextInt();
				if (valid == 1) {
					System.out.println("주문 되었습니다.");
					order[choice - 1]++;
					check = true;
				} else
					System.out.println("취소되었습니다.");
			} else if (choice == menu.length + 1) {
				System.out.println("[종료 선택]");
				System.out.println("주문이 종료되었습니다.");
				run = false;
			} else {
				System.out.println("1 ~ " + menu.length + "까지의 수를 입력해주세요.");
			}
		}
		
		if(check) {
			System.out.print("주문하신 메뉴는 ");
			for (int i = 0; i < order.length; i++) {
				if (order[i] > 0) {
					System.out.print("[" + menu[i].split(":")[0] + " " + order[i] + "잔]");
					sum += order[i] * Integer.parseInt(menu[(i)].split(":")[1]);
				}
			}
			System.out.println("이고\n총 주문 금액은 " + sum + "원 입니다.");
		}
	}

}
