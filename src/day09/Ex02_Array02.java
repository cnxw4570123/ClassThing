package day09;

public class Ex02_Array02 {

	public static void main(String[] args) {
//		String타입의 크기가 3인 배열을 선언
		String[] myInfo = new String[5];
		myInfo[0] = "정균민";
		myInfo[1] = "010-1234-5678"; //split 메소드 활용 시 3개의 문자열로 분리 가능 "010" "1234" "5678"
		myInfo[2] = "27";
		myInfo[3] = "인천";
		myInfo[4] = "남";

		for (int i = 0; i < 5; i++) {
			System.out.println(myInfo[i]);
		}
		
//		배열의 크기, 길이 확인
		System.out.println("myInfo.length : " + myInfo.length);
		for (int i = 0; i < myInfo.length; i++) {
			System.out.println(myInfo[i]);
		}
		
	}

}
