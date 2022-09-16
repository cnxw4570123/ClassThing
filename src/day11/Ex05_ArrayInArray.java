package day11;

import java.util.Scanner;

public class Ex05_ArrayInArray {

	public static void main(String[] args) {
		int[] price = { 5000, 4000, 3000, 2500, 2000 };

		int[][] numbers = { { 1, 2, 3 }, { 4, 5, 6, 7 }, { 8, 9 } };
		System.out.println(numbers[0].length);
		System.out.println(numbers[1].length);
		System.out.println(numbers[2].length);
		
//		for (int i = 0; i < numbers.length; i++) {
//			for (int j = 0; j < numbers[i].length; j++) {
//				System.out.print("[" + numbers[i][j] + "]");
//			}
//			System.out.println();
//		}
		int sum = 0;
		int countLength = 0;
		int cnt = 0;
		for (int i = 0; i < numbers.length; i++) {
			countLength += numbers[i].length;
			for (int j = 0; j < numbers[i].length; j++) {
				System.out.print("[" + numbers[i][j] + "]");
				sum += numbers[i][j];
				cnt++;
			}
			System.out.println();
		}
		System.out.println("총합은 : " + sum);
		System.out.println("평균은 : " + (double)sum / countLength);
	}

}
