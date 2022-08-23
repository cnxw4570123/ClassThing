package day14;

public class Ex02_getSetMain {

	public static void main(String[] args) {
		
		String subject1 = "JAVA";
		int score1 = 80;
		
		Ex02_getSet sub1 = new Ex02_getSet();
		sub1.setSubject(subject1);
		sub1.setScore(score1);
		System.out.println(sub1.getScore());
		System.out.println(sub1.getSubject());
		System.out.println(sub1);
	}

}
