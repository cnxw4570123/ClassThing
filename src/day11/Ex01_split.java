package day11;

public class Ex01_split {

	public static void main(String[] args) {
		String menu1 = "바닐라라떼 : 5000";
		System.out.println(menu1);
		String[] menu1_split = menu1.split(" : "); // "바닐라라떼 : 5000" >> "바닐라라떼" , "5000"
		System.out.println("menu1_split.length : " + menu1_split.length);
		System.out.println(menu1_split[0]);
		System.out.println(menu1_split[1]);

		String menu2 = "카페라떼 : 4000";
		System.out.println("메뉴는 " + menu2.split(" : ")[0]);
		System.out.println("가격은 " + menu2.split(" : ")[1]);
		System.out.println("========================================");
		String[] menu = { "바닐라라떼:5000", "카페라떼:4000", "아이스티:3000",
						  "꿀아메리카노:2500", "아메리카노:2000" };
		// menu에 있는 0번 인덱스의 문자열을 메뉴, 가격으로 분리
		System.out.println(menu[0].split(":")[0] + " 구분 " + menu[0].split(":")[1]);
		
		System.out.println("메뉴선택>>");
		int selectMenu = 4;
		String menuName = menu[selectMenu].split(":")[0];
//		String menuPrice = menu[selectMenu].split(":")[1];
		int menuPrice_int = Integer.parseInt(menu[selectMenu].split(":")[1]);
		System.out.println("[" + menuName + "선택]");
		System.out.println("[" + menuPrice_int + "원입니다.]");
		System.out.println(menuPrice_int + 5000);
		
		String str1 = "10000";
		System.out.println(Integer.parseInt(str1) + 5000);
	}

}
