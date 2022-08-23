package day14;

import java.util.Scanner;

public class Ex03_PhoneBookMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 전화 번호부
		Ex03_PhoneBook[] pbList = new Ex03_PhoneBook[5];

		Ex03_PhoneBook phonebook1 = new Ex03_PhoneBook();
		System.out.print("이름입력>>");
		String name1 = sc.next();
		System.out.print("전화번호입력>>");
		String tel1 = sc.next();
		phonebook1.setName(name1);
		phonebook1.setTel(tel1);
		phonebook1.setNumber(1);
		pbList[0] = phonebook1;

		Ex03_PhoneBook phonebook2 = new Ex03_PhoneBook();
		System.out.print("이름입력>>");
		String name2 = sc.next();
		System.out.print("전화번호입력>>");
		String tel2 = sc.next();
		phonebook2.setName(name2);
		phonebook2.setTel(tel2);
		phonebook2.setNumber(1);
		pbList[1] = phonebook2;

		for (int i = 0; i < pbList.length; i++) {
			if (pbList[i] != null)
//				System.out.println("이름 : " + pbList[i].getName());
				System.out.println(pbList[i]);
		}
		/*
		for(int i = 0; i < pbList.length; i++) {
			pbList[i] = new Ex03_PhoneBook();
			System.out.print((i+1)+"번 이름입력>>");
			String nm = sc.next();
			pbList[i].setName(nm);
			System.out.print((i+1)+"번 전화번호입력>>");
			nm = sc.next();
			pbList[i].setTel(nm);
			System.out.print((i+1)+"번 단축키입력>>");
			int num = sc.nextInt();
			pbList[i].setNumber(num);
			System.out.println(i+1 + "번 단축키 : " + pbList[i].getNumber());
			System.out.println(i+1 + "번 전화번호 : " + pbList[i].getTel());
			System.out.println(i+1 + "번 이름 : " + pbList[i].getName());
		}
		*/
	}

}
