package day11;

public class Ex03_ArrayInArray {

	public static void main(String[] args) {
		int[] numbers = new int[3];
		numbers[0] = 10;
		numbers[1] = 20;
		numbers[2] = 30;
		
		//2차원 배열
		int[][] numbers2= new int [2][3];
		numbers2[0][0] = 50;
		numbers2[1][2] = 80;
		System.out.println(numbers2[0][0]);
		System.out.println(numbers2[0][1]);
		System.out.println(numbers2[0][2]);

		System.out.println(numbers2[1][0]);
		System.out.println(numbers2[1][1]);
		System.out.println(numbers2[1][2]);
		
		System.out.println("배열크기 : " + numbers.length);
		for(int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
		
		System.out.println("===========================");
		System.out.println("numbers2[] 배열의 행의 개수 : " + numbers2.length);
		System.out.println("numbers2[0] 배열의 행의 크기 : " + numbers2[0].length);
		System.out.println("numbers2[1] 배열의 행의 크기 : " + numbers2[1].length);
		
		System.out.println("원소 출력");
		for(int i = 0; i < numbers2.length; i++) {
			for(int j = 0; j < numbers2[i].length; j++) {
				System.out.print("[" + numbers2[i][j] + "]");
			}
			System.out.println("");
		}
	}

}
