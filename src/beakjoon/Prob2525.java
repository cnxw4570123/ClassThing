package beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Prob2525 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(br.readLine());
		int min, hour;
		if(B + C >= 60) {
			hour = ((B + C) / 60) + A;
			if(hour >= 24) 
				hour = hour % 24;
			min = (B + C) % 60;
		} else {
			hour = A; 
			min = B + C;
		}
		bw.write(hour + " " + min);
		bw.flush();
		bw.close();
	}
}
