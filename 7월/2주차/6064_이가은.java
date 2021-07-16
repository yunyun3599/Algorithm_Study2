import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- >0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			boolean flag = false;
			
			for(int i = x; i < m*n; i+=m) {
				if(i%n == y) {
					System.out.println(i+1);
					flag = true;
					break;
				}
			}
			if(!flag) System.out.println(-1);
		}
	}
}
