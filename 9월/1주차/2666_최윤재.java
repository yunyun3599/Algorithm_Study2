package tmp;
import java.io.*;
import java.util.*;
public class _2666_������_���幮���̵� {

	static int num;
	static int open1;
	static int open2;
	static int sequence_num;
	static int sequence[];
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		open1 = Integer.parseInt(st.nextToken());
		open2 = Integer.parseInt(st.nextToken());
		sequence_num = Integer.parseInt(br.readLine());	//�Է¹��� ���� ����
		sequence = new int[sequence_num];	//���� ��� ������� ����
		for(int i=0; i<sequence_num; i++) {
			sequence[i] = Integer.parseInt(br.readLine());
		}////////////////////////////////////�Է�
		calc(0, 0);	//sequence�迭�� �ε���, moveȽ���� �Ķ���ͷ� �̿�
		System.out.println(result);
	}
	static void calc(int idx, int move) {
		if(idx==sequence_num) {	//�־��� ��� ������ �� Ȯ���� �� ���
			result = Math.min(result, move);	//��� ������Ʈ
			return;
		}
		int dist1 = Math.abs(open1-sequence[idx]);	//1������ ���� Ÿ���� �Ÿ�
		int dist2 = Math.abs(open2-sequence[idx]);	//2������ ���� Ÿ���� �Ÿ�
		int originopen1 = open1;	//���� � ���幮�� �����־����� ��� ���� �����ص�
		int originopen2 = open2;
		open1 = sequence[idx];	//ù��° ���� �ڸ��� �̿�
		calc(idx+1, move+dist1);	//sequence�� ���� �� Ȯ��
		open1 = originopen1;	//ù��° ���� �� ���� �������� �ٲ�
		open2 = sequence[idx];	//�ι�° �����ڸ��� �̿�
		calc(idx+1, move+dist2);	//sequence�� ���� �� Ȯ��
		open2 = originopen2;	//�ι�° ���� �� ���� �������� �ٲ�
	}

}
