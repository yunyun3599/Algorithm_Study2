package tmp;
import java.io.*;
import java.util.*;

public class _3584_������_���尡���������� {
		
	static int testcase;
	static int N;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());	//�׽�Ʈ���̽� ���
		
		while(testcase-- > 0) {
			N = Integer.parseInt(br.readLine());	//��� ����
			int parent[] = new int[N+1];	//parent[i]�� i�� �θ� ��� ��ȣ ����
			for(int i=1; i<N; i++) {	//parent �迭 ä��
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int boomo = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				parent[child] = boomo;
			}
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());	//�θ� ������ ���
			boolean node1parent[] = new boolean[N+1];	//node1�� �θ� �� �ö󰡸鼭 ����
			int tmpparent = node1;
			while(tmpparent != 0) {
				node1parent[tmpparent] = true;	//node1�� �θ� �ش��ϸ� �迭�� ���� true�� �ٲ�
				tmpparent = parent[tmpparent];	//�� ���� ��� Ȯ��
			}
			tmpparent = node2;	//node2�� �θ� ����
			while(!node1parent[tmpparent]) {	//node1�� ���� �θ� ���� ������ �ݺ�
				tmpparent = parent[tmpparent];
			}
			result.append(tmpparent+"\n");	//��� append
		}
		System.out.println(result);	//��� ���
	}
}
