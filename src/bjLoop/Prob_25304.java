package bjLoop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Prob_25304{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int X = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int totalP = 0;
		int[] priceList = new int[N];
		
		for(int i = 0; i < N; i++) {
//			int a = 0; int b = 0;
//			a = Integer.parseInt(st.nextToken());
//			b = Integer.parseInt(st.nextToken());
//			totalP += a * b;
			priceList[i] = Integer.parseInt(st.nextToken());
			totalP += priceList[2 * i] * priceList[2 * i + 1];
		}
		if(totalP == X) {
			bw.write("Yes");
		} else {
			bw.write("No");
		}
		bw.flush();
		bw.close();
	}

}
