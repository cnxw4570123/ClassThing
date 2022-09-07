package day13;

import java.util.Scanner;

public class Ex04_Member {
	String mid;   // 아이디
	String mpw;   // 비밀번호 
	String mName; // 회원이름
	Scanner sc;
	
	public String inputStr() {
		String str1 = sc.next();
		return str1;
	}
	public Ex04_Member(String mid, String mpw, String Mname) {
		super();
		sc = new Scanner(System.in);
		this.mid = mid;
		this.mpw = mpw;
		this.mName = Mname;
		
	}
	
}
