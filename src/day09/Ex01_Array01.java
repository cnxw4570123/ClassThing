package day09;

public class Ex01_Array01 {

	public static void main(String[] args) {
		// 배열을 선언하면서 배열의 크기만 지정
		// 타입[] 배열이름 = new 타입[크기];
		int[] scores = new int[3];
		// String[] names = new int[3];
		System.out.println("scores[0]" + scores[0]);
		System.out.println("scores[1]" + scores[1]);
		System.out.println("scores[2]" + scores[2]);
		scores[0] = 90;
		scores[1] = 80;
		scores[2] = 70;
		//scores[3] = 50; -> 예외 발생
		System.out.println("scores[0]" + scores[0]);
		System.out.println("scores[1]" + scores[1]);
		System.out.println("scores[2]" + scores[2]);
		/*
		 * 배열의 크기를 늘리는 방법은 없으므로 새로운 배열을 생성해야 함.
		 * 이후 리스트 사용 시 크기 확장의 제한이 없으므로 문제 해결 가능.
		 */

		String[] names = new String[3];
		System.out.println("names[0]" + names[0]);
		System.out.println("names[1]" + names[1]);
		System.out.println("names[2]" + names[2]);
		names[0] ="인천";
		names[1] ="일보";
		names[2] ="아카데미";
		System.out.println("names[0]" + names[0]);
		System.out.println("names[1]" + names[1]);
		System.out.println("names[2]" + names[2]);
		
		System.out.println("====================");
		int[] intArr1 = new int[2];
		System.out.println("intArr1[0] : " + intArr1[0]);
		intArr1[1] = intArr1[0] + 10;
		System.out.println("intArr1[1] : " + intArr1[1]);
		
		String[] strArr1 = new String[3];
		System.out.println("strArr1[0] : " + strArr1[0]);
		strArr1[1] = strArr1[0] + "abc";
		System.out.println("strArr1[1] : " + strArr1[1]);
		System.out.println(strArr1[2].equals("ABCD"));
	}

}
