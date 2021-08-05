package tmp;
import java.util.*;

public class _3107_������_IPv6 {
	
	static String input;
	static StringBuffer result = new StringBuffer();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		String[] checkdoublecolon = input.split("::");	//::1�� ���� ����� " ","1"�ε�(length 2) 1::�̸� ����� "1"�� (length 1)
		if(checkdoublecolon.length==1) {	//::�� �������� �ʰų� ::�� ���� �ڿ� �ִ� ���
			String[] checkcolon = checkdoublecolon[0].split(":");	//::�������� split�� ���� :�� �� split
			int allZero = 8-checkcolon.length;	//��� 0�� �ʵ��� ����
			StringBuffer zerofield = new StringBuffer();	//��� 0�� ��� �����س��� sb
			StringBuffer notzerofield = new StringBuffer();	//0�� �ƴ� ��� �����س��� sb
			for(int i=0; i<checkcolon.length; i++) {	//0�� �ƴ� ��츦 0���� �ڸ����� ä�� string���� ��ȯ
				String tmp = String.format("%4s", checkcolon[i]);
				tmp = tmp.replace(" ", "0");
				notzerofield.append(tmp+":");	//0�� �ƴ� �ʵ忡 append
			}
			if(input.substring(input.length()-2, input.length()).equals("::")) {		//0000���� �ʵ尡 �ڿ� �ִ� ���
				while(allZero-->0) {
					zerofield.append(":0000");	//0000�ʵ� ä���
				}
			}
			notzerofield = notzerofield.deleteCharAt(notzerofield.length()-1);	//�ݷ� ����, ��ġ ���� �� ��� 0�� �ʵ�� �ƴ� �ʵ� append
			result.append(notzerofield);
			result.append(zerofield);
		}
		else {	//::�� �����ϴ� ��� -> �� �տ� ::�� �ְų� �߰��� ::�� ������ ���
			String[] checkcolonfront = checkdoublecolon[0].split(":");	//::�������� ���� ���ڿ��� :�� split
			String[] checkcolonback = checkdoublecolon[1].split(":");	//::�������� ���� ���ڿ��� :�� split
			StringBuffer notzerofieldfront = new StringBuffer();	//0�� �ƴ� �ʵ� �� ��
			StringBuffer notzerofieldback = new StringBuffer();		//0�� �ƴ� �ʵ��� ��
			for(int i=0; i<checkcolonfront.length; i++) {	//�� �ʵ� �ڸ��� 4���� ����
				String tmp = String.format("%4s", checkcolonfront[i]);
				tmp = tmp.replace(" ", "0");
				notzerofieldfront.append(tmp+":");
			}
			for(int i=0; i<checkcolonback.length; i++) {	//���ʵ� �ڸ��� 4���� ����
				String tmp = String.format("%4s", checkcolonback[i]);
				tmp = tmp.replace(" ", "0");
				notzerofieldback.append(tmp+":");
			}
			int allZero = 8-checkcolonfront.length-checkcolonback.length;	//0000�� � ���ӵǾ��ֳ� ���ϱ�
			StringBuffer zerofield = new StringBuffer("");	//0000���� �ʵ� ���� sb
			if(input.substring(0,2).equals("::")) {	//0000 ���� �ʵ尡 �տ� �ִ°��
				allZero++;	//���� �ʵ尡 �ϳ� �� ���Ǿ 0000�� �ʵ� ���� �ϳ� ��������� (::�� �� ���� ��� ::�� ���� �� ���ڿ��� �Ѱ��� ��)
				while(allZero-->0) {	//0000�ʵ� ä���
					zerofield.append("0000:");
				}
				notzerofieldback = notzerofieldback.deleteCharAt(notzerofieldback.length()-1);	//�ݷ� ������ ��ġ ���缭 append
				result.append(zerofield);
				result.append(notzerofieldback);
			}
			else {		//0000�� ���ӵ� �κ��� �߰��� ���� ��
				while(allZero-->0) {
					zerofield.append(":0000");
				}
				zerofield.append(":");
				notzerofieldfront = notzerofieldfront.deleteCharAt(notzerofieldfront.length()-1);	//zero�ʵ� �յڷ� ���� �ʵ� �ٿ��ֱ�
				notzerofieldback = notzerofieldback.deleteCharAt(notzerofieldback.length()-1);
				result.append(notzerofieldfront);
				result.append(zerofield);
				result.append(notzerofieldback);
			}
		}
		System.out.println(result);
	}

}
