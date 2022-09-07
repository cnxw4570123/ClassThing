package day13;

public class Ex04_MemberMain {
	
	public static void main(String[] args) {
		Ex04_Member mem01 = new Ex04_Member("aaa", "1111", "에이");
		
		Ex04_Member mem02 = new Ex04_Member("bbb", "1234", "비");

		Ex04_Member mem03 = new Ex04_Member("ccc", "qwer", "씨");
		
		Ex04_Member[] memberList = new Ex04_Member[5];
		memberList[0] = mem01;	
		memberList[1] = mem02;	
		memberList[2] = mem03;	
		memberList[3] = new Ex04_Member("ddd","rweq", "디");
		
		String inputName = "에이";
		System.out.println(memberList[0].mName);
		System.out.println(memberList[0].mName.equals(inputName));
		System.out.println("아이디는 : " + memberList[0].mid);
		
		System.out.println(memberList[0].mid);

		System.out.println(memberList[1].mid);
		
		System.out.println(memberList[2].mid);
	}

}
