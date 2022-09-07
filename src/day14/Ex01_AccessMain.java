package day14;

public class Ex01_AccessMain {

	public static void main(String[] args) {
		Ex01_Access ac = new Ex01_Access();
		//publicValue에 10을 저장
		ac.publicValue = 10;
		//privateValue에 10을 저장
		//ac.privateValue = 20;
		
		//publicMethod() 호출
		ac.publicMethod();
		//privateMethod() 호출
//		ac.privateMethod();
		ac.protectedValue = "Protectedvalue";
		ac.defaultValue = "defaultvalue";
		/*
		Ex01_Access2 access = new Ex01_Access2();
		access.intValue = 100;
		System.out.println(access.intValue);
		Ex01_Access2 access2 = new Ex01_Access2();
		System.out.println(access2.intValue);
		Ex01_Access2 access3 = new Ex01_Access2();
		System.out.println(access3.intValue);
		*/
		
		Ex01_Access2 acc = Ex01_Access2.getInstance();
		System.out.println(acc.intValue);
		acc.intValue = 1000;
		System.out.println(acc.intValue);

		Ex01_Access2 acc2 = Ex01_Access2.getInstance();
		System.out.println(acc2.intValue);
		acc2.intValue = 200;
		System.out.println(acc.intValue);
	}

}
