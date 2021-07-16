package tmp;
import java.util.*;
import java.io.*;
public class _2841_������_�ܰ����Ǳ�Ÿ���� {

	static int N;
	static int P;
	static Stack<Integer>[] stack = new Stack[6];	//�� �ٿ� ���� stack �̿�
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	//�� ����
		P = Integer.parseInt(st.nextToken());	//���� ����
		
		for(int i=0; i<6; i++) {
			stack[i] = new Stack<Integer>();	//���� ����
		}
		
		for(int i=0; i<N; i++) {	//������ �� ������ŭ �ݺ�
			st = new StringTokenizer(br.readLine());
			int note = Integer.parseInt(st.nextToken())-1;	//���� ����
			int fret = Integer.parseInt(st.nextToken());	//���� ��������
			if(stack[note].isEmpty()) {	//�ش� �ٿ� �ƹ��͵� �ȴ����� ���� ��
				stack[note].push(fret);	//�׳� ������ ��
				cnt++;	//�������ϱ� ī��Ʈ ����
			}
			else {
				while(!stack[note].isEmpty() && stack[note].peek()>fret) {	//���� ���� �������� ���� ������ �� pop
					stack[note].pop();
					cnt++;	//cnt ����
				}
				if(stack[note].isEmpty() || stack[note].peek()!=fret) {	//stack�� ����ְų� top���� �ڱ� �ڽ��� �ƴ� -> �ش� ���� ������ ���� ����������
					cnt++;	//cnt ����
					stack[note].push(fret);	//���� �������� ǥ��
				}
			}
		}
		System.out.println(cnt);
	}

}
