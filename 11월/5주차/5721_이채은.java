import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
        	StringTokenizer stk = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(stk.nextToken());
            int N = Integer.parseInt(stk.nextToken());
            if(M == 0 && N == 0) break;
            int[] candy = new int[M];
            int[] tmp = new int[N];
            for(int i=0; i<M; i++){
                stk = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++)
                    tmp[j] = Integer.parseInt(stk.nextToken());
                candy[i] = calc(tmp, N);
            }
            System.out.println(calc(candy, M));
        }
    }
    
    public static int calc(int[] arr, int size){
        if(size == 1) return arr[0];
        int dp[] = new int[size];
        dp[0] = arr[0]; dp[1] = Math.max(arr[0], arr[1]);
        for(int i=2; i<size; i++){
            dp[i] = Math.max(dp[i-2]+arr[i], dp[i-1]);
        }
        return dp[size-1];
    }
}
