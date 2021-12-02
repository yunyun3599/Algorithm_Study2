package tmp;
import java.io.*;
import java.util.StringTokenizer;
public class _5557_������_1�г� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int input[] = new int[N-1];
		long dp[][] = new long[N-1][21];	//row���� ���ڸ� ����� �Ŀ� ���� �� �ִ� ����� column�� ����� ��
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		int target = Integer.parseInt(st.nextToken());	//���������� ���� ����
		////////////////////�Է�
		
		dp[0][input[0]] = 1;
		for(int i=1; i<N-1; i++) {	//�� ���ڿ� ���� ����
			for(int j=0; j<21; j++) {
				if(dp[i-1][j]>0) {		//���� ���ڱ��� ������� �� j�� ���� �� �ִ� ���
					if(j-input[i]>=0) {	//�̹� ���ڸ� �� ����� ���� �̳��� ���
						dp[i][j-input[i]] += dp[i-1][j];
					}
					if(j+input[i] <=20) {
						dp[i][j+input[i]] += dp[i-1][j];
					}
				}
			}
		}
		System.out.println(dp[N-2][target]);	//��� ���
	}

}
