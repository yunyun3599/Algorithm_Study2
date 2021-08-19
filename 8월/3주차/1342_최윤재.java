package tmp;
import java.util.*;
public class _1342_������_����ǹ��ڿ� {

	static String input;
	static int alphabet[] = new int[26];	//�� ���ĺ� � ���Գ� ����
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		for(int i=0; i<input.length(); i++) {
			alphabet[input.charAt(i)-'a']++;	//�� character���� ���ĺ� �迭�� ���� ����
		}

		for(int i=0; i<26; i++) {	//�� ���ĺ����� �ϳ� �̻� ������ �װŷ� �����ϴ� ���ڿ� ��� ����
			if(alphabet[i]>0) {
				alphabet[i]--;	//�����ϱ� ���� ����
				concat(i, 1);	//concat
				alphabet[i]++;	//���� �ٽ� ���ϱ�
			}
		}
		System.out.println(result);
	}
	public static void concat(int prev, int len) {	//prev�� ������ ���� ���ĺ��� �ε���, len�� ���ݱ��� ���� ���ڿ� ����
		if(len==input.length()) {	//���ڿ� �ϼ��� ��� result �� �ϳ� �ø�
			result++;
			return;
		}
		for(int i=0; i<26; i++) {	//���ĺ�������ŭ ������
			if(prev!=i && alphabet[i]>0) {	//���� ���ĺ��� �ٸ��� �� �� �ִ� ���ĺ��� ���� ���
				alphabet[i]--;
				concat(i, len+1);
				alphabet[i]++;
			}
		}
	}
}
