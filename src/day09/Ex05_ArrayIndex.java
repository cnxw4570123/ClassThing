package day09;

import java.util.Scanner;

public class Ex05_ArrayIndex {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("성적입력할 과목 수 >>");
//		int size = sc.nextInt();
//		int[] arr1 = new int[size];
//
//		for(int i = 0; i < arr1.length; i++) {
//			System.out.print((i + 1) + "번째 과목의 점수>>");
//			arr1[i] = sc.nextInt();
//		}
//		int max = arr1[0];
//		int min = arr1[0];
//		
//		for(int i = 0; i < arr1.length; i++) {
//			if(max < arr1[i])
//				max = arr1[i];
//			if(min > arr1[i])
//				min = arr1[i];
//		}
//		int cnt = -1;
//		for(int i = 0; arr1[i] != max; i++) {
//			cnt = i;
//		}
//		System.out.println("최대값은" + max + "점이며, " + (cnt + 1) + "번째 과목입니다.");
//		System.out.println("최소값은" + min + "점입니다.");
		
		//만일 동점과목이 있으면?
		/*
		 * 최대값과 몇번째 과목인지 알려주는데 동점과목이 있으면 어떤과목들이 동점인지도 알려주는
		 * 5개 과목 80 70 90 55 90
		 * for int i -> 1; i < arr1.length; i++ do
		 * 		if max = arr[i] then
		 * 			cnt++;
		 * 		if max < arr1[i] then
		 * 			max -> arr1[i]
		 * 
		 * if mCnt >= 2 then
		 * 		int[] sameScore -> new int[mCnt];
		 * 		for int i -> 0; i <sameScore.length; i++ do
		 * 			for int j -> j < arr1.length; j++ do
		 * 				if max = arr1[j] then
		 * 					sameScore[i] = arr1[j]
		 * 			print sameScore[i]
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("성적입력할 과목 수 >>");
		int size = sc.nextInt();
		int[] arr1 = new int[size];
		
		boolean[] check = new boolean[size];

		for(int i = 0; i < arr1.length; i++) {
			System.out.print((i + 1) + "번째 과목의 점수>>");
			arr1[i] = sc.nextInt();
		}
		int max = arr1[0];
		int mCnt = 0;
		
		for(int i = 0; i < arr1.length; i++) {
			if(max == arr1[i]) {
				mCnt++;
				check[i] = true;
			}
			if(max < arr1[i])
				max = arr1[i];
		}
		
		System.out.print("최대값은 " + max + "점이며 ");
		for (int i = 0; i < arr1.length; i++) {
			if(check[i]) {
				if((i + 1) < arr1.length)
					System.out.print((i + 1) + "번, ");
				else
					System.out.print((i + 1) + "번입니다.");
			}
		}
		
	}

}
