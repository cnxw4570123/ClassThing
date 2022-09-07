package day07;

import java.util.Scanner;

public class Ex02_for_EvenOdd {
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		System.out.println("시작 숫자 입력 >>");
		int startNum = s1.nextInt();
		System.out.println("시작 숫자 입력 >>");
		int endNum = s1.nextInt();
		int cnt = 0;

		for (int i = startNum; i <= endNum; ++i) {
			if (i % 2 == 0) {
				++cnt;
				System.out.print(i + " ");
			}
		}

		System.out.println("");
		System.out.println("짝수의 개수는? " + cnt);
		System.out.println("홀수의 개수는? " + (endNum - startNum - cnt + 1));
	}
}