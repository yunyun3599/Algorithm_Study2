package tmp;

import java.io.*;
import java.util.*;

public class _1495_������_��Ÿ����Ʈ {

	static int N;
	static int S;
	static int M;
	static int[] volume;
	static boolean[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		volume = new int[N+1];
		dp = new boolean[N+1][M+1];	//dp[i][j]�� i��° ���� j �������� ���ְ������� ����
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			volume[i] = Integer.parseInt(st.nextToken());
		}
		dp[0][S] = true;	//ó�� ���� ����
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=M; j++) {
				if(!dp[i-1][j]) continue;	//���� ȸ������ �ش� �������� �������� ���� ���
				if(j - volume[i] >=0) dp[i][j-volume[i]] = true;	//������ ���� �� ���� ������
				if(j + volume[i] <= M) dp[i][j+volume[i]] = true;	//������ ������ �� ���� ������
			}
		}
		for(int i=M; i>=0; i--) {	//��� ���
			if(dp[N][i]) {
				System.out.println(i);
				System.exit(0);
			}
		}
		System.out.println(-1);
	}
}
