import java.util.*;
import java.io.*;

public class Main{
    static int N, Q, size, sum, ice; //격자 크기, 단계 수, 실제 격자 크기, 얼음 합, 가장 큰 덩어리
    static int[][] map;
    static int[][] tmp; //로테이션을 위해 저장
    static boolean[][] visit;
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static class pair{
        int x, y;
        pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void bfs(int x, int y){
        Queue<pair> q = new LinkedList<pair>();
        q.add(new pair(x, y));
        visit[x][y] = true;
        int num = 1;
        while(!q.isEmpty()){
            pair p = q.poll();
            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx>=0 && nx<size && ny>=0 && ny<size && !visit[nx][ny] && map[nx][ny]>0){
                    visit[nx][ny] = true;
                    sum += map[nx][ny]; num++;
                    q.add(new pair(nx, ny));
                }
            }
        }
        if(num > 1 && ice < num) ice = num;
    } //bfs 탐색으로 덩어리 세기
    
    public static void ans(){
        visit = new boolean[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(map[i][j]>0 && !visit[i][j]){
                    sum += map[i][j];
                    bfs(i, j);
                }
            }
        }
    } //얼음 합 & 큰 덩아리가 차지하는 칸 개수 구하기
    
    public static void rotate(int x, int y, int s){
    	for(int i=0; i<s; i++)
    		for(int j=0; j<s; j++)
    			tmp[i][j] = map[x+s-1-j][y+i];
    	
    	for(int i=0; i<s; i++)
    		for(int j=0; j<s; j++)
    			map[x+i][y+j] = tmp[i][j];
    } //90도 회전
    
    public static void init(int[][] ice_num){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(map[i][j]>0){
                    for(int k=0; k<4; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(nx>=0 && nx<size && ny>=0 && ny<size)
                            ice_num[nx][ny]++;
                    }
                }
            }
        }
    } //주위 얼음 개수 세기
    
    public static void practice(int l){
        int div = (int)Math.pow(2, l);
        for(int i=0; i<size; i+=div)
            for(int j=0; j<size; j+=div)
                rotate(i, j, div);
        int ice_num[][] = new int[size][size];
        init(ice_num);
        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++)
                if(ice_num[i][j]<3 && map[i][j]>0) map[i][j]--;
    } //단계 하나
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        Q = Integer.parseInt(stk.nextToken());
        size = (int) Math.pow(2, N);
        map = new int[size][size];
        tmp = new int[size][size];
        for(int i=0; i<size; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++)
                map[i][j] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(br.readLine());
        for(int i=0; i<Q; i++) practice(Integer.parseInt(stk.nextToken()));
        ans();
        System.out.println(sum+"\n"+ice);
    }
}
