package day13;

import java.util.Scanner;

public class Ex02_Calculator {
	Scanner sc;
	
	public Ex02_Calculator() {
		System.out.println("Ex02_Calculator() 생성자 호출");
		sc = new Scanner(System.in);
	}
	public int inputNum() {
		System.out.print("숫자 입력>>");
		int inputNum = sc.nextInt();
		return inputNum;
	}
	public void showMenu() {
		System.out.println("[1]덧셈 [2]뺄셈 [3] 곱셈 [4]나눗셈");
	}
	
	public void powerOn() {
		System.out.println("계산기 전원이 켜졌습니다.");
	}
	
	public int add(int num1, int num2) {
//		return num1 + num2;
		int plusResult = num1 + num2;
		return plusResult;
	}
	public int subtract(int num1, int num2) {
		return num1 - num2;
	}
	public int multiply(int num1, int num2) {
		return num1 * num2;
	}
	public int divide(int num1, int num2) {
		return num1 / num2;
	}
	public int divideR(int num1, int num2) {
		return num1 % num2;
	}
	
	public int testMethod(String str1) {
		System.out.println("testMethod() 호출");
		return 100;
	}
	
	public int[] remainder(int num1, int num2) {
		int[] result = new int[2];
		result[0] = num1 / num2;
		result[1] = num1 % num2;
		return result;
	}
}
