package bjLoop;

import java.util.StringTokenizer;
import java.io.*;

public class Prob_10952 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if(A == 0 & B == 0)
				break;
			else {
				bw.write((A + B) + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
