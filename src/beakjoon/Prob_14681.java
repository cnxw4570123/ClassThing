package beakjoon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Prob_14681 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int X = Integer.parseInt(br.readLine());
		int Y = Integer.parseInt(br.readLine());
		
		if(X > 0 && Y > 0){
			bw.write(1 + "");
		} else if(X < 0 && Y > 0) {
			bw.write(2 + "");
		}else if(X < 0 && Y < 0) {
			bw.write(3 + "");
		}else
			bw.write(4 + "");
		
		bw.flush();
		bw.close();
		
	}

}
