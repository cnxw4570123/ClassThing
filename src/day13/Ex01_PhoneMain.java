package day13;

public class Ex01_PhoneMain {

	public static void main(String[] args) {
		Ex01_Phone ph1 = new Ex01_Phone();
		System.out.println("ph1.color : " + ph1.color);
		System.out.println("ph1.telecom : " + ph1.telecom);
		System.out.println("ph1.storage : " + ph1.storage);
		
		Ex01_Phone Sk_Phone = new Ex01_Phone("SK");
		System.out.println("Sk_Phone.telecom : " + Sk_Phone.telecom);
		System.out.println("Sk_Phone.storage : " + Sk_Phone.storage);
		Sk_Phone.color = "blue";
		Sk_Phone.storage = 256;
		
		Ex01_Phone ph_256 = new Ex01_Phone(256);
		System.out.println("ph_256.telecom : " + ph_256.telecom);
		System.out.println("ph_256.storage : " + ph_256.storage);
		
		System.out.println("======================================");
		System.out.println("ph1.showInfo() 호출");
		ph1.showInfo();
		
		System.out.println("Sk_Phone.showInfo() 호출");
		Sk_Phone.showInfo();
		int result = Sk_Phone.printNumber2();
	}

}
