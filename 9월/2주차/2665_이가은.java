import java.io.*;
import java.util.*;
import java.awt.Point;

public class _2665_미로만들기 {

	static int n;
	static int[] dx = {0,0,-1,1}, dy = {1,-1,0,0};
	static int[][] map, visit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visit = new int[n][n];

		for(int i=0; i<n; i++) {
			Arrays.fill(visit[i], Integer.MAX_VALUE);
		}
		
		for(int i=0; i<n; i++) {
			String l = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = l.charAt(j)-'0';
			}
		}
		bfs();
		System.out.println(visit[n-1][n-1]);
	}
	
	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		
		visit[0][0] = 0;
		q.add(new Point(0,0));
		
		while(!q.isEmpty()) { 
			Point p = q.poll();
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
				if(visit[nx][ny] <= visit[p.x][p.y]) continue; 
				
				if(map[nx][ny]==1) { //이동가능한
					q.add(new Point(nx,ny));
					visit[nx][ny] = visit[p.x][p.y];
				}
				if(map[nx][ny]==0) { //벽인 경우
					q.add(new Point(nx,ny));
					visit[nx][ny] = visit[p.x][p.y] + 1;
				}
			}
		}
		
	}
	
}
