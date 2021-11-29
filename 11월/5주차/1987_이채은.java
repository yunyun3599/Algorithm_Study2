import java.util.*;

public class Main{
    static int R, C, ans;
    static char board[][];
    static boolean visit[] = new boolean[26];
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        board = new char[R][C];
        for(int i=0; i<R; i++)
            board[i] = sc.next().toCharArray();
        
        visit[board[0][0]-'A'] = true;
        backtracking(0, 0, 1);
        System.out.println(ans);
        sc.close();
    }
    
    public static void backtracking(int y, int x, int cnt){
        boolean flag = false;
        for(int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny>=0 && ny<R && nx>=0 && nx<C && !visit[board[ny][nx]-'A']){
                flag = true;
                visit[board[ny][nx]-'A'] = true;
                backtracking(ny, nx, cnt+1);
                visit[board[ny][nx]-'A'] = false;
            }
        }
        
        if(!flag) ans = Math.max(ans, cnt);
    }
}
