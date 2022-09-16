package day18;

public class Ex04_Students extends Ex04_People{
	String stuNum;
	String major;
	public Ex04_Students() {
		super();
	}
	
	public Ex04_Students(String name, String tel, int age, String stuNum, String major) {
		
		super(name, tel, age);
		this.stuNum = stuNum;
		this.major = major;
	}
}
