package day18;

import javax.security.auth.PrivateCredentialPermission;

public class Ex01_Child extends Ex01_Parent{
//	public void parentMethod() {
//		System.out.println("자식클래스의 parentMethod() 호출");
//	}
	public void childMethod() {
		parentMethod();
		System.out.println("자식클래스의 childMethod() 호출");
	}

}
