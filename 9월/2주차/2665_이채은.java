import java.util.*;

public class Main{
    static int ans;
    static int maze[][];
    static int value[][];
    static boolean visit[][];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class elem{
        int x, y, cnt;
        elem(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ans = n*2;
        maze = new int[n][n];
        value = new int[n][n];
        visit = new boolean[n][n];
        for(int i=0; i<n; i++){
            char[] tmp = sc.next().toCharArray();
            for(int j=0; j<n; j++)
                maze[i][j] = tmp[j]-'0';
        }
        
        Queue<elem> q = new LinkedList<>();
        q.add(new elem(0, 0, 0));
        while(!q.isEmpty()){
            elem e = q.poll();
            for(int i=0; i<4; i++){
                int nx = e.x+dx[i];
                int ny = e.y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n){
                	int num = (maze[nx][ny]==1)? e.cnt:e.cnt+1;
                	if(visit[nx][ny]) {
                		if(value[nx][ny]>num) {
                			value[nx][ny] = num;
                			q.add(new elem(nx, ny, num));
                		}
                	}
                	else {
                		visit[nx][ny] = true;
                		value[nx][ny] = num;
                		q.add(new elem(nx, ny, num));
                	}
                }
            }
        }
        
        System.out.println(value[n-1][n-1]);
        sc.close();
    }
}
