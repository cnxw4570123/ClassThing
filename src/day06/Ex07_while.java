package day06;

import java.util.Scanner;

public class Ex07_while {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
//		while(true) {
//			System.out.print("숫자입력(0:종료)>>>");
//			int inputNum = scan.nextInt();
//			System.out.println("입력한 숫자는 : " + inputNum);
//			if(inputNum == 0) {
//				break;
//			}
//		}
		//Math.random() =  double 타입의 0.0 ~ 0.9까지 만들어줌.
		int randomNumber = (int)(Math.random() * 10) + 1; 
//		System.out.println("randomNumber : " + randomNumber);
		
		while(true) {
			System.out.print("숫자 입력>>");
			int inputNumber = scan.nextInt();
			if(randomNumber == inputNumber){
				System.out.println("같은 숫자 입력했습니다.");
				System.out.println("종료");
				break;
			}
			else
				System.out.println("다른 숫자 입력했습니다.");
		}
	}
}
