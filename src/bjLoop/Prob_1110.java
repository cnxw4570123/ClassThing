package bjLoop;

import java.io.*;

public class Prob_1110 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String num  = N + "";
		int cnt = 0;
//		int num2 = -1;
//		while(N != Integer.parseInt(num)) {
//			cnt++;
//			num2 = Integer.parseInt(num);
//		}
		if(N < 10)
			num = "0" + N;
		do {
			num = Integer.parseInt(num.substring(0, 1)) +Integer.parseInt(num.substring(1, 2)) + " ";
			
		}while(N != Integer.parseInt(num));
		
	}

}
