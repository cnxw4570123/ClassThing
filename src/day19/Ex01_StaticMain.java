package day19;

public class Ex01_StaticMain {

	public static void main(String[] args) {
		Ex01_Static ex01 = new Ex01_Static();
		ex01.setNum1(100);
		ex01.setStr1("A");
		System.out.println("ex01.num1 = " + ex01.getNum1());
//		ex01.number = 2000;
		Ex01_Static.number = 2000;
		System.out.println("ex01.number" + Ex01_Static.number);
		
		Ex01_Static ex02 = new Ex01_Static();
		System.out.println("ex02.number" + Ex01_Static.number);
		ex02.setNum1(200);
		ex02.setStr1("B");
		System.out.println("ex02.num1 = " + ex02.getNum1());
		
		Ex01_Static.number = 20;
		System.out.println("ex01.number" + Ex01_Static.number);
		System.out.println("ex02.number" + Ex01_Static.number);
	}

}
