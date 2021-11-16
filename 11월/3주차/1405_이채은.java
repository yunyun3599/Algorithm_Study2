import java.util.*;

public class Main{
    static int N;
    static int dy[] = {0, 0, 1, -1};
    static int dx[] = {1, -1, 0, 0};
    static double ans;
    static double dir[] = new double[4];
    static boolean visit[][] = new boolean[29][29];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i=0; i<4; i++)
            dir[i] = sc.nextDouble()/100;
        visit[14][14] = true;
        dfs(14, 14, 0, 1);
        System.out.printf("%.15f", ans);
        sc.close();
    }
    
    public static void dfs(int y, int x, int cnt, double val){
        if(cnt == N){
            ans += val; return;
        }
        for(int i=0; i<4; i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(!visit[ny][nx]){
                visit[ny][nx] = true;
                dfs(ny, nx, cnt+1, val*dir[i]);
                visit[ny][nx] = false;
            }
        }
    }
}
