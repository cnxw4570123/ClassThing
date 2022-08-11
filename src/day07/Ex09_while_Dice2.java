package day07;

public class Ex09_while_Dice2 {

	public static void main(String[] args) {
		//int dice1 = (int)(Math.random() * 6) + 1;
		//int dice2 = (int)(Math.random() * 6) + 1;
		/*
		 * 두 개의 주사위를 던져서 나오는 눈을 출력 ( 5, 6)
		 * 두 개의 주사위의 눈이 같은 값일 경우에 종료.
		 * 두 개의 주사위의 눈이 다를 경우 주사위를 다시 던져서 
		 * 두 개의 주사위를 던져서 나오는 눈을 출력 
		 * 주사위의 눈이 같은 값이 나올 때까지 던진 횟수 출력
		 * 출력 후 종료 
		 */
		
		/*int cnt = 0;
		 * while true do
		 * 		cnt++;
		 * 		dice1, 2 -> (int)(Math.random() * 6 ) + 1
		 * 		print dice1, dice2
		 * 		if dice1 = dice2 then
		 * 				break;
		 * print cnt;
		 */
		int cnt = 0;
		while(true) {
			cnt++;
			int dice1 = (int)(Math.random() * 6) + 1;
			int dice2 = (int)(Math.random() * 6) + 1;
			System.out.println(dice1 + " " + dice2);
			if(dice1 == dice2)
				break;
		}
		System.out.println(cnt + "회");
	}

}
