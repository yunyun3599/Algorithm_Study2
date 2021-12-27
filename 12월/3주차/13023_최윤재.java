package tmp;
import java.io.*;
import java.util.*;
public class _13023_������_ABCDE {

	static int N;
	static int M;
	static ArrayList<Integer>[] adj;	//��������Ʈ
	static boolean[] visited;
	static boolean isPossible;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N];
		for(int i=0; i<N; i++) adj[i] = new ArrayList<Integer>();
		visited = new boolean[N];
		for(int i=0; i<M; i++) {	//ģ�� ��� �ޱ�
			st = new StringTokenizer(br.readLine());
			int person1 = Integer.parseInt(st.nextToken());
			int person2 = Integer.parseInt(st.nextToken());
			adj[person1].add(person2);
			adj[person2].add(person1);
		}
		for(int i=0; i<N; i++) {	//dfs����
			dfs(i, 0);
			if(isPossible) break;	//������ ��찡 �ϳ��� �߰ߵǸ� ���̻� �������� ����
		}
		if(isPossible) System.out.println(1);
		else System.out.println(0);
	}
	public static void dfs(int person, int depth) {
		visited[person] = true;	//�湮ó��
		if(depth >= 4) {	//depth�� 4 �̻��̸� ���� ����
			isPossible = true; 
			return;
		}
		for(int friend : adj[person]) {	//ģ���� �� ���� �湮 ���� ģ���� ���� dfs �� ����
			if(!visited[friend]) dfs(friend, depth+1);
		}
		visited[person] = false;
	}

}
