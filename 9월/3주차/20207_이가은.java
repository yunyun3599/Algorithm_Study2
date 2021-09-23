import java.io.*;
import java.util.*;

public class _20207_달력 {
	
	static int[] cal = new int[367];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			cal[start] += 1;
			cal[end+1] -= 1;
		}
		
		int ans = 0, width = 0, height = 0;
		for(int i=1; i< 367; i++) {
			cal[i] += cal[i-1]; //이전배열값 누적한 값 = 일정의 길이
			if(cal[i] == 0) {
				ans += width * height;
				width=0; height=0;
			}
			else {
				width++;
				height = Math.max(height, cal[i]);
			}
		}
		System.out.println(ans);
	}

}
