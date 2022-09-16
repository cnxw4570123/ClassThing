package day10;

import java.util.Scanner;

public class Ex02_ArrayRandom2 {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int iNum;
//		int[] numberList = new int[10];
//		for(int i = 0; i < numberList.length; i++){
//			int randomNumber;
//			while(true){
//				boolean check = true;
//				randomNumber = (int)(Math.random() * 10) + 1;
//				for(int j = 0; j < i; j++){
//					if(randomNumber == numberList[j]){
//						check = false;
//					}
//				}
//				if(check){
//					break;
//				}			
//			}
//			numberList[i] = randomNumber;
//		}
//		int cnt = 0;
//		while(true) {
//			for(int i = 0; i < numberList.length; i++){
//				System.out.print("[" + numberList[i] + "]");
//			}
//			System.out.print("\n숫자입력>>");
//			iNum = sc.nextInt();
//			for(int j = 0; j < numberList.length; j++) {
//				if(iNum == numberList[j] && iNum != 0) {
//					numberList[j] = 0;
//					cnt++;
//					break;
//				}
//			}
//			if(cnt == 10) {
//				for(int i = 0; i < numberList.length; i++){
//					System.out.print("[" + numberList[i] + "]");
//				}
//				System.out.println("\n종료");
//				break;
//			}
//		}
		
//		Scanner sc = new Scanner(System.in);
//		int iNum;
//		int[] numberList = new int[10];
//		for(int i = 0; i < numberList.length; i++){
//			int randomNumber;
//			while(true){
//				boolean check = true;
//				randomNumber = (int)(Math.random() * 10) + 1;
//				for(int j = 0; j < i; j++){
//					if(randomNumber == numberList[j]){
//						check = false;
//					}
//				}
//				if(check){
//					break;
//				}			
//			}
//			numberList[i] = randomNumber;
//		}
//		while(true) {
//			int sum = 0;
//			for(int i = 0; i < numberList.length; i++){
//				System.out.print("[" + numberList[i] + "]");
//				sum += numberList[i];
//			}
//			System.out.print("\n숫자입력>>");
//			iNum = sc.nextInt();
//			for(int j = 0; j < numberList.length; j++) {
//				if(iNum == numberList[j]) {
//					numberList[j] = 0;
//					break;
//				}
//			}
//			if(sum <= 0) {
//				System.out.println("종료");
//				break;
//			}
//		}
		
//		Scanner sc = new Scanner(System.in);
//		int iNum;
//		int[] numberList = new int[10];
//		for(int i = 0; i < numberList.length; i++){
//			int randomNumber;
//			while(true){
//				boolean check = true;
//				randomNumber = (int)(Math.random() * 10) + 1;
//				for(int j = 0; j < i; j++){
//					if(randomNumber == numberList[j]){
//						check = false;
//					}
//				}
//				if(check){
//					break;
//				}			
//			}
//			numberList[i] = randomNumber;
//		}
//		while(true) {
//			int sum = 0;
//			boolean check = true;
//			for(int i = 0; i < numberList.length; i++){
//				System.out.print("[" + numberList[i] + "]");
//				if(numberList[i] > 0)
//					check = false;
//			}
//			if(check) {
//				System.out.println("\n종료");
//				break;
//			}
//			
//			System.out.print("\n숫자입력>>");
//			iNum = sc.nextInt();
//			for(int j = 0; j < numberList.length; j++) {
//				if(iNum == numberList[j]) {
//					numberList[j] = 0;
//					break;
//				}
//			}
//		}
		Scanner sc = new Scanner(System.in);
		int iNum;
		int[] numberList = new int[10];
		for(int i = 0; i < numberList.length; i++){
			int randomNumber;
			while(true){
				boolean check = true;
				randomNumber = (int)(Math.random() * 10) + 1;
				for(int j = 0; j < i; j++){
					if(randomNumber == numberList[j]){
						check = false;
					}
				}
				if(check){
					break;
				}			
			}
			numberList[i] = randomNumber;
		}
		while(true){
			boolean check = true;
			for(int i = 0; i < numberList.length; i++){
				System.out.print("[" + numberList[i] + "]");
				if(numberList[i] > 0){
					check = false;
				}
			}
			if(check){
				System.out.println("\n종료");
				break;
			}
			System.out.println("\n숫자 입력");
			iNum = sc.nextInt();
			
			for(int j = 0; j < numberList.length; j++){
				if(iNum == numberList[j]){
					numberList[j] = 0;
				}
			}
		}
		
	}

}
