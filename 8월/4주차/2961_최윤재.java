package tmp;
import java.io.*;
import java.util.*;
public class _2961_������_�����̰�������ִ����� {
	
	static int N;	//����
	static int[] S;	//�� ���� �迭
	static int[] B;	//�� ���� �迭
	static int sour = 1;	//�Ű� �ѷ�
	static int bitter = 0;	//���� �ѷ�
	static int result = Integer.MAX_VALUE;	//�ּ� ����

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}///////////////////////////////////////////////�Է�
		for(int i=1; i<=N; i++) {	//i�� ������ ��� ����
			sour = 1;
			bitter = 0;
			for(int j=0; j<N; j++) {	//j�� �ε����� �� �����ؼ� �����غ���
				sour *= S[j];
				bitter += B[j];
				calc(j+1, 1, i);	//���� �ε��� Ȯ��
				sour /= S[j];
				bitter -= B[j];
			}
		}
		System.out.println(result);
	}
	public static void calc(int idx, int depth, int num) {
		if(depth == num) {	//������ ������ �����ϱ�� �� ������ �������� ��� Ȯ��
			result = Math.min(result, Math.abs(sour-bitter));
			return;
		}
		for(int i=idx; i<N; i++) {	//�߰��� ���� �ֱ�
			sour *= S[i];
			bitter += B[i];
			calc(i+1, depth+1, num);
			sour /= S[i];		//�� ���󺹱�
			bitter -= B[i];
		}
	}
}
