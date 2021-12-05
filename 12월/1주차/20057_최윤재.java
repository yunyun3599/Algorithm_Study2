package tmp;
import java.io.*;
import java.util.*;
public class _20057_������_�������������̵� {

	static int dy[] = {0, 1, 0, -1};	//�����¿� idx �̵�
	static int dx[] = {-1, 0, 1, 0};
	static double percent[] = {1, 1, 7, 2, 7, 2, 10, 10, 5};	//�ۼ�Ʈ
	static int sandx[][] = {	//�𷡰� ������ ��ǥ
			{ 1, 1, 0, 0, 0, 0, -1, -1, -2},	//��
			{-1, 1, -1, -2, 1, 2, -1, 1, 0},	//��
			{-1, -1, 0, 0, 0, 0, 1, 1, 2},	//��
			{-1, 1, -1, -2, 1, 2, -1, 1, 0}	//��
			};
	static int sandy[][] = {
			{-1, 1, -1, -2, 1, 2, -1, 1, 0}, //��
			{-1, -1, 0, 0, 0, 0, 1, 1, 2},	//��
			{-1, 1, -1, -2, 1, 2, -1, 1, 0}, //��
			{1, 1, 0, 0, 0, 0, -1, -1, -2}	//��
			};
	
	static int N;
	static int[][] map;
	static boolean visited[][];
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {	//�Է�
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int mid = N/2;	//��� ��ǥ
		visited[mid][mid] = true;	//�� ��� �湮ó��
		tornado(mid, mid-1, 0);	//���
		System.out.println(result);	//��� ���ϱ�
	}
	
	public static void tornado(int y, int x, int dir) {
		visited[y][x] = true;	//�湮ó��
		int affected_y[] = sandy[dir];	//�ش� �������� �� �� ����޴� ĭ�� x��ǥ �̵�
		int affected_x[] = sandx[dir];	//y��ǥ �̵�
		int tmp = 0;
		for(int i=0; i<9; i++) {	//����޴� �� ��ĭ�� Ȯ��
			int ny = y+affected_y[i];
			int nx = x+affected_x[i];
			if(!check(ny, nx)) {	//�𷡰� �ٱ����� ������ ���
				result += map[y][x] * percent[i] / 100;
			} else {	//�𷡰� ĭ ������ ������ ���
				map[ny][nx] += map[y][x] * percent[i] / 100;
			}
			tmp += map[y][x] * percent[i] / 100;	//a�� �ƴ� ���� ��
		}
		if(check(y+dy[dir], x+dx[dir])) {	//a���� map ���� ��
			map[y+dy[dir]][x+dx[dir]] += map[y][x] - tmp;
		} else {	//a���� map ���� �ƴ� ��
			result += map[y][x] - tmp;
		}
		map[y][x] = 0;
		int ndir = (dir+1)%4;	//���� ����
		if(y == 0 && x == 0) return;	//�� �� ���
		if(visited[y+dy[ndir]][x+dx[ndir]]) tornado(y+dy[dir], x+dx[dir], dir);	//���� ���� �������� ������ �� ���� �̹� �湮�� ���̸� ���� �������� ��ĭ �� �̵�
		else tornado(y+dy[ndir], x+dx[ndir], ndir);	//���� �������� �� �� ������ ����
	}
	
	public static boolean check(int y, int x) {
		if(y>=0 && x>=0 && y<N && x<N) return true;
		return false;
	}

}
