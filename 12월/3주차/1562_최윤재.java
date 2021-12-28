import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long dp[][][] = new long[N+1][10][1024];	//dp[i][j][k]이면 i번째 자리에 j가 올 때 사용한 0~9 숫자에 대한 비트마스킹이 k
		for(int i=1; i<=9; i++) {
			dp[1][i][1<<i] = 1;	//한자리 수에 대한 경우는 1~9를 쓰는 경우 1개씩
		}
		
		for(int i=2; i<=N; i++) {
			for(int j=0; j<=9; j++) {
				for(int visit = 0; visit < 1024; visit++) {
					int newVisit = visit | (1<<j);
					if(j==0) dp[i][j][newVisit] += dp[i-1][j+1][visit];
					else if(j==9) dp[i][j][newVisit] += dp[i-1][j-1][visit];
					else dp[i][j][newVisit] += dp[i-1][j-1][visit] + dp[i-1][j+1][visit];
					dp[i][j][newVisit] %= 1000000000;
				}
			}
		}
		long result = 0;
		for(int i=0; i<=9; i++) {
			result += dp[N][i][1023];
		}
		System.out.println(result % 1000000000);
	}

}
