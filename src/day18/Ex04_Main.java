package day18;

public class Ex04_Main {

	public static void main(String[] args) {
		Ex04_People people = new Ex04_People("인천", "010-1111-1111", 20);
		System.out.println(people.name + " : " + people.tel+" : " + people.age);
		
		Ex04_Students student = new Ex04_Students("일보", "010-2222-2222", 21, "2022", "JAVA");
	}

}
