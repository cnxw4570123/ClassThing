package day18;

public class Ex01_Main {

	public static void main(String[] args) {
		Ex01_Parent parent = new Ex01_Parent();
		parent.parentMethod();
		System.out.println("================");
		Ex01_Child child = new Ex01_Child();
		child.parentMethod();
		child.childMethod();
		
		child.setParentStr("자식클래스");
		System.out.println(child.parentStr);
		child.setParentInt(100);
		System.out.println(child.getParentInt());
	}

}
