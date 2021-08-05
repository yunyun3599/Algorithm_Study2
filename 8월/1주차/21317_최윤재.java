package tmp;
import java.io.*;
import java.util.*;
public class _21317_ÃÖÀ±Àç_Â¡°Ë´Ù¸®°Ç³Ê±â {

	static int N;
	static int[] small;
	static int[] big;
	static int[] dp;
	static int K;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		small = new int[N-1];
		big = new int[N-1];
		dp = new int[N];
		if(N==1) {
			System.out.println(0);
			System.exit(0);
		}
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			small[i] = Integer.parseInt(st.nextToken());
			big[i] = Integer.parseInt(st.nextToken());
		}
		K = Integer.parseInt(br.readLine());
		dp[0] = 0;
		dp[1]=small[0];
		for(int i=2; i<N; i++) {
			dp[i] = Math.min(dp[i-2]+big[i-2], dp[i-1]+small[i-1]);					
		}
		min = dp[N-1];
		for(int i=3; i<N; i++) {
			dp[0] = 0;
			dp[1] = small[0];
			for(int j=2; j<N; j++) {
				if(j!=i && j!=i+1) {
					dp[i] = Math.min(dp[i-2]+big[i-2], dp[i-1]+small[i-1]);
				}
				else if(j==i) {
					dp[j] = K+dp[j-3];
				}
				else {
					dp[j] = dp[j-1]+small[j-1];
				}
			}
			min = Math.min(min, dp[N-1]);
		}
		System.out.println(min);
	}

}
