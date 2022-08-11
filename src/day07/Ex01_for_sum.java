package day07;

import java.util.Scanner;

public class Ex01_for_sum {
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		System.out.println("마지막 숫자 입력 >> ");
		int iNum = s1.nextInt();
		int sum = 0;

		for (int i = 1; i < iNum; ++i) {
			sum += i;
		}

		System.out.println("sum = " + sum);
	}
}