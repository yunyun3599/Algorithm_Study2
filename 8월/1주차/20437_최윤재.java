package tmp;
import java.io.*;
import java.util.*;
public class _20437_������_���ڿ�����2 {

	static int testcase;
	static ArrayList<Integer>[] alphabet = new ArrayList[26];	//a-z ��� �ε����� �ִ��� ���� 
	static int K;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		while(testcase-->0) {
			int min = Integer.MAX_VALUE;
			String input = br.readLine();
			K = Integer.parseInt(br.readLine());
			for(int i=0; i<26; i++) {
				alphabet[i] = new ArrayList<Integer>();
			}
			for(int i=0; i<input.length(); i++) 	//���ڿ��� ���ĺ��� ��ġ ����
				alphabet[input.charAt(i)-'a'].add(i);
			findlongest();	//���� ã�� �Լ�
		}
		System.out.println(sb);
	}
	public static void findlongest() {
		int max = 0;	//����-�� ���� ����, �ش� ���� K��
		int min = Integer.MAX_VALUE;	//K�� ���� ���� ���� ª�� ���ڿ� ����
		boolean none = true;	//������ ��찡 ���� ��쿡 true
		for(int i=0; i<26; i++) {
			int len = alphabet[i].size();
			if(len>=K) {	//K�� �̻� �����ϴ� ���ĺ��� �ִ� ��� (none = false)
				int left = 0;	//���� �ε���
				int right = K-1;	//�������ε���
				while(right<len) {	//�ε����� �ϳ��� ++ �ϸ� max, min�� Ȯ��
					max = Math.max(max, alphabet[i].get(right)-alphabet[i].get(left)+1);
					min = Math.min(min, alphabet[i].get(right)-alphabet[i].get(left)+1);
					left++;
					right++;
				}
//				while(len>K) {
//					int leftLonggap = alphabet[i].get(leftLong+1)-alphabet[i].get(leftLong);
//					int rightLonggap = alphabet[i].get(rightLong) - alphabet[i].get(rightLong-1);
//					if(leftLonggap<rightLonggap) leftLong++;
//					else rightLong--;
//					int leftShortgap = alphabet[i].get(leftShort+1)-alphabet[i].get(leftShort);
//					int rightShortgap = alphabet[i].get(rightShort)-alphabet[i].get(rightShort-1);
//					if(leftShortgap<rightShortgap)rightShort--;
//					else leftShort++;
//					len--;
//				}
				none = false;
			}
		}
		if(none) sb.append("-1\n");	//��� ���
		else sb.append(min+" "+max+"\n");
	}

}
