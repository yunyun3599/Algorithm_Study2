package tmp;
import java.util.*;
import java.io.*;

public class _10971_������_���ǿ���ȸ2 {

	static int N;
	static int adj[][];	//�����迭
	static boolean visited[];	//�湮ó��
	static int result = Integer.MAX_VALUE;	//���
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adj = new int[N][N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}/////////////////////////////////�Է�
		visited[0] = true;	//0��° ���÷� ���� (������ ��ȯ�̶� �����ϴ� ���� ��� ����)
		move(0, 0, 1);	//���� ��ġ�� ����, ������� weight�� ��, �湮�� ���� ���� ������ �Ķ����
		System.out.println(result);	//��� ���
	}
	public static void move(int current, int total, int num) {
		if(num==N) {	//��� ���ø� �� ������ �� (�ٽ� 0�� ���÷� ���ư��� ��)
			if(adj[current][0]!=0) result  = Math.min(result, total+adj[current][0]);	//���� ���ÿ��� 0�� ���÷� �� �� ���� ��
			return;
		}
		else {	//���� �湮�� ���ð� ������ ��
			for(int i=0; i<N; i++) {
				if(!visited[i] && adj[current][i]!=0) {	//���� �湮 ���߰� ���� ��ġ���� �� �� �ִ� ���� �湮�ϱ�
					visited[i] = true;
					move(i, total+adj[current][i], num+1);
					visited[i] = false;
				}
			}
		}
	}
}