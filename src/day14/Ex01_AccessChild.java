package day14;

public class Ex01_AccessChild extends Ex01_Access {
	public void childMethod() {
		System.out.println(publicValue);
//		System.out.println(privateValue);
		System.out.println(protectedValue);
		System.out.println(defaultValue);
	}
}
