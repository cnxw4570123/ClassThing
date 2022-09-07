package day16;

import java.util.ArrayList;

public class Ex01_ArrayList {

	public static void main(String[] args) {
		String[] strList1 = new String[10];
		strList1[0] = "A";
		strList1[1] = "B";
//		strList1[2] = "C";
//		for(int i = 0; i < strList1.length; i++) {
//			System.out.println(strList1[i]);
//		}
		
		ArrayList<String> strList2 = new ArrayList<String>();
		System.out.println(strList2.size());
		strList2.add("A");
		System.out.println(strList2.size());
		strList2.add("B");
		System.out.println(strList2.size());
		
		strList2.add("C");
		
		for(int i = 0; i < strList2.size(); i++) {
			System.out.print("i : " + i);
			System.out.println(" : " + strList2.get(i));
		}
	}

}
