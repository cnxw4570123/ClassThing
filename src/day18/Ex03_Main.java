package day18;

public class Ex03_Main {

	public static void main(String[] args) {
//		Ex03_People people01 = new Ex03_People();
//		people01.name = "인천";
//		people01.tel = "010-1111-1111";
//		people01.age = 20;
//		System.out.println(people01);

		System.out.println();
		Ex03_People people02 = new Ex03_People("일보");
		people02.tel = "010-2222-2222";
		people02.age = 21;
		
		System.out.println();
		Ex03_Student student01 = new Ex03_Student();
		student01.name = "아카";
		student01.tel = "010-1234-1234";
		student01.age = 22;
		student01.stuNum = "12152294";
		student01.major = "JAVA";
		System.out.println(student01);
		
		Ex03_Student student02 = new Ex03_Student("데미");
	}

}
