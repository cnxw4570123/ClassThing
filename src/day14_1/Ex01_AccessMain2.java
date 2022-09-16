package day14_1;

import day14.Ex01_Access;

public class Ex01_AccessMain2{

	public static void main(String[] args) {
		Ex01_Access ac2 = new Ex01_Access();
		ac2.publicValue = 100;
		
		//private, protected, default 필드 접근 X
//		ac2.privateValue = 100;
//		ac2.protectedValue = "A";
//		ac2.defaultValue = "B";
		Ex01_AccessChild2 acChild = new Ex01_AccessChild2();
		acChild.childMethod();
	}

}
