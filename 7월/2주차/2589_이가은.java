import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	
	static int[] dx = {0,0,-1,1}, dy = {1,-1,0,0};
	static char[][] map;
	static int r, c, max;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		
		for(int i = 0; i < r; i++) {
			String line = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] =='L') {
					max = Math.max(max, bfs(i,j));
				}
			}
		}
		System.out.println(max);
	}
	
	static int bfs(int x, int y) {
		int cnt = 0;
		Queue<Point> q = new LinkedList<>();
		int[][] len = new int[r][c];
		boolean[][] visit = new boolean[r][c];
		visit[x][y] = true;
		q.add(new Point(x,y));
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx >= 0 && nx < r && ny >= 0 && ny < c) { 
					if(!visit[nx][ny] && map[nx][ny] == 'L') {
						visit[nx][ny] = true;
						len[nx][ny] = len[cur.x][cur.y] + 1;
						cnt = len[nx][ny];
						q.add(new Point(nx,ny));
					}
				}
			}
		}
		return cnt;
	}

}
