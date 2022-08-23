package day14;

public class Ex01_Access {
	/*
	접근제한자
	1. public
		:: 클래스, 필드, 생성자, 메소드
		:: 모든 패키지, 모든 클래스에서 접근 가능
	2. private
		:: 필드, 생성자, 메소드
		:: 다른 클래스에서 접근이 불가능
	3. protected
		:: 필드, 생성자, 메소드
		:: 다른 패키지에 있는 클래스에서 접근이 불가능
		:: 다른 패키지에 있는 자식 클래스에서는 접근 가능.
	4. default
		:: 필드, 생성자, 메소드
		:: 다른 패키지에 있는 클래스에서 접근이 불가능
		
		:: 아무것도 붙이지 않으면 default로 선언됨.
	 */
	
	//필드
	public int publicValue;
	private int privateValue;
	//protecetd 필드 선언
	protected String protectedValue;
	String defaultValue;
	//생성자
	public Ex01_Access() {
		
	}
	//메소드
	public void publicMethod() {
		System.out.println("publicMethod() 호출");
		this.privateMethod();
	}
	private void privateMethod() {
		System.out.println("privateMethod() 호출");
	}
}
