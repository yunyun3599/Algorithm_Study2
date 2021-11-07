package tmp;
import java.io.*;
import java.util.*;

public class _11058_������_ũ������ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+1];
		for(int i=1; i<N+1; i++) {
			if(i<=6) {
				dp[i] = i;		//6��°������ �׳� Ƚ����ŭ�� �ִ밪
				continue;
			}
			else {
				for(int j=2; j<5; j++) {		//���ǰ��� �ٿ��ֱ� �ϴ� �� �ϳ� ������Ű�� �� ���� ũ�Ƿ� 3ȸ ������ ����, 6ȸ�� �ͺ��ʹ� 3ȸ�� ���� �ٿ��ֱ�� �̹� �׽�Ʈ �غ����� ���ص� ��
					dp[i] = Math.max(dp[i-(j+1)]*j, dp[i]);	//����,����.�ٿ��ֱ� 3�ܰ谡 �ʿ��ϹǷ� 3ȸ ���� ���̸� 2��, 4ȸ ���� ���̸� 3��, 5ȸ ���� ���̸� 4�谡 ��
				}
			}
		}
		System.out.println(dp[N]);
	}

}
