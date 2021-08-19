package tmp;
import java.util.*;
import java.io.*;
public class _9177_������_�ܾ�� {

	static int testcase;
	static char[] word1;
	static char[] word2;
	static char[] target;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		int casenum=0;
		while(casenum++ < testcase) {		//�׽�Ʈĳ�̽���ŭ �ݺ�
			StringTokenizer input = new StringTokenizer(br.readLine());
			word1 = input.nextToken().toCharArray();
			word2 = input.nextToken().toCharArray();
			target = input.nextToken().toCharArray();	//�Է�
			HashSet<Character> set = new HashSet<>();	//word1�� word2�� �ִ� ��� char�� HashSet�� ����
			for(int i=0; i<word1.length; i++) set.add(word1[i]);
			for(int i=0; i<word2.length; i++) set.add(word2[i]);
			boolean flag = false;
			for(int i=0; i<target.length; i++) {	//target�� �ִ� char���� �켱 ��� HashSet�� �־�� �����ܰ� �� (�� ���� ������ �ð��ʰ�)
				if(set.contains(target[i])) continue;
				result.append("Data set "+casenum+": no\n");
				flag = true;
				break;
			}
			if(!flag) {	//HashSet�ȿ� �ʿ��� char���� �� ������ ���ڿ� �����غ�
				if(checkchar(0,0,0)) result.append("Data set "+casenum+": yes\n");	//�����Ѱ��
				else result.append("Data set "+casenum+": no\n");
			}
		}
		System.out.println(result);
	}
	public static boolean checkchar(int idx1, int idx2, int idx3) {	//idx1�� word1�� ����, idx2�� word2�� ����, idx3�� target�� ����
		boolean ispossible = false;	//�������
		if(idx1+idx2 == target.length) return true;	//����� ���� ������ ��쿡 �������� �� true ����
		if(idx1<word1.length && target[idx3] == word1[idx1]) ispossible = ispossible || checkchar(idx1+1, idx2, idx3+1);	//or�� ispossible�� ó��
		if(idx2<word2.length && target[idx3] == word2[idx2]) ispossible = ispossible || checkchar(idx1, idx2+1, idx3+1);	//��ü�� �ѹ��̶� �����ϸ� true ����
		return ispossible;	//��� ����
	}
}
