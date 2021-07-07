package tmp;
import java.util.*;
import java.io.*;

public class _2166_최윤재_다각형의면적 {
	
	static int num;
	static long[][] point;
	static long tmp1;
	static long tmp2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		point = new long[num][2];
		for(int i=0; i<num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			point[i][0] = Integer.parseInt(st.nextToken());
			point[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<num-1; i++) {
			tmp1 += point[i][0] * point[i+1][1];
			tmp2 += point[i][1] * point[i+1][0];
		}
		tmp1 += point[num-1][0] * point[0][1];
		tmp2 += point[num-1][1] * point[0][0];
		
		double result = Math.abs(tmp1-tmp2)/2.0;
		System.out.printf("%.1f", result);
	}

}
