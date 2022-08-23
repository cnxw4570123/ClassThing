package beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Prob3003 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] chess = new int[6];
		
		for(int i = 0; i < chess.length; i++) {
			chess[i] = Integer.parseInt(st.nextToken());
		}
		if (chess[0] != 1) {
			bw.write(chess[0] - );
		}
	}

}
