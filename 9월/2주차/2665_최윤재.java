package tmp;
import java.util.*;
import java.io.*;

class Location{			//queue�� ���� ��
	int y, x, broken;	//��ǥ�� ��� ������� �ٲ����
	Location(int y, int x, int broken){
		this.y = y;
		this.x = x;
		this.broken = broken;
	}
}

public class _2665_������_�̷θ���� {

	static int n;
	static int map[][];
	static int visited[][];		//���� �湮�� �� ���� ��쿡�� -1�� ����, �湮�� �� ������ �ش�ĭ���� ���� �� ������� �ٲ� Ƚ�� ����
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				visited[i][j] = -1;	//visited�� �ʱ⿡ ���� -1�� ����
			}
		}
		
		for(int i=0; i<n; i++) {
			char input[] = br.readLine().toCharArray();
			for(int j=0; j<n; j++) {
				map[i][j] = input[j]-'0';
			}
		}
		///////////////////////////////////////////////////////�Է�
		Queue<Location> q = new LinkedList<>();	//bfs
		q.add(new Location(0, 0, 0));	//ó�� ��ġ queue�� ����
		
		while(!q.isEmpty()) {	//queue�� �� ������ �ݺ�
			Location cur = q.poll();
			if(cur.y == n-1 && cur.x == n-1) result = Math.min(result, cur.broken);	//�������� ���� result�� ������� ���� �� �� ������ �ٲ� Ƚ�� ���ؼ� �ּڰ� ����
			for(int k=0; k<4; k++) {	//�����¿�
				int ny = cur.y + dy[k];
				int nx = cur.x + dx[k];
				if(check(ny, nx, cur.broken)) {	//���� �� visited Ȯ��
					if(map[ny][nx] == 0) {	//���� ���̸� broken �ϳ� Ű���� ��
						q.add(new Location(ny, nx, cur.broken+1));
						visited[ny][nx] = cur.broken+1;	//visited �� ������Ʈ
					}
					else {	//���� �� �ƴϸ� broken �״��
						q.add(new Location(ny, nx, cur.broken));
						visited[ny][nx] = cur.broken;	//visited�� ������Ʈ
					}
				}
			}
		}
		System.out.println(result);	//��� ���
	}
	public static boolean check(int y, int x, int broken) {	//��ǥ�� ���ݱ��� �� ������ �ٲ� Ƚ�� ����ؼ� ���� ĭ�� queue�� ������ boolean ����
		if(0<=y && 0<=x && y<n && x<n) {	//��ǥ ���� üũ
			if(visited[y][x]==-1) return true;	//���� �ƿ� �湮�� �� ���� ĭ�̸� true ����
			if(map[y][x] == 0 && visited[y][x] > broken+1) return true;	//���� ���� ��� �� ������ �ٲ���ϹǷ� ���ݱ��� �ٲ� Ƚ�� +1 �� ���� visited���� �۾ƾ� true ����
			if(map[y][x] == 1 && visited[y][x] > broken) return true;	//�� ���� ��� ������� �� ������ �ٲ� Ƚ���� visited���� �۾ƾ� true ����
		}
		return false;
	}

}
