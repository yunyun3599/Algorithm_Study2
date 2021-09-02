import java.io.*;
import java.util.*;
public class _10971_외판원순회2 {
	
	static boolean[] visit;
	static int[] route;
	static int[][] w;
	static int n, ans=Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		w = new int[n][n];
		visit = new boolean[n];
		route = new int[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		go(1);
		System.out.println(ans);
	}

	static void go(int cnt) {
		if(cnt == n) {
			int sum = 0, prev = 0;
			boolean ok = true;
			for(int i=1; i<n; i++) {
				int next = route[i];
				if(w[prev][next] == 0) { //연결되어있지 않으면 break
					ok = false;
					break;
				}
				else sum += w[prev][next]; //도시가 연결되어있으면 합에 더하기
				prev = next;
			}
			if(ok) {
				if(w[prev][0] != 0) { //다시 처음도시로 돌아올 수 있을 때 최솟값 갱신
					if(sum + w[prev][0] < ans) ans = sum + w[prev][0];
				}	
			}
			return;
		}		
		for(int i=1; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				route[cnt] = i;
				go(cnt+1);
				visit[i] = false;
			}
		}
	}
}
