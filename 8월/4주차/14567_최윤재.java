package tmp;
import java.io.*;
import java.util.*;
public class _14567_������_�������� {

	static int N;
	static int M;
	static int lecture[];
	static int indegree[];
	static int semester = 1;
	static LinkedList<Integer>[] prerequisite;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lecture = new int[N+1];		//���� �б⿡ �����ߴ��� ����
		indegree = new int[N+1];	//������ ȭ��ǥ ����
		prerequisite = new LinkedList[N+1];	//�ش� ������ �������������� ���� ����� ����
		for(int i=1; i<N+1; i++) {
			prerequisite[i] = new LinkedList<Integer>();	//�ʱ�ȭ
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			indegree[second]++;		//������ ȭ��ǥ ���� �ϳ� �ø���
			prerequisite[first].add(second);	//���������� ���� ǥ��
		}////////////////////////////////////////////////////////�Է�
		Queue<Integer> queue = new LinkedList<>();	//ť
		for(int i=1; i<N+1; i++) {	//ó���б⿡ ������ �� �ִ� ����� queue�� �ֱ�
			if(indegree[i]==0) {
				queue.add(i);
				lecture[i] = semester;	//���� �б� lecture �迭�� ����
			}
		}
		while(!queue.isEmpty()) {	//queue�� �������� �ݺ�
			semester++;	//�б� 1 ����
			int qsize = queue.size();	//�����б⿡ ���� ��ŭ�� �ݺ��ؾ��ϹǷ� queue�� ���� ���� ���� ���س���
			for(int i=0; i<qsize; i++) {	//queue�� ���� ����鿡 ���� �ݺ�
				int before = queue.poll();
				for(int next : prerequisite[before]) {	//�ش� ������ ������������ ���� �����
					indegree[next]--;	//������ ȭ��ǥ �ϳ� ���̱�
					if(indegree[next]==0) {	//������ ���� �ϴ� ������� �� ���� ���
						lecture[next] = semester;	//�ش� ������ lecture�迭�� ���� �б� ����
						queue.add(next);	//queue�� �ش� ���� �ֱ�
					}
				}
			}
		}
		for(int i=1; i<N+1; i++) {
			bw.append(lecture[i]+" ");	//��� ���
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
