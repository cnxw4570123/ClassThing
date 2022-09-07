package day12;

public class Ex01_ClassMain {
	public static void main(String[] args) {
		int number = 10;
		System.out.println("number : " + number);
		//Ex01_Class 타입의 ex01 객체를 생성
		Ex01_Class ex01 = new Ex01_Class();
		System.out.println("ex01.num : " + ex01.num);
		ex01.num = 100;
		System.out.println("ex01.num : " + ex01.num);
		ex01.name = "d";
		System.out.println("ex01.name : " + ex01.name);
		System.out.println("ex01.name : " + ex01.day);

//		System.out.println(ex01.getNum() + " : " + ex01.getName());
		
		Ex01_Class ex02 = new Ex01_Class();
		System.out.println("ex02.num : " + ex02.num);
		System.out.println("ex02.name : " + ex02.name);
		System.out.println("ex02.day : " + ex02.day);
		
		ex02.day = "토요일";
		System.out.println("ex01.day : " + ex01.day);
		System.out.println("ex02.day : " + ex02.day);
		
		System.out.println("=======================");
		
		Ex01_Class exObj = new Ex01_Class(); // 메모리안에 이 객체를 담을 공간을 만든다.
		System.out.println("exObj.name : " + exObj.name);
		Ex01_Class exObj2 = new Ex01_Class(27, "정균민");
		System.out.println("exObj.name : " + exObj2.name);
	}
}
