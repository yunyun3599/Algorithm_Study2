package tmp;
import java.io.*;
import java.util.*;

public class _2109_������_��ȸ���� {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> input = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);	//�Է¹��� �켱���� ť. ��¥�� �������� ����
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);	//���������� �� ���ǿ� ���� �켱���� ť. ���̸� �������� ����
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int pay = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			input.add(new int[] {pay, day});
		}//////////////�Է�
		
		while(!input.isEmpty()) {
			int[] lecture = input.poll();	//Ȯ���� ����
			int pay = lecture[0]; int day = lecture[1];
			if(pq.size() < day) {	//������� �ϱ�� �� ���ǵ� �� � �͵� ���� �ʾƵ� �Ǵ� ��Ȳ
				pq.add(new int[] {pay, day});
			} else {	//������� ���� ���� �� � ���� �����ϴ� ��Ȳ
				while(pq.size() >= day) {	//�ʿ��� ��ŭ ����
					if(pq.peek()[0] > pay) break;	//���� ���� ���� ���̰� �ϱ�� �� ������ ���� ���� ���̺��� ������ �̹� ���Ǵ� �߰����� ����
					pq.poll();	//������ ���� ���� ��
				}
				if(pq.size() == day) continue;	//���Ǹ� �ȖA ���
				pq.add(new int[] {pay, day});	//���Ǹ� ���� �̹� ���Ǹ� �ִ� ���
			}
		}
		
		int money = 0;
		while(!pq.isEmpty()) {
			money += pq.poll()[0];	//�ϱ�� �� ���ǵ��� ���� ������ ���ϱ�
		}
		System.out.println(money);
	}

}
