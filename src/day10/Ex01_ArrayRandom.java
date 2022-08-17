package day10;

public class Ex01_ArrayRandom {

	public static void main(String[] args) {
//		int[] randomNum = new int[10];
//		
//		for(int i = 0; i < randomNum.length; i++) {
//			int inputNum;
//			while(true) {
//				boolean check = false;
//				inputNum = (int)(Math.random() * 10) + 1;
//				for(int j = 0; j < randomNum.length; j++) {
//					if(inputNum == randomNum[j])
//						check = true;
//				}
//				if(!check)
//					break;
//			}
//			randomNum[i] = inputNum;
//		}
//		
//		for(int i = 0; i < randomNum.length; i++) {
//			System.out.print("[" + randomNum[i] + "]");
//		}
		
//		System.out.println("============================");
		
//		int[] randomNum = new int[10];
//		
//		for(int i = 0; i < randomNum.length; i++) {
//			int inputNum = (int)(Math.random() * 10) + 1;
//			boolean check = false;
//			
//			for(int j = 0; j < randomNum.length; j++) {
//				if(inputNum == randomNum[j])
//					check = true;
//			}
//			if(!check)
//				randomNum[i] = inputNum;
//			else
//				i--;
//			
//		}
//		
//		for(int i = 0; i < randomNum.length; i++) {
//			System.out.print("[" + randomNum[i] + "]");
//		}
//		
		System.out.println("===========================");
		int[] randomNum = new int[10];
		
		for(int i = 0; i < randomNum.length; i++) {
			int inputNum = (int)(Math.random() * 10) + 1;
			boolean check = false;
			
			for(int j = 0; j < i; j++) {
				if(inputNum == randomNum[j])
					check = true;
			}
			if(!check)
				randomNum[i] = inputNum;
			else
				i--;
			
		}
		
		for(int i = 0; i < randomNum.length; i++) {
			System.out.print("[" + randomNum[i] + "]");
		}
	}
}
