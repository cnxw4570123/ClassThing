package day12;

import java.util.Scanner;

public class Ex01_ArraySearch02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] scoreList = {
								{"이름", "JAVA", "HTML"}, 
								{"학생1", "80", "90"},
								{"학생2", "88", "70"},
								{"학생3", "85", "95"}
								};
		System.out.print("검색할 과목>>");
		String searchSubject = sc.next();
		int idx = -1;
		for(int i = 1; i < scoreList[0].length; i++) {
			if (scoreList[0][i].equals(searchSubject)) {
				idx = i;
			}
		}
		if (idx > -1) {
			for (int i = 1; i < scoreList.length; i++) {
				System.out.println(scoreList[i][0] + " : " + scoreList[i][idx] + "점");
			}
		} else {
			System.out.println("과목을 찾을 수 없습니다.");
		}
		
		System.out.print("학생 이름 입력>>");
		String searchName = sc.next();
		for(int i = 1; i < scoreList.length; i++) {
			if(scoreList[i][0].equals(searchName)) {
				idx = i;
			}
		}
		if (idx > -1) {
			for (int i = 1; i < scoreList[idx].length; i++) {
				System.out.println(scoreList[0][i] + "점수 : " + scoreList[idx][i] + "점");
			}
		} else {
			System.out.println("학생을 찾을 수 없습니다.");
		}
	}
}

