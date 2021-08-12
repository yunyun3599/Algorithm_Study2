package tmp;
import java.util.*;
import java.io.*;

class Move implements Comparable<Move> {
	int start;
	int end;
	Move(int start, int end){
		this.start = start;
		this.end = end;
	}
	public int compareTo(Move other) {
		return this.end-other.end;	//���� ������ ���� ����� ���� ���� ����
	}
}

public class _2836_������_�����ý� {
	
	static int N;
	static int M;
	static ArrayList<Move> loc = new ArrayList<>();	//������� ���������� ���� ����� �������, �������� ������ arraylist
	static int right;		//start ���� �� ���� �޺κ�
	static int left;		//end ���� �� ���� �պκ�
	static long answer;		//�Ųٷ� ���� ����� �Ÿ� ����

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		while(N-->0) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if(end<start) loc.add(new Move(start, end));	//������� ���������� ���� ����� �������, �������� ����
		}////////////////////////////////////////////////////////�Է�
		Collections.sort(loc);	//������ �������� ����
		right = loc.get(0).start;	//������� �� �ڿ� �����Ƿ� start�� right
		left = loc.get(0).end;		//�������� �� �տ� �����Ƿ� end�� left
		for(int i=1; i<loc.size(); i++) {	//�迭 ���̸�ŭ �ݺ�
			Move move = loc.get(i);
			if(move.end < right) right = move.start<right ? right : move.start;	//�̹��� Ž���� ��ΰ� ���� ��ο� �������� ���
			else {		//�̹��� Ž���� ��ΰ� ���� ��ο� �������ִ� ���
				answer += right-left;	//���� ����� ���� �켱 ����
				right = move.start;	//right�� left�� ������Ʈ
				left = move.end;
			}
		}
		answer += right-left;	//��� �� ����� ����
		System.out.println(answer*2 + M);	//������ �� �ѹ�, �ٽ� �ö� �� �ѹ� �� �ι� �Դٰ��� �ϹǷ� answer�� 2 ����. ��������� ������������ �� �տ� �ִ� ������� M�� �������ν� �� Ŀ�� ����
	}

}
