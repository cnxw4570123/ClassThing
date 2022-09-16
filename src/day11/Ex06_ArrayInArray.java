package day11;

import java.util.Scanner;

public class Ex06_ArrayInArray {

	public static void main(String[] args) {
//		int[] arr1 = new int[3];
////		|   |   |   |		
//		
//		int[][] arr2 = new int[2][3];
////		 [0] [1] [2]		
////	0행	|   |   |   |		
////	1행	|   |   |   |		
//		System.out.println("arr2.length : " + arr2.length);
//		System.out.println("arr2[0].length : " + arr2[0].length);
//		int[][] numbers = new int[3][];
////		[0]행		
////		[1]행		
////		[2]행		
//		System.out.println("numbers.length : " + numbers.length);
////		System.out.println("numbers.length : " + numbers[0].length);
//		// 오류 -> NullPointerException
//		
//		numbers[0] = new int[3];
//		System.out.println("numbers[0].length : " + numbers[0].length);
//		numbers[1] = new int[2];
//		System.out.println("numbers[1].length : " + numbers[1].length);
//		numbers[2] = new int[5];
//		System.out.println("numbers[2].length : " + numbers[2].length);
//		
//		int[] number1 = new int[10];
//		for(int i = 0; i < number1.length; i++) {
//			number1[i] = i+1;
//		}
//		System.out.println("number1의 모든 값 출력");
//		for(int i = 0; i < number1.length; i++) {
//			System.out.print("[" + number1[i] + "]");
//		}
//		System.out.println("\n=======================");
//		
//		int[][] number2 = new int[3][];
//		number2[0] = new int[3];
//		number2[1] = new int[2];
//		number2[2] = new int[5];
//		int value = 0;
//		
//		for(int i = 0; i < number2.length; i++) {
//			for(int j = 0; j < number2[i].length; j++) {
//				value++;
//				numbers[i][j] = value;
//				System.out.print("[" + numbers[i][j] + "]");
//			}
//			System.out.println();
//		}
			Scanner sc = new Scanner(System.in);
			System.out.print("행 개수입력>>");
			int row = sc.nextInt();
			int column;
			int value = 0;
			int[][] ascentNum = new int[row][];
			for(int i = 0; i < ascentNum.length; i++){
				System.out.print(i + "행의 크기 입력>>");
				column = sc.nextInt();
				ascentNum[i] = new int[column];
				for(int j = 0; j< ascentNum[i].length; j++){
					value++;
					ascentNum[i][j] = value;
				}
			}
			for(int i = 0; i < ascentNum.length; i++){
				for(int j = 0; j < ascentNum[i].length; j++){
					System.out.print("[" + ascentNum[i][j] + "]");
				}
				System.out.println();
			}
	}
}