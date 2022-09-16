package day18;

public class Ex03_Student extends Ex03_People{
	String stuNum;
	String major;
	@Override
	public String toString() {
		return super.toString() + "Ex03_Student [stuNum=" + stuNum + ", major=" + major + "]";
	}
	
	public Ex03_Student() {
		super();
	}
	
	public Ex03_Student(String name) {
		this.name = name;
	}
	public Ex03_Student(String name, String tel) {
		super(name, tel);
	}
/*
	public Ex03_Student(String name) {
		super(name);
	}
	*/
	
}
