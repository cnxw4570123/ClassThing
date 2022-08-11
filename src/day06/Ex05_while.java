package day06;

public class Ex05_while {
	public static void main(String[] args) {
		int cnt = 0;
		System.out.println("while문 시작");

		while (cnt < 10) {
			++cnt;
			System.out.print(cnt + " ");
		}

		System.out.println("");
		System.out.println("while문 종료");
		System.out.println("========================");
		int number = 1;

		for (int sum = 0; sum <= 100; ++number) {
			sum += number;
		}

		System.out.println("1로 시작하는 순열의 합이 100이 되는 순간의 마지막 수 :" + (number - 1));
	}
}