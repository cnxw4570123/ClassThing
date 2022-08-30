package day19;

import java.util.Scanner;

public class Ex04_TryCatch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		while(run) {
			System.out.println(" [1]입력 | [2]출력 | [3]종료");
			System.out.print("메뉴선택>>");
			int com = -1;
			
			try {
				com = Integer.parseInt(sc.next());
			} catch(NumberFormatException e) {
				System.out.println("메뉴는 숫자로 입력 해주세요.");
				continue;
			}
			switch(com) {
			case 1:
				System.out.println("[1]입력");
				break;
			case 2:
				System.out.println("[2]입력");
				break;
			case 3:
				System.out.println("[3]종료");
				run = false;
				break;
			default:
				System.out.println("잘못 입력 했습니다.");
					
			}
		}
		
	}

}
