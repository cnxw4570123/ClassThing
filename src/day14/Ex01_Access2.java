package day14;

public class Ex01_Access2 {
	public int intValue;
	
	private static Ex01_Access2  access = new Ex01_Access2();
	
	private Ex01_Access2() {	
	}
	
	public static Ex01_Access2 getInstance() {
		return access;
	}
	
}
