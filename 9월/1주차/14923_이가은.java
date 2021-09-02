import java.io.*;
import java.util.*;

public class _14923_미로탈출 {

	static int n, m, sx, sy, ex, ey;;
	static int map[][];
	static int[] dx = {0,0,-1,1}, dy= {-1,1,0,0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken())-1; sy = Integer.parseInt(st.nextToken())-1;
		
		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken())-1; ey = Integer.parseInt(st.nextToken())-1;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
	}
	static void bfs() {
		boolean[][][] visit = new boolean[n][m][2]; // [row][col][남은지팡이횟수] 
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {sx,sy,1,0}); //{sx,sy,남은지팡이횟수,거리}
		visit[sx][sy][1] = true;
		int ans = -1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0], y = cur[1], cnt = cur[2], dist = cur[3];
			if(x == ex && y == ey) { //도착함. break
				ans = dist; 
				break;
			}
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if(cnt > 0 && !visit[nx][ny][cnt-1] && map[nx][ny] == 1) { //벽이고, 벽 없앨 수 있는 경우
					visit[nx][ny][cnt-1] = true;
					q.add(new int[] {nx,ny,cnt-1,dist+1});
				}
				if(!visit[nx][ny][cnt] && map[nx][ny] == 0) { //벽이 아니고, 아직 방문하지 않은 경우
					visit[nx][ny][cnt] = true;
					q.add(new int[] {nx,ny,cnt,dist+1});
				}
			}
		}
		System.out.println(ans);
	} 
}
