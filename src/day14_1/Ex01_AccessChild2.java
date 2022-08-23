package day14_1;

import day14.Ex01_Access;

public class Ex01_AccessChild2 extends Ex01_Access{
	public void childMethod() {
		System.out.println(publicValue);
//		System.out.println(privateValue);
		System.out.println(protectedValue);
//		System.out.println(defaultValue);
	}
}
