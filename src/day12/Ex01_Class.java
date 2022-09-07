package day12;

public class Ex01_Class {
	/*
	 1. 필드(field)
	 	:: 데이터를 저장하는 공간
	 	:: 변수와 같은 개념
	 */
	String name;
	int num;
	String day = "금요일";	
	/*
	 2. 생성자(Constructor)
	 	:: 객체를 만들 때 따라야하는 규칙
	 	:: 생성자의 이름은 클래스의 이름과 동일
	 */
	// 기본생성자
	public Ex01_Class(){
	}
	// 매개변수 생성자
	public Ex01_Class(int num1, String word){
		this.num = num1;
		this.name = word;
	}
	
	/* 
	 3. 메소드(Method)
	 */
	int getNum() {
		return num;
	}
	String getName() {
		return name;
	}
}
