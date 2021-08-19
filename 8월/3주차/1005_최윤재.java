package tmp;
import java.util.*;
import java.io.*;

public class _1005_������_ACMCraft {
	
	static int testcase;
	static int N;
	static int K;
	static int W;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		while(testcase-- > 0) {		//�׽�Ʈ���̽���ŭ �ݺ�
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int[] time = new int[N+1];		//�� �ǹ� �Ǽ� �ð�
			int[] indegree = new int[N+1];	//�ش� ���� ������ edge ����
			int[] finish = new int[N+1];	//�ǹ� �ϼ����� �ҿ�Ǵ� �ð�
			LinkedList<Integer>[] graph = new LinkedList[N+1];	//�� �ǹ����� �ش� �ǹ� �ϰ� �Ŀ� ���� ������ �� �ִ� �ǹ� ��ȣ ����
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<N+1; i++) {	////////////////////�Ǽ� �ð� ����, �׷��� �ʱ�ȭ
				time[i] = Integer.parseInt(st.nextToken());
				graph[i] = new LinkedList<>();
			}
			for(int i=0; i<K; i++) {	//�Է� ó��
				st = new StringTokenizer(br.readLine()," ");
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				graph[first].add(second);	//�׷����� ���� ��ҵ� �߰�
				indegree[second]++;	//indegree���������ֱ�
			}
			W = Integer.parseInt(br.readLine());	//��ǥ �ǹ�
			
			Queue<Integer> q = new LinkedList<>();	//���������� ���� queue�̿�
			for(int i=1; i<N+1; i++) {
				if(indegree[i]==0) {	//���� ó������ ���� �� �ִ� �ǹ���
					q.add(i);
					finish[i] = time[i];
				}
			}
			while(!q.isEmpty()) {	//queue�� ���鼭 ��� ��� ó��
				int first = q.poll();
				for(int second : graph[first]) {	//���� ��尡 ���� �Ŀ� �Ǽ� ������ �ǹ��� queue�� ����
					finish[second] = Math.max(finish[second], finish[first]+time[second]);	//���� finish�� �ִ� ���� ���� ���Ǵ� �� �� �� ū ������ ����
					indegree[second]--;		//���� ��Ʈ �ϳ� ó�������Ƿ� indegree �ϳ� ����
					if(indegree[second]==0) q.add(second);	//indegree�� 0�̸� ������ ó���ؾ� �ϴ� ������ �� ó���� ���̹Ƿ� queue�� ����
				}
			}
			System.out.println(finish[W]);
		}
	}

}
