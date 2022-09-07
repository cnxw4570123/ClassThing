package day18;

public class Ex03_People {
	String name;
	String tel;
	int age;
	
	public Ex03_People() {
	}
	
	public Ex03_People(String name) {
		this.name = name;
	}
	
	public Ex03_People(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Ex03_People [name=" + name + ", tel=" + tel + ", age=" + age + "]";
	}
	
	
}
