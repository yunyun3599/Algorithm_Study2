package tmp;
import java.io.*;
import java.util.*;
public class _1756_������_���ڱ��� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());	//���� ����
		int N = Integer.parseInt(st.nextToken());	//���� ����
		int maxwidth[] = new int[D];	//�ش� ������ ���쿡 ���� �� �ִ� ���� �ѷ��� max��
		int min = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<D; i++) {	//�ش� ���� ��ġ�� ���� �� �ִ� max�� ä���
			min = Math.min(min, Integer.parseInt(st.nextToken()));
			maxwidth[i] = min;
		}
		int idx = D-1;	//���� ���� ��ġ���� ���� ���� �� �ֳ� Ȯ��
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {	//���ڵ� �ϳ��� Ȯ��
			int pizza = Integer.parseInt(st.nextToken());
			while(idx >= 0 && pizza > maxwidth[idx]) {	//�ش� ��ġ�� ���� �� ������ �� ĭ �� Ȯ��
				idx--;
				if(idx < 0) break;	//�ε��� ����� �׸� Ȯ���ϱ�
			}
			if(idx < 0) {	//���ڸ� �� ���� ���ϴ� ���
				System.out.println(0);
				System.exit(0);
			}
			idx--;	//���ڸ� ���� ��� ���� ���ڴ� �� �� ĭ�� Ȯ��
		}
		System.out.println(idx+2);	//�� ���� ��쿡 �ݺ������� �� �� �����ϱ� 1 ���ϰ�, idx�� 0���� ���������ϱ� 1 �� ���ϱ�
	}

}
