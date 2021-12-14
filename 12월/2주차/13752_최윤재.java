import java.io.*;
import java.util.*;
public class _13752_최윤재_여러분의다리가되어드리겠습니다 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] bridge = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) bridge[i] = new ArrayList<>();
		boolean visited[] = new boolean[N+1];
		for(int i=0; i<N-2; i++) {	//연결된 다리 입력받기 
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			bridge[node1].add(node2);
			bridge[node2].add(node1);
		}
		visit(1, bridge, visited);	//1번 노드와 연결된 모든 섬 visited 참으로 바꾸기 
		for(int i=1; i<N + 1; i++) {	//visited가 참이 아닌 노드와 1을 출력 
			if(!visited[i]) {
				System.out.println(1+" "+i);
				break;
			}
		}
	}
	
	public static void visit(int node, ArrayList<Integer>[] bridge, boolean[] visited) {
		if(visited[node]) return;
		visited[node] = true;
		for(int i=0; i<bridge[node].size(); i++) {
			visit(bridge[node].get(i), bridge, visited);
		}
	}
}
