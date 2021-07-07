package tmp;
import java.util.*;
import java.io.*;

class Frame implements Comparable<Frame> {		//Arraylist�� ���� ��ü
	int no;	//�л���ȣ
	int rec;	//��õ��
	int time;	//�� ���� (�������� ����)
	Frame(int no, int rec, int time){
		this.no = no;
		this.rec = rec;
		this.time = time;
	}
	public int compareTo(Frame another) {	//���Ĺ��. (rec�� ������ ������, rec������ ������ �� ������)
		if(this.rec == another.rec) {
			return this.time - another.time;
		}
		return this.rec - another.rec;
	}
}

public class _1713_������_�ĺ���õ�ϱ� {

	static int frame;	//����Ʋ ��
	static int num;	//��õ ����
	static int time;	//�ð� 1�� ����
	static ArrayList<Frame> cand = new ArrayList<>();	//���� Ʋ �ö� �л� ����
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		frame = Integer.parseInt(br.readLine());
		num = Integer.parseInt(br.readLine());
		StringTokenizer input = new StringTokenizer(br.readLine());
		//////////////////////////////////////////////�Է�
		for(int i=0; i<num; i++) {	//�� ��õ�� ���� ����
			int student = Integer.parseInt(input.nextToken());
			boolean flag = true;
			for(Frame candidate : cand) {	//�̹� ����Ʋ�� �ö� ����� ���
				if(candidate.no == student) {
					candidate.rec++;
					flag = false;
					break;
				}
			}
			if(flag) {	//����Ʋ�� �ö� ���� ���� ����� ���
				if(cand.size() < frame) cand.add(new Frame(student, 1, time++));	//����Ʋ�� �ڸ� �������� ��
				else {	//����Ʋ���� ���� ������ �� ��
					Collections.sort(cand);	//���� ��� ���ϱ� ���� ����
					cand.remove(0);	//���� ��� ���� �տ� �ִ� �л� ����
					cand.add(new Frame(student, 1, time++));	//�� �л� �ø��� �ð� ������Ŵ
				}
			}
		}
		Collections.sort(cand, new Comparator<Frame>() {	//����� ���� �л� ���ڸ� ������������ ����
			public int compare(Frame candidate1, Frame candidate2) {
				return candidate1.no - candidate2.no;
			}
		});
		for(Frame candidate : cand) {	//���ĵ� ����� ���ʴ�� ���
			bw.write(candidate.no+" ");
		}
		bw.flush();
		bw.close();
	}

}
