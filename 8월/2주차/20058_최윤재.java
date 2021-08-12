package tmp;
import java.io.*;
import java.util.*;

public class _20058_������_������������̾�� {
	
	static int N;
	static int Q;
	static int width;
	static int map[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	static int max = 0;		//���� ���� ����
	static int sum = 0;		//���� ��
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		width = (int)Math.pow(2, N);
		map = new int[width][width];
		visited = new boolean[width][width];
		for(int i=0; i<width; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/////////////////////////////////////////////////////�Է�
		st = new StringTokenizer(br.readLine(), " ");
		while(Q-->0) {	//�ݺ�
			int stage = Integer.parseInt(st.nextToken());	//��ܰ�����
			map = rotate(stage);	//�� 90�� ������
			melt();	//���� ���̱�
		}
		
		Queue<int[]> queue = new LinkedList<>();	//���� �ʿ��� ��� Ȯ�� bfs �̿�
		for(int i=0; i<width; i++) {
			for(int j=0; j<width; j++) {
				int area =0;
				if(!visited[i][j] && map[i][j]>0) {
					queue.add(new int[] {i,j});		//bfs�� ���� ���ϱ�
					visited[i][j] = true;	//�湮ó��
					while(!queue.isEmpty()) {
						int[] loc = queue.poll();
						area++;			//���� 1 ����
						sum += map[loc[0]][loc[1]];	//sum�� ���� �� ���ϱ�
						for(int k=0; k<4; k++) {	//���� ĭ Ȯ��
							int ny = loc[0]+dy[k];
							int nx = loc[1]+dx[k];
							if(check(ny, nx) && !visited[ny][nx]) {
								queue.add(new int[] {ny, nx});
								visited[ny][nx]=true;
							}
						}
					}
				}
				max = Math.max(max, area);
			}
		}
		System.out.println(sum);
		System.out.println(max);
	}
	
	public static int[][] rotate(int stage) {	//90�� ������ �Լ�
		int rotatedMap[][] = new int[width][width];	//���ư� map
		int small = (int)Math.pow(2, stage);	//�¿� ��ĭ�������� ������
		for(int a=0; a<width/small; a++) {	//ĭ �������� y��ǥ
			int start_y = small*a;	//���� y��ǥ
			for(int b=0; b<width/small; b++) {	//ĭ �������� x��ǥ
				int start_x = small*b;	//����  x��ǥ
				for(int i=0; i<small; i++) {
					for(int j=0; j<small; j++) {
						rotatedMap[start_y+j][start_x+small-i-1] = map[start_y+i][start_x+j];	//���ư� map�� �� ����
					}
				}
			}
		}
		return rotatedMap;	//���ư� �� ����
	}
	public static void melt() {	//���� ���̱�
		ArrayList<int[]> loc = new ArrayList<>();	//�ٷ� ���̸� ���� ���� �����¿� ���� ĭ ���ÿ� �ݿ��Ǳ� ������ ���߿� �ѹ��� ���̱� ���� arraylist�� ��ǥ ����
		for(int i=0; i<width; i++) {
			for(int j=0; j<width; j++) {
				if(map[i][j]==0) continue;
				int count = 0;
				for(int k=0; k<4; k++) {	//�����¿� Ȯ��
					int nx = j + dx[k];
					int ny = i + dy[k];
					if(check(ny, nx)) count++;	//���� �ִ� ĭ�̸� count++
				}
				if(count<3) loc.add(new int[] {i,j});	//�ֺ��� ���� �ִ� ĭ�� 3�� �̸��̸� arraylist�� ��ǥ ����
			}
		}
		for(int[] location : loc) {	//arraylist�� ����� ��ǥ�� �ش��ϴ� map�� �ϳ��� ����
			int y = location[0];
			int x = location[1];
			map[y][x]--;
		}
	}

	public static boolean check(int y, int x) {
		if(0<=y && 0<=x && y<width && x<width && map[y][x]>0) return true;
		return false;
	}
}
