package day13;

public class Ex03_ArrayCalculator {
	int sum;

	public int summation(int[] arr) {
		this.sum = 0;
		for (int i = 0; i < arr.length; i++) {
			this.sum += arr[i];
		}
		return this.sum;
	}
	
	public double getAvg(int[] arr) {
		return (double)this.summation(arr) /arr.length;
	}
}
