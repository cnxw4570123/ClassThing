package beakjoon;

import java.util.Scanner;

public class loop_Multiplication {

	public static void main(String[] args) {
		/*
		 * input N
		 * for i -> 0; i < 9; i++ do
		 * 		print N * (i + 1); 
		 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i < 9; i++) {
			System.out.println(N + " * " + (i + 1) + " = " + N * (i + 1));
		}
	}

}
