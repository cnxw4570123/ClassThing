package day13;

public class Ex01_Phone {
	/*
	 1. 필드(field)
	 	:: 데이터를 저장하는 공간
	 	:: 변수와 같은 개념
	 */
	String color;
	String telecom;
	int storage;
	/*
	 2. 생성자(Constructor)
	 	:: 객체를 만들 때 따라야하는 규칙
	 	:: 생성자의 이름은 클래스의 이름과 동일
	 */
	public Ex01_Phone() {
	}
	
	public Ex01_Phone(String telecom) {
		super(); // 부모 클래스의 기본생성자 호출
		this.telecom = telecom;
	}
	
	public Ex01_Phone(int storage) {
		super(); // 부모 클래스의 기본생성자 호출
		this.storage = storage;
	}
	
	public Ex01_Phone(String color, int storage) {
		this.color = color;
		this.storage = storage;
		
	}
	public Ex01_Phone(int storage, String color) {
		this.color = color;
		this.storage = storage;
		
	}
//	void setColor(String col) {
//		this.color = col;
//	}
//	void setTel(String tel) {
//		this.telecom = tel;
//	}
//	void setStorage(int str) {
//		this.storage = str;
//	}
//	
//	String getColor() {
//		return color;
//	}
//	String getTel() {
//		return telecom;
//	}
//	int getStor() {
//		return storage;
//	}
	/* 
	 3. 메소드(Method)
	 	:: 특정한 기능을 정의하는 블록
	 	:: 메소드가 호출되면 정의된 기능을 수행
	 	:: 리턴값이 있는 메소드
	 	:: 리턴값이 없는 메소드 
	 */
	public void printNumber1() {
		System.out.println("printNumber1() 호출");
	}
	
	public int printNumber2() {
		System.out.println("printNumber1() 호출");
		return 1;
	}
	
	
	public void showInfo( /*매개변수*/ ) {
//		String color = "ABC";
//		System.out.println("색상은 : " + color);
		if(this.color == null) {
			System.out.println("색상값이 설정되지 않았습니다.");
		}else {
			System.out.println("색상은 : " + this.color);
		}
		if(this.telecom == null) {
			System.out.println("통신사 값이 설정되지 않았습니다.");
		}else {
			System.out.println("통신사 : " + this.telecom);
		}
		if(this.storage == 0) {
			System.out.println("용량값이 설정되지 않았습니다.");
		}else {
			System.out.println("용량은 : " + this.storage);
		}
	}
}
