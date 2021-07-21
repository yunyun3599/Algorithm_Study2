import java.io.*;
import java.util.*;

public class Main {
	
	static int w,h;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {0,0,1,-1,-1,1,-1,1}; //상하좌우, 대각선
	static int[] dy = {-1,1,0,0,-1,1,1,-1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken()); h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0)break;
			
			map = new int[h][w];
			visit = new boolean[h][w];
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0; //섬의 개수 세기 
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(!visit[i][j] && map[i][j] == 1) {
						cnt++;
						dfs(i,j);
					}
				}
			}
			bw.append(cnt+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	static void dfs(int x, int y) {
		visit[x][y] = true;
		for(int i=0; i<8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < h && ny >=0 && ny < w && !visit[nx][ny]) {
				if(map[nx][ny] == 1) dfs(nx,ny);
			}
		}
	}

}
