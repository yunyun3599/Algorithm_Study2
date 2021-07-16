package tmp;
import java.util.*;
import java.io.*;
public class _6064_������_ī�״޷� {

	static int testcase;
	static StringBuilder sb = new StringBuilder("");
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		while(testcase-->0) {
			HashSet<Integer> set = new HashSet<>();	//x�� ������ ���ڵ� ����  hashset
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int bigger = M > N ? M : N;	//�� ū ��
			int smaller = M < N ? M : N;	//�� ���� ��
			int GCD = getGCD(bigger, smaller);	//�ִ����� ����
			int LCM = M*N/GCD;	//�ּҰ���� ����(������ ��)
			
			boolean impossible = true;
			while(x<=LCM) {	//�ּҰ�������� �۰� x���� ���� �� �ִ� ��� ������ Hashset�� ����
				set.add(x);
				x += M;
			}
			while(y<=LCM) {	//�ּҰ�������� �۰� y���� ���� �� �ִ� ���鿡 ���� Ž��
				if(set.contains(y)) {	//x���� �����ϴٰ� set �ȿ� ���� ���
					impossible = false;
					sb.append(y+"\n");
					break;
				}
				y += N;
			}
			if(impossible) sb.append(-1+"\n");	//�Ұ����Ѱ��
		}
		System.out.println(sb);
	}
	public static int getGCD(int bigger, int smaller) {	//�ִ����� ���ϴ� ��� (��Ŭ���� ȣ����)
		if(bigger%smaller==0) return smaller;
		int remainder = bigger%smaller;
		int result = getGCD(smaller, remainder);
		return result;
	}
}
