package day09;

import java.util.Scanner;

public class Ex06_ArrayScore {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String[] subject = {"JAVA", "HTML", "JAVASCRIPT", "ORACLE"};
//		// 과목의 점수를 저장할 배열 선언
//		// 클래스로 배열을 지정하면 1차원 배열에서도 과목(String index)과 점수(int)로 구성가능하다.
//		
//		int[] scores = new int[subject.length];
//		for(int i = 0; i < scores.length; i++) {
//			System.out.print(subject[i] + " 과목의 점수>>");
//			scores[i] = sc.nextInt(); 
//		}
		
		// scores, subject 배열 활용 학점 판별
		// 90 이상 A학점, 80 이상이면 B, 70점 이상 C, 70 미만 재수강
		/*
		 * input -> scores[]
		 * for int i = 0; i < scores.length; i++ do
		 * 		if scores[i] >= 90 then
		 * 			print subject[i] +  A학점;
		 * 		else if scores[i] >= 80 then
		 * 			print B학점;
		 * 		else if scores[i] >= 70 then
		 * 			pirnt C;
		 * 		else
		 * 			print 재수강;
		 */
		
//		for(int i = 0; i < scores.length; i++) {
//			System.out.print(subject[i] + " 과목: ");
//			if(scores[i] >= 90) {
//				System.out.println("A학점");
//			}
//			else if(scores[i] >= 80) {
//				System.out.println("B학점");
//			}
//			else if(scores[i] >= 70) {
//				System.out.println("C학점");
//			}
//			else {
//				System.out.println("재수강 대상입니다.");
//			}
//		}
		/*
		 * 과목명으로 점수 검색
		 * 예) 과목명으로 점수 검색
		 * 1. 해당 과목명이 있을 경우 -> JAVA점수는 70점, C학점입니다. 출력
		 * 2. 해당 과목명 X -> 과목명을 찾을 수 없습니다. 출력
		 */
		
		Scanner sc = new Scanner(System.in);
		String[] subject = {"JAVA", "HTML", "JAVASCRIPT", "ORACLE"};
	
		int[] scores = new int[subject.length];
		for(int i = 0; i < scores.length; i++) {
			System.out.print(subject[i] + " 과목의 점수>>");
			scores[i] = sc.nextInt(); 
		}
		
		for (int i = 0; i < scores.length; i++) {
			System.out.print("과목명 입력>>");
			String subName = sc.next();
			
			if(subject[i].equals(subName)) {
				System.out.print(subject[i] + " 과목 점수는 " + scores[i] + "점이고, ");
				if(scores[i] >= 90)
					System.out.println("A학점입니다.");
				else if(scores[i] >= 80)
					System.out.println("B학점입니다.");
				else if(scores[i] >= 70)
					System.out.println("C학점입니다.");
				else
					System.out.println("재수강 대상입니다.");
			}
			else
				System.out.println("해당 과목을 찾을 수 없습니다.");
		}
		
	}

}
