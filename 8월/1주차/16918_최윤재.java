package tmp;
import java.io.*;
import java.util.*;

public class _16918_������_������ {

	static int[][] map;			//��
	static int R;	//��
	static int C;	//��
	static int N;	//�ð�
	static int time;	//����ð�
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		if(N==1) {	//ó�� ���� �� �״�� ������ ���
			for(int i=0; i<R; i++) {
				String input = br.readLine();
				System.out.println(input);
			}
			System.exit(0);
		}
		for(int i=0; i<R; i++) {	//map�� input���� �� ĭ�� 0���� ��ź �ִ� ĭ�� 1�� ǥ��
			String input = br.readLine();
			for(int j=0; j<C; j++) {
				if(input.charAt(j)=='.') map[i][j] = 0;
				else map[i][j] = 1;
			}
		}
		
		time=0;	//�ð�
		while(++time!=N) {	//�ð��� �÷����鼭 �� �� ����, �� �ϴ� ���� 4�����̹Ƿ�(1,2�� ��ź ���� ��ġ, 1,2�� ��ź ���� ����) �ð��� 4�� ���� �������� �̿��ؼ� ���� �з�
			if(time%4==1) {		//2�� ��ź�� ä��� ���
				fill(2);	//2�� ä��
			}
			else if(time%4==2) {	//1�� ��ź�� ������ ���
				for(int i=0; i<R; i++) {	//dfs
					for(int j=0; j<C; j++) {
						if(map[i][j]==1) {
							explode(i, j, 1);
						}
					}
				}				
			}
			else if(time%4==3) {	//1�� ��ź�� ä��� ���
				fill(1);
			}
			else {		//2�� ��ź�� ������ ���
				for(int i=0; i<R; i++) {	//dfs
					for(int j=0; j<C; j++) {
						if(map[i][j]==2) {
							explode(i, j, 2);
						}
					}
				}	
			}
		}
		StringBuilder result = new StringBuilder();	//��� append
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]!=0) result.append('O');	//��ź ������ O�� ���
				else result.append('.');
			}
			result.append("\n");
		}
		System.out.println(result);
	}
	public static void fill(int num) {	//�� ĭ�� num���� ä��
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]==0) {
					map[i][j] = num;
				}
			}
		}
	}
	public static void explode(int y, int x, int num) {	//num���� ���� ������ ��ź�� dfs�� �̿��� ����
		map[y][x] = 0;	//����
		for(int k=0; k<4; k++) {	//�����¿�
			int ny = y+dy[k];
			int nx = x+dx[k];
			if(check(ny, nx)) {	//����üũ
				if(map[ny][nx] != num) map[ny][nx]=0;	//�����ۿ� ���� ���� �׳� ����
				else {
					explode(ny, nx, num);	//�����ۿ� �ִ� ���� dfs ��������� ������
				}
			}
		}
	}
	public static boolean check(int y, int x) {
		if(y>=0 && x>=0 && y<R && x<C) return true;
		return false;
	}
}
