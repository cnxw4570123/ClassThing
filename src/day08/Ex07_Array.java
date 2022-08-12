package day08;

public class Ex07_Array {

	public static void main(String[] args) {
	// 배열 - array
		// 변수타입 변수명 = 값;
		int num1 = 1;
		int num2;
		num2 = 2;
		
		//배열타입 배열이름 = {데이터1, 데이터2, .... }
		int[] arr1 = { 1, 3, 2 };
		// 	인덱스    0  1  2
		// arr1 =  [1][3][2]
		System.out.println("arr1[0] :" + arr1[0]);
		System.out.println("arr1[1] :" + arr1[1]);
		System.out.println("arr1[2] :" + arr1[2]);
//		System.out.println(arr1[3]);
		
		// 선언 이후 초기화
		int[] arr2 = new int[3];
		arr2[0] = 100; 

		System.out.println("arr2[0] :" + arr2[0]);
		System.out.println("arr2[1] :" + arr2[1]);
		System.out.println("arr2[2] :" + arr2[2]);
		
		String[] strArr1 = new String[5];
/*
 * 		인덱스	   0  1  2  3  4
 * 		strArr1 = [ ][ ][ ][ ][ ]
 */
		System.out.println("strArr1[0] :" + strArr1[0]);
		strArr1[0] = "ABC"; // strArr1 = [ABC][ ][ ][ ][ ]
		System.out.println("strArr1[0] :" + strArr1[0]);
		strArr1[1] = "EFG";
		System.out.println("strArr1[1] :" + strArr1[1]);
		
		/*
		 * 나중에 사용하다가 배열 사이즈를 넘는 정보를 저장해야 하는 경우에는??
		 * 이 때는 기존 배열의 정보를 더 큰 사이즈의 배열에 저장하는 경우 밖에 없는가?
		 */
		
	}

}
