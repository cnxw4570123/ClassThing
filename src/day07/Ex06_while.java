package day07;

public class Ex06_while {
	public static void main(String[] args) {
		int i;
		for (i = 1; i <= 10; ++i) {
			System.out.println("true일 경우 실행" + i);
		}

		System.out.println("====================");
		i = 1;
		boolean run = true;

		while (run) {
			System.out.println("true일 경우 실행" + i);
			++i;
			if (i > 10) {
				run = false;
			}
		}

	}
}