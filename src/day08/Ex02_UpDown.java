package day08;

import java.util.Scanner;

public class Ex02_UpDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* int cnt = 0;
		 * randNum -> (int)(Math.random() * 50) + 1;
		 * print "숫자 입력";
		 * int inputNum -> input Number;
		 * boolean wrong = true;
		 * while wrong do
		 * 		if randNum = inputNum then
		 * 			print "정답입니다";
		 * 			wrong = false;
		 * 			break;
		 * 
		 * 		if randNum > inputNum then
		 * 			print "정답은 " + inputNum + "보다 큰 수입니다";
		 * 		else
		 * 			print "정답은 " + inputNum + "보다 작은 수입니다";
		 *		cnt++; 
		 * print "총 " + cnt + "번의 시도를 했습니다";
		 */
		Scanner s1 = new Scanner(System.in);
		int cnt = 1;
		int randNum = (int)(Math.random() * 50) + 1;
		System.out.println(randNum);
		boolean wrong = true;
		
		while(wrong) {
//			Scanner s1 = new Scanner(System.in);
//			int cnt = 0;
//			int randNum = (int)(Math.random() * 50) + 1;
//			boolean wrong = true;
//			
//			while(wrong) {
//				System.out.print("숫자를 입력해 주세요>>");
//				int inputNum = s1.nextInt();
//				if(inputNum < 1 || inputNum > 50) {
//					System.out.println("1 ~ 50 사이의 숫자를 입력해주세요!");
//				}
//				else {
//					cnt++;
//					if(randNum == inputNum) {
//						System.out.println("정답입니다.");
//						wrong = false;
//					}
//					else if(randNum > inputNum) {
//						System.out.println("정답은 " + inputNum + "보다 큰 수입니다.");
//					}
//					else {
//						System.out.println("정답은 " + inputNum + "보다 작은 수입니다.");
//					}
//				}
//			}
//			System.out.println("총 " + cnt + "번의 시도를 했습니다");
			
			System.out.print("숫자를 입력해 주세요>>");
			int inputNum = s1.nextInt();
			if(inputNum < 1 || inputNum > 50) {
				System.out.println("1 ~ 50 사이의 숫자를 입력해주세요!");
			}
			else {
				if(randNum == inputNum) {
					System.out.println("정답입니다.");
					wrong = false;
					break;
				}
				if(randNum > inputNum) {
					System.out.println("정답은 " + inputNum + "보다 큰 수입니다.");
				}
				else {
					System.out.println("정답은 " + inputNum + "보다 작은 수입니다.");
				}
				cnt++;
			}
		}
		System.out.println("총 " + cnt + "번의 시도를 했습니다");

	}

}
