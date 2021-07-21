import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
	int v, cost;
	public Edge(int v, int cost) {
		this.v = v; this.cost = cost;
	}
	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans = 0, cnt = 0, max = 0;
		
		boolean[] visit = new boolean[N];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		ArrayList<Edge>[] li = new ArrayList[N];
		for(int i = 0; i < N; i++) li[i] = new ArrayList<>(); //li 초기화 
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			li[a].add(new Edge(b,c));
			li[b].add(new Edge(a,c));
		}
		
		pq.add(new Edge(1,0));
		
		while(!pq.isEmpty()) { //MST만들기 
			Edge edge = pq.poll();
			if(visit[edge.v]) continue;
			visit[edge.v] = true;
			ans += edge.cost;
			max = Math.max(max, edge.cost);
			
			for(Edge next: li[edge.v]) {
				if(!visit[next.v]) pq.add(next);
			}
			if(++cnt == N) break;
		}
		System.out.println(ans-max); //MST의 edge중 최대를 빼면 구하려는 answer
	}

}
