package bjLoop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Prob_2480_1 {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dice = new int[3];
		
		for(int i = 0; i < dice.length; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		int overLap = 0;
		int diceNum = 0;
		int highD = dice[0];
		for(int i = 0; i < dice.length; i++) { // 0 1 2
			if(dice[i % 3] == dice[(i + 1) % 3]) {
				overLap++;
				diceNum = dice[i];
			} else {
				if(highD < dice[i])
					highD = dice[i];
			}
		}
		switch(overLap) {
		case 0:
			bw.write(highD * 100 + "");
			break;
		case 1:
			bw.write(diceNum * 100 + 1000 + "");
			break;
		default:
			bw.write(diceNum * 1000 + 10000 + "");
			break;
		}
		bw.flush();
		bw.close();
	}
}
