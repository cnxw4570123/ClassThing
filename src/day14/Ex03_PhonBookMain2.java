package day14;

import java.util.Scanner;

public class Ex03_PhonBookMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Ex03_PhoneBook[] pbList = new Ex03_PhoneBook[10];

		boolean run = true;
		int idx = -1;

		while (run) {
			System.out.println("=================================");
			System.out.println(" [1]저장 | [2]출력 | [3]검색 | [4]종료");
			System.out.println("=================================");
			System.out.print("메뉴선택>>");
			switch (sc.nextInt()) {
			case 1:

				System.out.println("[1]저장");
				System.out.print("저장할 이름입력>>");
				String inputName = sc.next();
				System.out.print("저장한 전화번호입력>>");
				String inputTel = sc.next();
				idx++;
				pbList[idx] = new Ex03_PhoneBook(idx + 1, inputName, inputTel);
				if (idx == pbList.length) {
					idx = idx % pbList.length;
				}
				break;
			case 2:
				System.out.println("[2]출력");
				for (int i = 0; i < pbList.length; i++) {
					if (pbList[i] != null) {
						System.out.println(pbList[i]);
					}
				}
				break;

			case 3:
				System.out.println("[3]검색");
				int tmp = -1;
				System.out.print("검색할 이름>>");
				String s = sc.next();
				for (int i = 0; i < pbList.length; i++) {
					if (pbList[i] != null) {
						if (pbList[i].getName().equals(s))
							tmp = i;
					}
				}
				if (tmp == -1) {
					System.out.println("연락처를 찾을 수 없습니다.");
				} else {
					System.out.println("단축번호 : " + pbList[tmp].getNumber());
					System.out.println("전화번호 : " + pbList[tmp].getTel());
					System.out.print("연락처를 수정하시겠습니까([1]Y [2]N>>");
					if(sc.nextInt() == 1) {
						System.out.print("수정할 전화번호입력>>");
						pbList[tmp].setTel(sc.next());
						System.out.println("전화번호가 수정되었습니다.");
					}else {
						System.out.println("취소 되었습니다.");
					}
				}
				break;

			case 4:
				System.out.println("[4]종료");
				run = false;
				break;

			default:

			}
		}
		System.out.println("전화번호부 종료");
	}
}
