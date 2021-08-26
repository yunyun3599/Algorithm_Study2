package tmp;
import java.io.*;
import java.util.*;
public class _3005_������_ũ�ν����������Ĵٺ��� {

	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visited;
	static String result = "zzzzzzzzzzzzzzzzzzzz";	//������ ���� �� ���ڿ�
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			String tmp = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}////////////////////////////////////////�Է�
		//����
		visited = new boolean[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]!='#' && !visited[i][j]) {	//���ڰ� �ְ� ���� Ȯ�� ���� ���
					StringBuffer tmp = new StringBuffer();	//��������� �ܾ�
					tmp.append(map[i][j]);	//ù ���� append
					dfs(i, j, 0, 1, tmp);	//dfs�� ������ Ž�� (0�� dy�� 1�� dx)
				}
			}
		}
		//����
		visited = new boolean[R][C];	//�湮�迭 �ʱ�ȭ
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]!='#' && !visited[i][j]) {
					StringBuffer tmp = new StringBuffer();
					tmp.append(map[i][j]);
					dfs(i, j, 1, 0, tmp);	//dfs�� �Ʒ��� Ž�� (1�� dy�� 0�� dx)
				}
			}
		}
		System.out.println(result);
	}
	static void dfs(int y, int x, int dy, int dx, StringBuffer tmp) {	//���� ��ġ�� ������ ����, ��������� ���ڿ��� ����
		if(check(y+dy, x+dx)) {	//���� �°� ���� �ִ� ���
			visited[y+dy][x+dx] = true;
			tmp.append(map[y+dy][x+dx]);
			dfs(y+dy, x+dx, dy, dx, tmp);	//���� ���� ���� �ڸ��� Ȯ��
		}
		else {	//���� ��찡 �ƴϸ� �ܾ��� ��
			String tmpresult = tmp.toString();	//�� ���� string���� �ٲ�
			if(tmpresult.length()<2) return;	//���ڿ� ���̰� 1�̸� Ȯ�� ����
			result = result.compareTo(tmpresult) < 0 ? result : tmpresult;	//�� ���������� ���� ���� ����
		}
	}
	
	static boolean check(int y, int x) {	//���� �� ���� ���� Ȯ��
		if(y>=0 && x>=0 && y<R && x<C && map[y][x]!='#') return true;
		return false;
	}
}
