import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder("");
		int n = sc.nextInt();
		
		int[] dp = new int[n+1];
		int[] bf = new int[n+1];
		
		dp[1] = 0;
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + 1;
			bf[i] = i-1;
			if(i%3 == 0 && dp[i] > dp[i/3]+1) {
				dp[i] = dp[i/3]+1;
				bf[i] = i/3;
			}
			if(i%2 == 0 && dp[i] > dp[i/2]+1) {
				dp[i] = dp[i/2]+1;
				bf[i] = i/2;
			}
		}
		sb.append(dp[n]+"\n"); //연산을 하는 횟수의 최솟값
		
		while(n > 0) {
			sb.append(n+" ");  //1로 만드는 방법에 포함되어 있는 수
			n = bf[n];
		}
		System.out.println(sb.toString());

	}
}
