import java.util.*;

public class Main{
    static int N, s, ans = Integer.MAX_VALUE;
    static int[][] matrix;
    static boolean[] visit;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        matrix = new int[N+1][N+1];
        visit = new boolean[N+1];
        for(int i=1; i<=N; i++)
            for(int j=1; j<=N; j++)
                matrix[i][j] = sc.nextInt();
        
        for(int i=1; i<=N; i++) {
        	s = i;
        	visit[i] = true;
            travel(i, 1, 0);
            visit[i] = false;
        }
        
        System.out.println(ans);
        sc.close();
    }
    
    public static void travel(int pre, int cnt, int cost){
        if(cnt==N){
        	if(matrix[pre][s]==0) return;
            ans = Math.min(cost+matrix[pre][s], ans); return;
        }
        
        for(int i=1; i<=N; i++){
            if(!visit[i] && matrix[pre][i]!=0) {
                visit[i] = true;
                travel(i, cnt+1, cost+matrix[pre][i]);
                visit[i] = false;
            }
        }
    }
}
