package day16;

import java.util.ArrayList;

public class Ex01_ArrayList2 {

	public static void main(String[] args) {
//		ArrayList<Integer> intList = new ArrayList<Integer>(); // int 타입을 굳이 리스트까지 만드는 경우 잘 없음.
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("A");
		strList.add("B");
		strList.add("C");
		strList.add("D");
		strList.add("E");
		for(int i = 0; i < strList.size(); i++) {
			System.out.println("strList.get(" + i + ") : " + strList.get(i));
		}
//		System.out.println("strList.get(5) : " + strList.get(5));
		System.out.println();
		strList.add(2, "목요일");
		for(int i = 0; i < strList.size(); i++) {
			System.out.println("strList.get(" + i + ") : " + strList.get(i));
		}
		System.out.println();
		strList.remove(2);
		for(int i = 0; i < strList.size(); i++) {
			System.out.println("strList.get(" + i + ") : " + strList.get(i));
		}
		
		System.out.println();
		strList.remove("F");
		for(int i = 0; i < strList.size(); i++) {
			System.out.println("strList.get(" + i + ") : " + strList.get(i));
		}
		
//		ArrayList<String> strList2 = new ArrayList<String>();
//		strList2.add(2,"A");
	}

}
