package tmp;
import java.util.*;
import java.io.*;

class Location{		//queue�� ���� ����
	int y;
	int x;
	int move;
	Location(int y, int x, int move){
		this.y = y;
		this.x = x;
		this.move = move;
	}
}

public class _2589_������_������ {
	
	static int width;
	static int height;
	static char map[][];
	static boolean visited[][];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int dist;	//���� ���(���� �� �Ÿ�)
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		map = new char[height][width];
		
		for(int i=0; i<height; i++) {	//input ó��
			String input = br.readLine();
			for(int j=0; j<width; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		for(int i=0; i<height; i++) {	//�� L���� ���������� �ؼ� bfs ��� �����غ�
			for(int j=0; j<width; j++) {
				if(map[i][j]=='L') {
					visited = new boolean[height][width];	//�湮 ó���� �迭
					Queue<Location> q = new LinkedList<>();	//queue
					q.add(new Location(i, j, 0));	//������ add
					visited[i][j] = true;	//�湮 ó��
					int tmp_dist = 0;	//�̹� ��ġ�� �������� �� ���� �� �Ÿ�
					while(!q.isEmpty()) {
						Location loc = q.poll();
						tmp_dist = loc.move;	//���� �� �Ÿ� ������Ʈ
						for(int k=0; k<4; k++) {	//�����¿� Ž��
							int y = loc.y + dy[k];
							int x = loc.x + dx[k];
							if(check(y,x)) {	//���� �� �� �ִ� ��쿡 ���ؼ� queue�� add
								q.add(new Location(y,x, loc.move+1));
								visited[y][x] = true;	//�湮ó��
							}
						}
					}
					dist = Math.max(tmp_dist, dist);	//���ݱ��� ����Ÿ��� �̹� �õ��� ����Ÿ� �� �� �� ���� ����
				}
			}
		}
		System.out.println(dist);	//��� ���
	}
	public static boolean check(int y, int x) {
		if(0<=y && 0<=x && y<height && x<width && !visited[y][x] && map[y][x]=='L') return true;
		return false;
	}
}
