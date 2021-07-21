import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int[] dx = {0,0,-1,1}, dy = {-1,1,0,0};
	static int R,C,top,bottom;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken()); 
		int T = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		map = new int[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1 && top == 0) top = i;
				else if(map[i][j] == -1 && top != 0) bottom = i; //공기청정기 위치 저장 
			}
		}
		for(int i=0; i<T; i++) {
			diffuse(); //미세먼지 확산
			clear(); //공기청정기 작동 
		}
		for(int i=0; i<R; i++) 
			for(int j=0; j<C; j++) 
				ans += map[i][j];
		
		System.out.println(ans+2); //공기청정기 2개 값(-1) 더하기 
	}
	
	static void diffuse() {
		int[][] tmp = new int[R][C];
		for(int x=0; x<R; x++) {
			for(int y=0; y<C; y++) {
				int cnt = 0;
				for(int i=0; i<4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != -1) {
						tmp[nx][ny] += map[x][y]/5;
						cnt++; //확산된 방향 개수 세기
					}
				}
				tmp[x][y] += map[x][y] - (map[x][y]/5)*cnt;
			}
		}
		map = tmp;
	}

	static void clear() {
		//위쪽 
		for(int i=top-2; i>=0; i--) map[i+1][0] = map[i][0];
		for(int i=1; i<C; i++) map[0][i-1] = map[0][i];
		for(int i=1; i<=top; i++) map[i-1][C-1] = map[i][C-1];
		for(int i=C-2; i>=1; i--) map[top][i+1] = map[top][i];
		map[top][1] = 0;
		//아래쪽 
		for(int i=bottom+2; i<R; i++) map[i-1][0] = map[i][0];
		for(int i=1; i<C; i++) map[R-1][i-1] = map[R-1][i];
		for(int i=R-2; i>=bottom; i--) map[i+1][C-1] = map[i][C-1];
		for(int i=C-2; i>=1; i--) map[bottom][i+1]= map[bottom][i];
		map[bottom][1] = 0;
	}

}
