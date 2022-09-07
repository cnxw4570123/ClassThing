package day07;

import java.util.Scanner;

public class Ex08_while_Dice {

	public static void main(String[] args) {

////	1. 1 ~ 6 사이의 눈을 갖는 주사위 변수 선언
//		int diceNum = (int)(Math.random() * 6) + 1;
////	2. 목표값 숫자 입력
//		Scanner sc = new Scanner(System.in);
//		System.out.print("목표값 입력>>");
//		int targetNum = sc.nextInt();
//		System.out.println(targetNum);
		
		/*
		 * 1. 사용자로부터 목표값 입력 받고
		 * 2. 주사위 던졌을 때 주사위의 눈과 목표값이 일치하는지 확인
		 * 3. 일치하지 않으면 주사위를 다시 던져서 주사위의 눈을 확인
		 * 4. 목표값과 주사위의 눈이 일치할 때 까지 주사위를 던진 횟수 출력
		 * int diceNum -> (int)(Math.random() * 6) + 1
		 * int targetNum -> input number
		 * int cnt = 0;
		 * while targetNumber != diceNum 
		 * 		print "주사위를 맞추지 못했습니다."
		 * 		cnt++;
		 * 		diceNum -> (int)(Math.random() * 6) + 1
		 * 
		 * print "총 " + cnt + "회의 시도 끝에 맞추셨습니다"
		 */
//		Scanner sc = new Scanner(System.in);
//		System.out.println("목표 값을 입력 >>");
//		int targetNum = sc.nextInt();
//		int diceNum = (int)(Math.random() * 6) + 1;
//		int cnt = 1;
//		while(targetNum != diceNum) {
//			System.out.println("주사위를 맞추지 못했습니다., 주사위 : " + diceNum);
//			cnt++;
//			diceNum = (int)(Math.random() * 6) + 1;
//		}
//		System.out.println("총 " + cnt + "회의 시도 끝에 맞추셨습니다.");
		
		//break문 활용
		Scanner sc = new Scanner(System.in);
		System.out.println("목표 값을 입력 >>");
		int targetNum = sc.nextInt();
		int cnt = 0;
		while(true) {
			int diceNum = (int)(Math.random() * 6) + 1;
			System.out.println("주사위를 맞추지 못했습니다. 주사위 : " + diceNum);
			cnt++;	
			if(targetNum == diceNum) {
				break;
			}
		}
		System.out.println("총 " + cnt + "회의 시도 끝에 맞추셨습니다.");
	}

}
