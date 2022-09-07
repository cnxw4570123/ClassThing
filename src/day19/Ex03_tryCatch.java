package day19;

public class Ex03_tryCatch {

	public static void main(String[] args) {
		int number = 10;
		int[] nums = new int[2];
		try {
			System.out.println(number/ nums[0]);
			nums[3] = 10;
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눈 경우 예외발생");
			System.out.println("catch");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 범위를 벗어날 경우 예외 발생 예외발생");
			System.out.println("catch");
		}

	System.out.println(number + 10);	
	}
}
