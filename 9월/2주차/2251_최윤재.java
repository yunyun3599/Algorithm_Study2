package tmp;
import java.util.*;

public class _2251_������_���� {

	static int[] volume =  new int[3];	//�� ������ �뷮
	static ArrayList<Integer> result = new ArrayList<>(); //��� ����
	static boolean visited[][][];	//�ش� �� ������ ������ ������ �־����� Ȯ��
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
		volume[0] = Integer.parseInt(st.nextToken());
		volume[1] = Integer.parseInt(st.nextToken());
		volume[2] = Integer.parseInt(st.nextToken());
		visited = new boolean[volume[0]+1][volume[1]+1][volume[2]+1];
		////////////////////////////////////////////////////////////////////�Է�
		Queue<int[]> queue = new LinkedList<>();	//bfs
		visited[0][0][volume[2]] = true;	//�ʱⰪ �湮 ó��
		result.add(volume[2]);	//�ʱⰪ ����� add
		queue.add(new int[] {0, 0, volume[2]});
		
		while(!queue.isEmpty()) {	//bfs
			int[] prev = queue.poll();	//���� ��
			for(int i=0; i<3; i++) {		//i���� j�� �� �ű�� ���
				for(int j=0; j<3; j++) {
					if(i==j) continue;	//���� bucket�̸� continue
					int[] next = pour(i, j, prev); //���� ���� ���� �� ����
					if(!visited[next[0]][next[1]][next[2]]) {	//���ݱ��� �ش� ���� �뷮 ������ ���� ����� ���� ����
						if(next[0]==0) result.add(next[2]);	//ù��° bucket�� ����� ��
						visited[next[0]][next[1]][next[2]] = true;	//visitedó��
						queue.add(next);	//bfs
					}
				}
			}
		}
		Collections.sort(result);	//��� �������� ���
		StringBuilder sb = new StringBuilder();
		for(int C : result) sb.append(C+" ");
		System.out.println(sb);
	}
	
	public static int[] pour(int from, int to, int prev[]) {
		int[] next = new int[3];	//������
		next[0] = prev[0];
		next[1] = prev[1];
		next[2] = prev[2];
		//from�� ���� ���� ��� to�� ���� �� �ִ� ���
		if (volume[to] >= prev[from]+prev[to]) {
			next[from] = 0;
			next[to] = prev[from]+prev[to]; 
		}
		//to�� �ش��ϴ� bucket�� �� ���� ���
		else {
			next[from] = prev[from]+prev[to] - volume[to];
			next[to] = volume[to];
		}
		return next;	//�� ���� ��� ����
	}
}
