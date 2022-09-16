package day18;

public class Ex02_child extends Ex02_parent{
	String childVal;
	
	@Override
	public void showInfo() {
		System.out.println("자식 클래스에서 재정의한 showInfo() 실행");
		if(strVal == null) {
			System.out.println("strVal : null 입니다. ");
		} else {
			System.out.println("strVal : " + strVal + "입니다.");
		}
		
		if(intVal == 0) {
			System.out.println("intVal : 0 입니다.");
		} else {
			System.out.println("intVal : " + intVal +  "입니다.");
		}
	}
	
	@Override
	public void testMethod() {
		super.testMethod();
	}
	@Override
	public void printField() {
		System.out.println("childVal : " + childVal);

	}
}
