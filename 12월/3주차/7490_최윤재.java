package tmp;
import java.util.*;

public class _7490_������_0����� {

	static char[] operator = {' ', '+', '-'};
	static int num;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		while(testcase-- > 0) {	//�׽�Ʈ���̽���ŭ �ݺ�
			num = sc.nextInt();
			char[] operatorSet = new char[num];
			operatorSet[0] = '+';
			makeOperator(operatorSet, 1, num);	//���� ���� ���� �Ǵ� �� �� Ȯ��
			System.out.println();
		}
	}
	public static void calc(char[] operatorSet) {
		int acc = 0;	//������
		int tmpnum = 0;	//������ ���� �� �̾�ٿ����� ����
		StringBuilder result = new StringBuilder();	//�� ���ڿ� ����
		for(int i=0; i<num; i++) {
			if(operatorSet[i]==' ') {	//������ ���
				tmpnum = tmpnum < 0 ? tmpnum * 10 - (i+1) : tmpnum * 10 + (i+1);	//���� tmpnum���� 10�� ��ģ �� ������ ���� ���� ���� ����� ���� ���� ����
			}
			if(operatorSet[i] == '+') {	//���ϱ��� ��
				acc += tmpnum;
				tmpnum = i+1;
			}
			if(operatorSet[i] == '-') {	//������ ��
				acc += tmpnum;
				tmpnum = (i+1) * (-1);
			}
			result.append(operatorSet[i]+""+(i+1));	//�� �����
		}
		acc += tmpnum;	//������ ���ڱ��� �� ���
		if(acc == 0) {	//��� ����� 0�̸� ���
			System.out.println(result.substring(1));
		}
		
	}
	public static void makeOperator(char[] operatorSet, int idx, int limit) {	//��� ���� ������ ����
		if(limit == idx) {	//���� ���� �� ����� �ش� �������� ����غ���
			calc(operatorSet);
			return;
		}
		for(int i=0; i<3; i++) {	//' ' + -
			operatorSet[idx] = operator[i];
			makeOperator(operatorSet, idx+1, limit);
		}
	}

}
