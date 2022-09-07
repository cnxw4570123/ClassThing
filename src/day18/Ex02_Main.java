package day18;

public class Ex02_Main {

	
	public static void main(String[] args) {
		Ex02_parent parent = new Ex02_parent();
		parent.showInfo();
		parent.printField();
		
		
		System.out.println("==================");
		Ex02_child child = new Ex02_child();
		child.showInfo();
		child.testMethod();
		child.printField();
	}

}
