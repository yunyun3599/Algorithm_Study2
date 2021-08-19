package tmp;
import java.util.*;
import java.io.*;

public class _11559_������_PuyoPuyo {

	static char[][] map = new char[12][6];	//ó�� �� ����
	static int combo;	//�޺� ����
	static ArrayList<int[]> target;	//�� �޺����� ���� ��ġ ����
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<12; i++) {
			String input = br.readLine();
			for(int j=0; j<6; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		stage(0,0);	//0,0���� Ȯ���ϸ鼭 �Ͷ߸���
		System.out.println(combo);
	}
	public static void stage(int y, int x) {
		target = new ArrayList<>();	//�� �ܰ躰 ���� ��ġ
		boolean visited[][] = new boolean[12][6];	//�� �ܰ躰 �湮 ó��
		for(int i=0; i<12; i++) {	//�� ��ġ�� bfs����
			for(int j=0; j<6; j++) {
				if(!visited[i][j]) {	//���� �湮 ���Ѱ�� bfs����
					ArrayList<int[]> tmp = bfs(i,j,visited);	//���� bfs�� ��� �Ͷ߸� ��ǥ�� tmp�� ����
					for(int[] concat : tmp) {
						target.add(concat);	//�̹��� �Ͷ߸� ��ǥ���� target�� �����
					}
				}
			}
		}
		if(target.size()>=4) {	//target�� �Ͷ߸� ���� �ִ� ��� �Ͷ߸�
			explode();	//�Ͷ߸�
			combo++;	//�޺� ����
			stage(0,0);	//���� �ܰ� ����
		}
		return;
	}
	public static ArrayList<int[]> bfs(int y, int x, boolean[][] visited){
		if(map[y][x]!= '.') {	//��ĭ�� �ƴ� ��쿡 ���Ͽ� bfs ����
			Queue<int[]> q = new LinkedList<>();
			ArrayList<int[]> tmp = new ArrayList<>();
			q.add(new int[] {y,x});
			visited[y][x] = true;	//�湮ó��
			tmp.add(new int[] {y,x});	//�ش� ��ǥ tmp�� ����
			while(!q.isEmpty()) {
				int[] loc = q.poll();
				for(int k=0; k<4; k++) {	//�����¿�
					int ny = loc[0]+dy[k];
					int nx = loc[1]+dx[k];
					if(check(ny,nx)&& !visited[ny][nx] && map[loc[0]][loc[1]] == map[ny][nx]) {	//�پ��ִ� ���� queue�� tmp�� ��ǥ ����
						q.add(new int[] {ny,nx});
						tmp.add(new int[] {ny,nx});
						visited[ny][nx] = true;
					}
				}
			}
			if(tmp.size()>=4) return tmp;	//�پ��ִ� ĭ�� 4�� �̻��̸� ��ǥ ����� arraylist ����
		}
		return new ArrayList<int[]>();	//�پ��ִ� ĭ�� 4�� �̸��̸� �� arraylist ����
	}
	public static void explode() {	//�Ͷ߸���
		int[] column = new int[6];	//� column�� ��ġ�� ����� ��������
		for(int[] loc : target) {	//�� location���� ����.���� �ٲٱ�
			map[loc[0]][loc[1]]='.';
			column[loc[1]]++;
		}
		down(column);	//������ŭ ������
	}
	public static void down(int[] column) {
		for(int i=0; i<6; i++) {
			if(column[i]>0) {	//�ش� ���� ��� �� ���� �� ���� �� ����
				for(int j=10; j>=0; j--) {	//�ؿ������� ����
					if(map[j+1][i]=='.' && map[j][i]!='.') {	//����ĭ�� ��ĭ�� �ƴϰ� �� ĭ�� ��ĭ�� ��
						map[j+1][i] = map[j][i];	//��ĭ ����
						map[j][i] = '.';
						if(j!=10) j=j+2;	//���������Ƿ� ������ ĭ�� �ٽ� Ȯ���غ����ؼ� j+2
					}
				}
			}
		}
	}
	public static boolean check(int y, int x) {	//���� üũ
		if(0<=y && 0<=x && y<12 && x<6) return true;
		return false;
	}
}
