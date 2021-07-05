package tmp;
import java.io.*;
public class _12852_������_1�θ����2 {

	static int input;
	static int dp[];
	static int history[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		input = Integer.parseInt(br.readLine());
		dp = new int[input+1];
		history = new int[input+1];	//�ϳ����� ��������� 2�� ���� ��������� 3���� ���� ����������� 1,2,3������ ����
		
		for(int i=2; i<input+1; i++) {	//dp �� ����
			int three = Integer.MAX_VALUE;	//3���� ���� ��
			int two = Integer.MAX_VALUE;	//2�� ���� ��
			int one = dp[i-1]+1;	//1�� �� ���� dp[i-1]+1��
			if(i%3==0) three = dp[i/3] + 1;	//�������� ��� �� ä���
			if(i%2==0) two = dp[i/2] + 1;	//�������� ��� �� �߰��ϱ�
			dp[i] = Math.min(three, Math.min(two, one));	//���� ���� �� ã��
			if(i%3==0 && dp[i]-1 == dp[i/3]) history[i] = 3;	//� �����κ��� ����ߴ��� ����
			else if(i%2 == 0 && dp[i]-1 == dp[i/2]) history[i] = 2;
			else history[i] = 1;
		}
		
		bw.write(dp[input]+"\n");	//��� Ƚ�� ���
		while(input>0) {	//�����丮 ���
			bw.write(input+" ");
			if(history[input]==3 || history[input]==2) input /= history[input];	//2�� 3���� �������� ���� ������ �ε����� �پ��
			else input--;	//�ϳ� ���� ���� ���� �ε����� 1 ���̱�
		}
		bw.close();
		br.close();
	}

}
