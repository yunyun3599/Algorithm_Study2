import java.io.*;
import java.util.*;
import java.awt.Point;

public class _17141_연구소2 {
	
	static int[][] map;
	static boolean[] chosen;
	static ArrayList<Point> virus = new ArrayList<>(); //바이러스가 놓일 수 있는 위치 
	static Queue<int[]> q = new LinkedList<>();
	static int N,M, wallCnt, min = Integer.MAX_VALUE;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] l = br.readLine().split(" ");
		N = Integer.parseInt(l[0]);
		M = Integer.parseInt(l[1]);
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			l = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(l[j]) * -1; //0(길), -1(벽), -2(바이러스 놓을 수 있는 위치) 
				if(map[i][j] == -2) virus.add(new Point(i,j));
				if(map[i][j] == -1) wallCnt++;
			}
		}
		chosen = new boolean[virus.size()];
		go(0, virus.size(), 0);
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	static void go(int idx, int cnt, int level) {
		if(level == M) {
			int[][] newmap = new int[N][N]; 
			for(int i=0; i<N; i++) newmap[i] = map[i].clone();
      
			//원래의 Map에서 -2 중 진짜 바이러스의 놓은 곳 제외 나머지는 0으로 clear, 바이러스위치는 bfs queue에 삽입
			for(int i=0; i<cnt; i++) {
				int x = virus.get(i).x, y = virus.get(i).y;
				if(chosen[i]) {
					newmap[x][y] = 1;
					q.add(new int[]{x,y}); 
				}
				else newmap[x][y] = 0; 
			}
			bfs(newmap, N*N - wallCnt - M); //복사한 map과, 0의 개수를 전달
			return;
		}
		for(int i=idx; i<cnt; i++) {
			chosen[i] = true;
			go(i+1, cnt, level+1);
			chosen[i] = false;
		}
	}
	static void bfs(int[][] m, int zeros) { //0(길), -1(벽), 1(바이러스) 
		int cnt = zeros, time = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				if(m[nx][ny] != 0) continue; //길이 아니면 
				
				m[nx][ny] = m[cur[0]][cur[1]] + 1;
				time = Math.max(time, m[nx][ny]);
				cnt--;
				q.add(new int[] {nx,ny});
			}
		}
    
    //map 상의 남은 0의 수가 없을 경우(전체에 퍼트릴 수 있는)에만 ming 갱신
		if(cnt == 0) { 
			if(time == 0) min = 0; //edge case. 바이러스 놓자마자 0인경우 
			else min = Math.min(min, time-1); 
		}
	}
}
