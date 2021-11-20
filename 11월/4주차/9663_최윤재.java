package tmp;
import java.util.*;
public class _9663_������_NQueen {

	static int N;
	static int result;
	static boolean map[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new boolean[N][N];
		
		dfs(0);		//dfs�� �ڸ� ä��
		System.out.println(result);
	}
	
	static void dfs(int row) {
		if(row == N) {	//��� �ڸ��� �� ä���� ���
			result++;
			return;
		}
		for(int i=0; i<N; i++) {	//�� ���� ���鼭 ä������
			if(promising(row, i) ) {	//ä�� �� �ִ� �ڸ����� Ȯ��
				map[row][i] = true;
				dfs(row+1);			//ä��� ���� �� ó��
				map[row][i] = false;
			}
		}
	}

	static boolean promising(int row, int col) {	//ä�� �� �ִ� �ڸ����� Ȯ��
		for(int i=0; i<row; i++) {
			int diff = row - i;		//���� ����� �� (�밢�� �ڸ� ���⿡ ����)
			if(col-diff >= 0 && map[i][col-diff]) return false;	//���� �밢��
			if(col+diff < N && map[i][col+diff]) return false;	//������ �밢��
			if(map[i][col]) return false;	//���� ������
		}
		return true;	//��� �ƴϸ� ���� �� �ִ� �ڸ�
	}
}
