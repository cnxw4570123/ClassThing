package beakjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Prob10171_Cat {

	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = "\\    /\\"+ "\n" +" )  ( ')" + "\n" + "(  /  )" + "\n" + " \\(__)|";
		bw.write(s);
		bw.flush();
		bw.close();
	}

}
