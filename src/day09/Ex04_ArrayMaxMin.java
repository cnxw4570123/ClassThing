package day09;

import java.util.Scanner;

public class Ex04_ArrayMaxMin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("성적입력할 과목 수 >>");
		int size = sc.nextInt();
		int[] arr1 = new int[size];
		for(int i = 0; i < arr1.length; i++) {
			System.out.print((i + 1) + "번째 과목의 점수>>");
			arr1[i] = sc.nextInt();
		}
		
		// 배열에 점수 5개
		// 최대값 찾기
		int max = arr1[0];
		int min = arr1[0];
		
		int maxSubj = 0;
		int minSubj = 0;
		System.out.println(max);
		for(int i = 0; i < arr1.length; i++) {
			if(max < arr1[i]) {
				max = arr1[i];
				maxSubj = i;
			}
			if(min > arr1[i]) {
				min = arr1[i];
				minSubj = i;
			}
		}
		
		System.out.println("최대값은" + max + "이고 과목은" + maxSubj +"번 째입니다.");
		System.out.println("최대값은" + min + "이고 과목은" + minSubj +"번 째입니다.");
		
		
//		int sId = sc.nextInt(); int subj = sc.nextInt();
//		int[][] scores = new int[sId][subj];
//		System.out.println("sId " + scores.);
//		for(int i = 0; i < scores[sId].length; i++) {
//			
//		}
	}

}
