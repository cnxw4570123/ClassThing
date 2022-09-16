package day09;

import java.util.Scanner;

public class Ex03_ArraySum {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int size = sc.nextInt();
//		int sum = 0;
//		int[] arr1 = new int[size];
//		
//		for(int elem : arr1) { // for - each문은 횟수 지정이 따로 불가능함.
//			arr1[elem] = (int)(Math.random() * 100) + 1;
//			System.out.println("arr[" + elem + "] : " + arr1[elem]);
//			sum += arr1[elem];
//		}
//		double avg = Math.round((double)sum / arr1.length * 100) / 100;
//		System.out.println("arr1의 총합은 " + sum + "점이고, 평균은 " + avg + "점 입니다.");
		
		System.out.println("===================================================");
	
		int[] scores = new int[5];
		int sum2 = 0;
		scores[0] = 83;
		scores[1] = 74;
		scores[2] = 97;
		scores[3] = 85;
		scores[4] = 100;
		
//		for(int i = 0; i < scores.length; i++) {
//			System.out.println("scores[" + i + "] : " + scores[i]);
//			sum2 += scores[i];
//		}
//		double avg2 = Math.round((double)sum2 / scores.length * 100) / 100;
//		System.out.println("총합은 " + sum2 + "점이고, 평균은 " + avg2 + "점 입니다.");
//		
//		System.out.println("===================================================");
		
		Scanner sc = new Scanner(System.in);
		scores = new int[4];
		sum2 = 0;
		
		for( int i = 0; i < scores.length; i++) {
			System.out.print((i+1) + "번 째 점수 입력>>");
			scores[i] = sc.nextInt();
		}
		System.out.println("점수 입력 종료");
		for(int i = 0; i < scores.length; i++) {
			System.out.println("scores[" + i + "] : " + scores[i]);
			sum2 += scores[i];
		}
		System.out.println("총점 : " + sum2);
		
	}

}
