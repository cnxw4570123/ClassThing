package bjLoop;

import java.io.*;
import java.util.StringTokenizer;

public class Prob_10871 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N, X;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		String numbers = br.readLine();
		st = new StringTokenizer(numbers);
		for(int i = 0; i < N; i++) {
			int A = Integer.parseInt(st.nextToken());
			if(A < X)
				bw.write(A + " ");
		}
		bw.flush();
		bw.close();
	}
}
