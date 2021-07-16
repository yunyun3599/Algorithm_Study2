import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken());
		
		Stack<Integer>[] stks = new Stack[7];
		for(int i = 0; i < 7; i++) stks[i] = new Stack<Integer>();
		int ans = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int line = Integer.parseInt(st.nextToken());
			int pret = Integer.parseInt(st.nextToken());
			
			while(!stks[line].isEmpty() && stks[line].peek() > pret) {
				stks[line].pop();
				ans++;
			}
			
			if(stks[line].isEmpty() || stks[line].peek() < pret) {
				stks[line].push(pret);
				ans++;
			}
		}
		System.out.println(ans);

	}

}
