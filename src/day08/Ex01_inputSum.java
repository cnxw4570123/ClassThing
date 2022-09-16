package day08;

import java.util.Scanner;

public class Ex01_inputSum {

	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		int cnt = 0;
		int sum = 0;
		while(true) {
			System.out.print("숫자 입력>>");
			int inputNum = s1.nextInt();
			if(inputNum == 0)
				break;
			cnt++;
			sum += inputNum;
			System.out.println("입력 숫자 : " + inputNum);
		}
		System.out.println("총 " + cnt + "회 입력했고 합은 " + sum);

	}

}
