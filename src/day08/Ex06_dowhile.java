package day08;

public class Ex06_dowhile {

	public static void main(String[] args) {
		/*
		 * while(조건식){
		 * 	반복조건이 true일 경우 실행
		 * }
		 * 
		 * do{
		 * 	반복조건이 true일 경우 실행
		 * } while(조건식)
		 * 
		 */
		int num = 10;
		System.out.println("while문 실행");
		while(num <= 5) {
			System.out.println(num);
			num++;
		}
		System.out.println("while문 종료");
		
		int num2 = 10;
		System.out.println("while문 실행");
		do {
			System.out.println(num2);
			num2++;
		} while(num2 <= 5);
			System.out.println("while문 종료");
		
	}

}
