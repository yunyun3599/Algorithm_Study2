package tmp;
import java.util.*;
import java.io.*;
public class _2467_������_��� {

	static int num;	//��� ����
	static int solution[];	//��� ����
	static int result = Integer.MAX_VALUE;	//0�� ���� ����� ��
	static int answer1;	//�� ���� ���� ���
	static int answer2;	//�� ���� ū ���
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		solution = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<num; i++) solution[i] = Integer.parseInt(st.nextToken());
		////////////////////////////�Է�
		Arrays.sort(solution);	//�������� ����
		
		int left = 0;	//���� �ε���
		int right = num-1;	//������ �ε���
		
		while(left<right) {
			if(Math.abs(solution[left]+solution[right]) < result) {	//���� result���� 0�� �� ������ ������Ʈ
				result = Math.abs(solution[left]+solution[right]);
				answer1 = solution[left];
				answer2 = solution[right];
			}
			if(solution[left]+solution[right]<0) left++;	//���� ���� 0���� ������ ���� �κ� ++
			else right--;	//���� ���� 0���� ũ�� ��� �κ�--
		}
		System.out.println(answer1 + " " + answer2);
	}

}
