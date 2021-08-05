package tmp;
import java.io.*;
import java.util.*;
public class _21317_������_¡�˴ٸ��ǳʱ�2 {

	static int N;		//�� �� ����
	static int[] small;	//�������� ������
	static int[] big;	//ū ���� ������
	static int K;	//�ſ�ū���� ������
	static int min = Integer.MAX_VALUE;	//�ּ� ������ �Һ�
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		small = new int[N-1];
		big = new int[N-1];
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			small[i] = Integer.parseInt(st.nextToken());
			big[i] = Integer.parseInt(st.nextToken());
		}
		K = Integer.parseInt(br.readLine());		////�Է�
		jump(0,0,false);	//0�������� 0�ο����� �Һ��̰� �ſ�ū���� ���ѻ��·� ����
		System.out.println(min);	//������
	}
	public static void jump (int num, int result, boolean jump3) {
		if(num==N-1) {	//������ ���� �������� ��
			min = Math.min(min, result);	//�� �������� �� ������ min�� ������Ʈ
			return;
		}
		if(num>N-1) return;	//���� �Ѿ�������
		if(!jump3) {	//���� �ſ�ū���� �Ⱦ� ���
			jump(num+3, result+K, true);	//�ſ�ū������ �Ἥ 3ĭ ���� ���� �̵�
		}
		jump(num+1, result+small[num], jump3);	//���������� �ϴ� ���
		jump(num+2, result+big[num], jump3);	//ū������ �ϴ� ���
	}
}
