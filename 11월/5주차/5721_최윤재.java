package tmp;
import java.io.*;
import java.util.*;
public class _5721_������_�����ݱ��ȸ {

	static int N;
	static int M;
	static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		while(N!=0) {
			int[] dp = new int[N+1];	//�ش� ������� dp��
			for(int i=1; i<N+1; i++) {
				st = new StringTokenizer(br.readLine());
				int tmp[] = new int[M+1];	//�� �� ���� ���� ���� dp��
				for(int j=1; j<M+1; j++) {
					int num = Integer.parseInt(st.nextToken());
					if(j==1) tmp[1] = num;
					if(j>1) tmp[j] = Math.max(tmp[j-2]+num, tmp[j-1]);	//�ش� ������ ���� ũ�� ������ �� �ִ� ���
				}
				dp[i] = tmp[M];
				if(i>=2) {	//���ݱ����� ������� ������� �� ���� ũ�� ������ �� �ִ� ���
					dp[i] = Math.max(dp[i-2] + dp[i], dp[i-1]);
				}
			}
			answer.append(dp[N]+"\n");	//���� append
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}
		System.out.println(answer);
	}

}
