package tmp;
import java.util.*;
public class _2448_������_����� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		ArrayList<String> pattern = new ArrayList<>();	//���� ����
		pattern.add("  *  ");	//�ʱ� ����
		pattern.add(" * * ");
		pattern.add("*****");
		
		int total_iter = (int)(Math.log(N/3) / Math.log(2));	//�ݺ� Ƚ���� log2(N/3)��
		
		for(int iter = 0; iter<total_iter; iter++) {	//�ݺ� Ƚ����ŭ �ݺ�
			draw(pattern);
		}
		for(String line : pattern) System.out.println(line);
	}
	
	public static void draw(List<String> pattern) {
		int patternLength = pattern.size();	//���ݱ��� ���� ����
		
		for(int i=0; i<patternLength; i++) {	//������ �� �� ������ �ؿ� �ױ�
			StringBuilder sb = new StringBuilder();
			
			sb.append(pattern.get(i));	//�߰��� ������ �ΰ� ������ �ΰ��� �̾����
			sb.append(" ");
			sb.append(pattern.get(i));
			
			pattern.add(sb.toString());	//���Ͽ� ���� ���� ���� �߰�
			
			StringBuilder blank = new StringBuilder();	//������ �ִ� ���� �յڷ� ��ĭ �־������
			for(int j=0; j<patternLength; j++) blank.append(" ");	//��ĭ�� ���� ���� ���̸�ŭ ���� ����
			pattern.set(i, blank.toString() + pattern.get(i) + blank.toString());	//���� ������� ��ĭ ���� �������� ���� ���ϰ� ������Ʈ
		}
	}

}
