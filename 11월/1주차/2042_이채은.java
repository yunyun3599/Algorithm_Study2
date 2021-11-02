import java.io.*;

public class Main{
    static int N, M, K;
    static long arr[], sum[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        K = Integer.parseInt(tmp[2]);
        arr = new long[N+1];
        sum = new long[N+1];
        for(int i=1; i<N+1; i++){
            arr[i] = Long.parseLong(br.readLine());
            sum[i] = sum[i-1] + arr[i];
        }
        for(int i=0; i<M+K; i++){
            tmp = br.readLine().split(" ");
            int b = Integer.parseInt(tmp[1]);
            long c = Long.parseLong(tmp[2]);
            switch(Integer.parseInt(tmp[0])){
                case 1:
                    change(b, c);
                    break;
                case 2:
                    System.out.println(sum[(int)c]-sum[b-1]);
                    break;
            }
        }
    }
    
    public static void change(int idx, long val){
        long pre = arr[idx];
        arr[idx] = val;
        for(int i=idx; i<=N; i++)
            sum[i] += val - pre;
    }
}
