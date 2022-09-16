package day14;

public class Ex02_getSet {
	private String subject; // 과목명
	private int score; 		// 점수
	int score2;
	
	public void setScore(int val) {
		if(val < 0) {
			score = 0;
		}
		this.score = val;
	}
	
	public int getScore() {
		return this.score;
	}
	public void setSubject(String str) {
		this.subject = str;
	}
	
	public String getSubject() {
		return this.subject;
	}

//	@Override
//	public String toString() {
//		return "Ex02_getSet [subject=" + subject + ", score=" + score + ", score2=" + score2 + "]";
//	}
	
	
}
