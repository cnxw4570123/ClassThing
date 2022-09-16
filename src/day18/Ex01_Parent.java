package day18;

public class Ex01_Parent {
	String parentStr;
	
	public void parentMethod() {
		System.out.println("부모클래스의 parentMethod() 호출");
	}
	
	private int parentInt;
	
	private void privateParentMethod() {
		System.out.println("부모클래스의 privateParentMethod() 호출");
	}

	public void setParentStr(String parentStr) {
		this.parentStr = parentStr;
	}

	public int getParentInt() {
		return parentInt;
	}

	public void setParentInt(int parentInt) {
		this.parentInt = parentInt;
	}

}
