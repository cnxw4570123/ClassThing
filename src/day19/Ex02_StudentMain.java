package day19;

import day08.Ex02_UpDown;

public class Ex02_StudentMain {

	public static void main(String[] args) {
		Ex02_Student stu01 = new Ex02_Student();
		stu01.name = "정균민";
		stu01.tel = "010-5362-8640";
		System.out.println("stu01 정보");
		System.out.println("교육원 : " + stu01.academy);
		System.out.println("이름 : " + stu01.name);
		System.out.println("전화번호 : " + stu01.tel);
		Ex02_Student.showInfo01();
		Ex02_Student.academy = "인천일보아카데미";
		
		System.out.println();
		Ex02_Student stu02 = new Ex02_Student();
		stu02.name = "기민한 발놀림";
		stu02.tel = "010-1411-1115";
		System.out.println("stu02 정보");
		System.out.println("교육원 : " + stu02.academy);
		System.out.println("이름 : " + stu02.name);
		System.out.println("전화번호 : " + stu02.tel);
		
		
		
	}

}
