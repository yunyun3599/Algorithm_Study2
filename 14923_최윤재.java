package tmp;
import java.io.*;
import java.util.*;

class Loc {		//Queue�� ���� ��
	int y;
	int x;
	int broken;	//�� �μ� �� �ִ���
	int D;	//�Ÿ�
	Loc(int y, int x, int broken, int D){
		this.y = y;
		this.x = x;
		this.broken = broken;
		this.D = D;
	}
}

public class _14923_������_�̷�Ż�� {

	static int N, M, Hx, Hy, Ex, Ey;
	static int[][] map;
	static int[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		Hy = Integer.parseInt(st.nextToken())-1;
		Hx = Integer.parseInt(st.nextToken())-1;
		st = new StringTokenizer(br.readLine(), " ");
		Ey = Integer.parseInt(st.nextToken())-1;
		Ex = Integer.parseInt(st.nextToken())-1;
		map = new int[N][M];
		visited = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}////////////////////////////////////////////////�Է�
		Queue<Loc> queue = new LinkedList<>();	//bfs
		queue.add(new Loc(Hy, Hx, 0, 0));	//ó�� ��ġ �ֱ�
		visited[Hy][Hx] = 1;	//visited�� 0�̸� ���� �Ȱ� ��, 1�̸� �� �Ⱥμ��� �� �� 2�� �� �μ� �Ŀ� �� ��
		while(!queue.isEmpty()) {
			Loc cur = queue.poll();
			if(cur.x==Ex && cur.y == Ey) {	//������ �������� ��
				System.out.println(cur.D);
				System.exit(0);
			}
			for(int k=0; k<4; k++) {
				int ny = cur.y+dy[k];
				int nx = cur.x+dx[k];
				if(check(ny, nx)) {		//map�� �ִ� ��ǥ�̰� visited�� 1�� �ƴ� ���� Ȯ���غ�(visited�� 1�̸� �ش� ��ΰ� �� �ּҰ��̹Ƿ� ���� �� �ʿ� X)
					if(cur.broken==0 && map[ny][nx]==1) {	//Ȯ���غ� ���� ���� ��
						if(visited[ny][nx]==0) queue.add(new Loc(ny, nx, 1, cur.D+1));
						visited[ny][nx] = 2;	//�� �μ��� �̵������Ƿ� visited���� 2
					}
					if(map[ny][nx] == 0) {	//���� �ƴ� ���
						if(cur.broken==1 && visited[ny][nx]==0) {	//������ ���� �μ� ���� ���� ��
							if(visited[ny][nx]==0) queue.add(new Loc(ny, nx, 1, cur.D+1));
							visited[ny][nx] = 2;
						}
						else if(cur.broken==0) {	//������ ���� �μ� ���� ���� ��
							queue.add(new Loc(ny, nx, 0, cur.D+1));
							visited[ny][nx]  = 1;
						}
					}
				}
			}
		}
		System.out.println(-1);	//�������� ���ϴ� ���
	}
	public static boolean check(int y, int x) {
		if (y>=0 && x>=0 && y<N && x<M && visited[y][x]!=1) return true;
		return false;
	}

}
