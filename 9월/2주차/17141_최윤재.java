package tmp;
import java.util.*;
import java.io.*;
import java.awt.Point;

public class _17141_������_������2 {
	
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<int[]> virusLoc = new ArrayList<>();	//���̷����� �� �� �ִ� ��ġ ����
	static int result = Integer.MAX_VALUE;	//���� ���
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) map[i][j] = -1;
				else if(map[i][j] == 2) {
					virusLoc.add(new int[] {i, j});
					map[i][j] = 0;
				}
			}
		}
		////////////////////////////////////////////////////�Է�
		//���̷��� ��ġ
		for(int i=0; i<=virusLoc.size() - M ; i++) {
			chooseLoc(i,0);	//��ġ �����ϴ� �Լ�
		}
		if(result == Integer.MAX_VALUE) result = -1;	//��� �۶߸��� ���� ���� -1
		System.out.println(result);
	}
	public static void chooseLoc(int idx, int selected) {	//virusLoc�� ���° �ε������� Ȯ�������� idx��, � �ڸ��� ���õǾ������� selected�� �Ѱ���
		if(selected == M) {	//������ �� �ִ� ������ �� ���� �� ���̷����� �۶߸��� spread�Լ� ȣ��
			spread();
		}
		for(int i=idx; i<virusLoc.size(); i++) {	//���̷��� �ʱ� ��ġ ����
			int[] loc = virusLoc.get(idx);
			map[loc[0]][loc[1]] = 1;	//1�� ��� ���̷����� ó���� �ִ� ��
			chooseLoc(i+1, selected+1);
			map[loc[0]][loc[1]] = 0;
		}
	}
	public static void spread() {
		Queue<Point> queue = new LinkedList<>();
		visited = new boolean[N][N];	//�湮ó��
		int time = 0;
		int queueSize = 0;	//�� time�� ������ ���̷����� ���� �ڸ����� ����
		int cnt = N*N;	//�� ������ ����
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {	//�ʱ⿡ ���̷����� �ִ� ��ġ
					queue.add(new Point(j, i));
					visited[i][j] = true;
					cnt--;	//�� �湮�� �������� ����
				}
				else if(map[i][j] == -1) cnt--;	//���� ��쵵 �� �湮�� �������� ����
			}
		}
		while(!queue.isEmpty()) {
			queueSize = queue.size();
			for(int i=0; i<queueSize; i++) {
				Point prev = queue.poll();
				for(int k=0; k<4; k++) {	//�����¿�
					int ny = prev.y + dy[k];
					int nx = prev.x + dx[k];
					if(check(ny, nx)) {	//�湮 ���߰�, ���� ���� ������, ���� �ƴ� �� Ȯ��
						queue.add(new Point(nx, ny));	//queue�� �� ��ġ �߰�
						visited[ny][nx] = true;	//�湮ó��
						cnt--;	//�湮�����Ƿ� ��  �۶߷����ϴ� ������ ������ cnt �ٿ���
					}
				}
			}
			time++;	//�� �Ҹ��� �ð� 1�� ����. �� �۶߸� ���� ���� ���� �� �� �����ϰ� �ǹǷ� ���Ŀ� 1 ����� ��
		}
		if(cnt!= 0) return;	//��� �ڸ��� �۶߸��� ���� ���
		result = Math.min(result, time-1);	//��� �ڸ��� �� �۶߸� ��쿡�� �ּҰ����� result ������Ʈ
	}

	public static boolean check(int y, int x) {
		if(0<=y && 0<=x && y<N && x<N && map[y][x]!=-1 && !visited[y][x]) return true;
		return false;
	}
}
