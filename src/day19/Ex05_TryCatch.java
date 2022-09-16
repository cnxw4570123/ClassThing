package day19;

public class Ex05_TryCatch {

	public static void main(String[] args) {
		String[] strList = new String[5];
		strList[0] = "A1";
		strList[1] = "B12";
//		strList[2] = "C123";
		strList[3] = "D1234";
		strList[4] = "E12345";
		for(int i = 0; i < strList.length; i++) {
			try {
			System.out.println(strList[i].length());
			} catch(NullPointerException e) {
				e.printStackTrace();
				System.out.println(i + "번 배열이 null입니다.");
			}
		}
		System.out.println();
		for(int i = 0; i < strList.length; i++) {
			if(strList[i] != null)
				System.out.println(strList[i].length());
			else
				System.out.println(i+"번 인덱스는 null입니다.");
		}
	}

}
