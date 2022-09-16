package day10;

import java.util.Scanner;

public class Ex03_Student {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] scores = null;
		int com;
		int students;
		boolean run = true;
		boolean check = false;
		while(run) {
			System.out.println("====================================================");
			System.out.println(" 1. 학생수 | 2. 점수입력 | 3. 점수목록 | 4. 점수분석 | 5. 종료");
			System.out.println("====================================================");
			System.out.print("메뉴선택>>");
			com = sc.nextInt();
			
			switch(com) {
			case 1:
				System.out.println("[1.학생수]");
				System.out.print("학생 수 입력>>");
				students = sc.nextInt();
				scores = new int[students];
				System.out.println("학생 수는 " + scores.length + "명 입니다.");
				check = false;
				break;
				
			case 2:
				System.out.println("[2.점수입력]");
				if(scores == null) {
					System.out.println("[1.학생수]를 입력해주세요.");
				}
				else {
					for(int i = 0; i < scores.length; i++) {
						System.out.print((i + 1) + "번째 학생 점수 : ");
						scores[i] = sc.nextInt();
					}
					System.out.println("");
				}
				check = true;
				break;
				
			case 3:
				System.out.println("[3.점수목록]");
				if(scores == null) {
					System.out.println("[1.학생수]를 입력해주세요.");
				}
				else {
					if(!check) {
						System.out.println("[2.점수입력]를 입력해주세요");
					}
					else {
						for(int i = 0; i < scores.length; i++) {
							System.out.print("[" + (i+ 1) + "번 : " + scores[i] + "]");
						}
					}
					System.out.println("");
				}
				break;
			
			case 4:
				System.out.println("[4.점수분석]");
				if(scores == null) {
					System.out.println("[1.학생수]를 입력해주세요.");
				}
				else {
					if(!check) {
						System.out.println("[2.점수입력]을 입력해주세요.");
					}
					else {
						int sum = 0;
						int max = scores[0];
						int min = scores[0];
						for(int i = 0; i < scores.length; i++) {
							sum += scores[i];
							if(max < scores[i])
								max = scores[i];
							if(min > scores[i])
								min = scores[i];
						}
						System.out.printf(scores.length + "\n최고 점수 : " + max +"\n최저 점수 : " + min + "\n평균은 :" + "%.2f", ((double)sum)/scores.length);
						System.out.println("");
					}
				}
				break;
			
			case 5:
				System.out.println("[5.종료]");
				run = false;
				break;
				
			default:
				System.out.println("1~5중의 숫자를 입력해주세요.");
					
			}
		}
		
		
		
	}

}
