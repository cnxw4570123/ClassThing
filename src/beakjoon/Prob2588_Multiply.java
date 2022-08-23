package beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Prob2588_Multiply {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		
		int result1 = A * (B % 10);
		int result10 = A * ((B % 100) - (B % 10));
		int result100 = A * (B - (B % 100));
		
		bw.write(result1 + "\n");
		bw.write(result10 / 10 + "\n");
		bw.write(result100 / 100 + "\n");
		
		bw.write(result1 + result10 + result100 + "\n");
		bw.flush();
		bw.close();
	}

}
