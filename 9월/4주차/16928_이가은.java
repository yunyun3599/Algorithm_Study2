package week4;

import java.io.*;
import java.util.*;

public class _16928_뱀과사다리게임 {
	
	static HashMap<Integer,Integer> map = new HashMap<>();
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i < n+m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map.put(u, v);
		}
		System.out.println(bfs());
	}
	static int bfs() {
		Queue<Integer> q = new LinkedList<>(); 
		boolean[] visit = new boolean[101];
		int ans = 0;
		
		visit[1] = true;
		q.add(1);

		while(!q.isEmpty()) {
			int it = q.size();
			// 큐에 이동할 수 있는 경우의 수 많큼 더해졌으니까 그만큼 반복해서 봐야함 
			for(int i=0; i < it; i++) {
				int cur = q.poll();
				if(cur == 100) return ans;
				//주사위 던지기 6회 
				for(int dice=1; dice <= 6; dice++) {
					int next = cur + dice;
					
					if(next > 100 || visit[next]) break;
					//사다리나 뱀이용. 
					if(map.containsKey(next)){
						next = map.get(next);
						if(visit[next]) continue;
					}
					q.add(next);
					visit[next] = true;
				}
			}
			ans++;
		}
		return ans;
	}

}
