package day07;

import java.util.Scanner;

public class Ex03_for_multipleList {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("시작 숫자 >> ");
		int sNum = scan.nextInt();
		System.out.print("끝 숫자 >> ");
		int eNum = scan.nextInt();
		int cnt = 0;
		String list = "";
		System.out.print("나누려는 수를 입력하세요 : ");
		int divideNum = scan.nextInt();
		int sum = 0;

		for (int i = sNum; i <= eNum; ++i) {
			if (i % divideNum == 0) {
				++cnt;
				sum += i;
				if (i + divideNum <= eNum) {
					list = list + i + ", ";
				} else {
					list = list + i;
				}
			}
		}

		System.out
				.print(divideNum + "의 배수는 " + list + " 총 " + cnt + "개가 있고 " + divideNum + "의 배수의 총합은 " + sum + "입니다.");
	}
}