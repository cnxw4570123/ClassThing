package day11;

import java.util.Scanner;

public class Ex04_ArrayInArray {

	public static void main(String[] args) {
		int[][] numbers = new int[3][3];
		numbers[0][0] = 1;
		numbers[0][1] = 2;
		numbers[0][2] = 3;

		numbers[1][0] = 4;
		numbers[1][1] = 5;
		numbers[1][2] = 6;

		numbers[2][0] = 7;
		numbers[2][1] = 8;
		numbers[2][2] = 9;

		// 모든 값 출력
		System.out.println(numbers[0][0]);
		System.out.println(numbers[0][1]);
		System.out.println(numbers[0][2]);
		for (int i = 0; i < numbers[0].length; i++) {
			System.out.print("[" + numbers[0][i] + "]");
		}
		System.out.println();
		for (int i = 0; i < numbers[1].length; i++) {
			System.out.print("[" + numbers[1][i] + "]");
		}
		System.out.println();
		for (int i = 0; i < numbers[2].length; i++) {
			System.out.print("[" + numbers[2][i] + "]");
		}
		System.out.println();

		System.out.println("numbers2 배열의 모든 값");
		int value = 1;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				numbers[i][j] = value;
				value++;
				System.out.print("[" + numbers[i][j] + "]");
			}
			System.out.println();
		}
//		
//		System.out.println("numbers2 배열의 모든 값");
//		Scanner sc = new Scanner(System.in);
//		System.out.print("행의 사이즈 입력>>");
//		int row = sc.nextInt();
//		int column;
//		int[][] numbers2 = new int[row][];
//		int value = 1;
//		for (int i = 0; i < numbers2.length; i++) {
//			System.out.print(i + "행의 크기 입력>>");
//			column = sc.nextInt();
//			numbers2[i] = new int[column];
//			for (int j = 0; j < numbers2[i].length; j++) {
//				numbers2[i][j] = value;
//				value++;
//			}
//		}
//		for(int i = 0; i < numbers2.length; i++) {
//			for(int j = 0; j < numbers2[i].length; j++) {
//				System.out.print("[" + numbers2[i][j] + "]");
//			}
//			System.out.println();
//		}

	}

}
