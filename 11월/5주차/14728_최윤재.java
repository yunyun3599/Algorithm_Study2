import java.io.*;
import java.util.*;
public class _14728_최윤재_벼락치기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	//단원 개수
		int T = Integer.parseInt(st.nextToken());	//공부할 수 있는 총 시간 
		int time[] = new int[N+1];
		int score[] = new int[N+1];
		int dp[][] = new int[N+1][T+1];	//row번째 단원을 공부할 때 column시간이 주어졌다고 할 때 최대 점수 저장 
		
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			score[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<T+1; j++) {
				if(time[i] > j) //j시간으로는 이 단원을 공부할 수 없는 경우
					dp[i][j] = dp[i-1][j];
				else {	//이 단원 공부할 수 있는 시간이 나온 경우 
					dp[i][j] = Math.max(score[i] + dp[i-1][j-time[i]], dp[i-1][j]);	//지금 과목 공부하는 경우와 안하는 경우 중 더 큰 경우 선택 
				}
					
			}
		}
		System.out.println(dp[N][T]);
	}

}
