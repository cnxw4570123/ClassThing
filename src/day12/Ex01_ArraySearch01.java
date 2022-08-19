package day12;

import java.util.Scanner;

public class Ex01_ArraySearch01 {

	public static void main(String[] args) {
		
		int[][]	numbers = { {1, 2, 3},
				            {4, 5},
				            {6, 7, 8, 9, 10}
						  };
		System.out.print("검색할 숫자 입력>>");
		Scanner sc = new Scanner(System.in);
		int indexI = -1;
		int indexJ = -1;
		int searchNum = sc.nextInt();
		
		for(int i = 0; i < numbers.length; i++) {
			for(int j = 0; j < numbers[i].length; j++) {
				if(searchNum == numbers[i][j]) {
					indexI = i;
					indexJ = j;
				}
			}
		}
		
		if(indexI > -1 && indexJ > -1) {
			System.out.println("정수 " + searchNum + "은(는) " + indexI +"행 " + indexJ + "열에 있습니다.");
		}
//		int index_i = -1;
//		int index_j = -1;
//		int num = 1000;
//		int idx = -1;
//		for(int i = 0; i < numbers.length; i++  ) {
//			for(int j = 0; j < numbers[i].length; j++) {
//				if(searchNumber == numbers[i][j]) {
//					System.out.println("정수 "+searchNumber+"은 "+i+"행 " + j+"열에 있습니다.");
//					index_i = i;
//					index_j = j;
//					idx = (i*100000 )+j; // 200000 + 2 = 2000002
//				}
//			}
//		}
//		System.out.println("확인 : "+numbers[idx/100000][(idx - (idx/100000)*100000)]   );
//		
//		if(index_i > -1) {
//			System.out.print("수정할 숫자 입력>>");
//			int modNum = scan.nextInt();
//			numbers[index_i][index_j] = modNum;
//			
//			for(int i = 0; i < numbers.length; i++  ) {
//				System.out.print(i + "행 : ");
//				for(int j = 0; j < numbers[i].length; j++) {
//					System.out.print("[" + numbers[i][j]+"]");
//				}
//				System.out.println();
//			}
//		} else {
//			System.out.println("숫자를 찾을 수 없습니다.");
//		}
//		
		
		
/*		
0행 : [1][2][3]
1행 : [4][5]
2행 : [6][7][8][9][10]
검색할 숫자 입력>>8
정수 8은 2행 2열에 있습니다.		
수정할 숫자 입력>> 50
0행 : [1][2][3]
1행 : [4][5]
2행 : [6][7][50][9][10]		
*/
	}

}
























