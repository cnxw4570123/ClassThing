package day13;

public class Ex03_ArrayCalcMain {

	public static void main(String[] args) {
		Ex03_ArrayCalculator calc= new Ex03_ArrayCalculator();

		int[] scores01 = { 70, 80, 88, 77, 91 };
		int sum1 = calc.summation(scores01); 
		System.out.println("scores01 배열의 총합 : " + sum1);
		System.out.println("scores02 배열의 평균 : " + calc.getAvg(scores01));
		
		int[] scores02 = { 90, 80, 60, 70 };
		int sum2 = calc.summation(scores02);
	
		System.out.println("scores02 배열의 총합 : " + sum2);
		System.out.println("scores02 배열의 평균 : " + calc.getAvg(scores02));
		
	}

}
