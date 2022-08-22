package day13;

public class Ex02_CalculatorMain {

	public static void main(String[] args) {
		Ex02_Calculator calc = new Ex02_Calculator();
		
		//계산기 On 실행
		calc.powerOn();
		
		int num1 = calc.inputNum();
		int num2 = calc.inputNum();
		calc.showMenu();
		int menu = calc.sc.nextInt();
		int result = 0;
		
		switch(menu) {
		case 1:
			System.out.print("덧셈 결과는 : ");
			result = calc.add(num1, num2);
			System.out.println(result);
			break;
		case 2:
			System.out.print("뺄셈 결과는 : ");
			result = calc.subtract(num1, num2);
			System.out.println(result);
			break;
		case 3:
			System.out.print("곱셈 결과는 : ");
			result = calc.multiply(num1, num2);
			System.out.println(result);
			break;
		case 4:
			System.out.print("나눗셈 결과 몫은 : ");
			result = calc.divide(num1, num2);
			System.out.print(result);
			int result2 = calc.divideR(num1, num2);
			System.out.print(" 나머지는 : ");
			System.out.println(result2);
			break;
		}
		int[] re = calc.remainder(num1, num2);
		System.out.println("몫은 : " + re[0]);
		System.out.println("나머지 : " + re[1]);
		
	}

}
