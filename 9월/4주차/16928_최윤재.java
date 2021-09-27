package tmp;
import java.io.*;
import java.util.*;

class Loc{
	int num;
	int roll;
	Loc(int num, int roll){
		this.num = num;
		this.roll = roll;
	}
}

public class _16928_������_�����ٸ����� {
	
	static int laddernum;
	static int snakenum;
	static HashMap<Integer, Integer> ladder = new HashMap<>();
	static HashMap<Integer, Integer> snake = new HashMap<>();
	static int loc = 1;
	static int[] dice = {1,2,3,4,5,6};
	static boolean visited[] = new boolean[101];
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		laddernum = Integer.parseInt(st.nextToken());
		snakenum = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<laddernum; i++) {		//��ٸ� ���� hashmap�� ����
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			ladder.put(from, to);
		}
		for(int i=0; i<snakenum; i++) {			//�� ���� hashmap�� ����
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			snake.put(from, to);
		}
		
		Queue<Loc> queue = new LinkedList<>();	//bfs
		queue.add(new Loc(1, 0));
		visited[1] = true;		//�湮ó��
		while(!queue.isEmpty()) {
			Loc cur = queue.poll();	//���� ��ġ�� �ֻ��� ���� Ƚ�� poll
			if(cur.num==100) {	//������ ���
				System.out.println(cur.roll);
				break;
			}
			for(int k=0; k<6; k++) {	//�ֻ��� ������ ����� �� 6��
				int nextnum = cur.num+dice[k];
				if(nextnum>100 || visited[nextnum]) continue;	//�̹� �湮�� ���̰ų� 100 �̻��� ���� ���� Ȯ�� ����
				if(ladder.containsKey(nextnum)) {	//��ٸ� �ִ� ĭ�� ���
					queue.add(new Loc(ladder.get(nextnum), cur.roll+1));	//��ٸ��� �̵��� ĭ�� queue�� �ֱ�
					visited[ladder.get(nextnum)] = true;
					visited[nextnum] = true;
					continue;
				}
				if(snake.containsKey(nextnum)) {	//���� �ִ� ĭ�� ���
					queue.add(new Loc(snake.get(nextnum), cur.roll+1));
					visited[snake.get(nextnum)] = true;
					visited[nextnum] = true;
					continue;
				}
				queue.add(new Loc(nextnum, cur.roll+1));	//�ƹ��͵� ���� ĭ�� ���
				visited[nextnum] = true;
			}
		}
	}

}
