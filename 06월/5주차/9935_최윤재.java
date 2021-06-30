package tmp;
import java.io.*;
public class _9935_������_���ڿ����� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuffer input = new StringBuffer(br.readLine());	//�ð��ʰ����� �� �κ�
		char[] input = br.readLine().toCharArray();	//�Է¹��� ���ڿ� char array�� �ٲ�
		String bomb = br.readLine();	//���߽�ų ���ڿ�
		int len = bomb.length();	//���߽�ų ���ڿ��� ����
		StringBuilder result = new StringBuilder();	//��� ���� StringBuilder

		for(int i=0; i<input.length; i++) {
			result.append(input[i]);	//����� input�� char�� �ϳ��� append
			if(result.length()>=len) {	//���߽�ų ���ڿ����� ����� ���
				boolean explode = true;	//�켱 ���߽�Ų�ٰ� �س���
				for(int idx = 0; idx<len; idx++) {	//�ε��� ������Ű�鼭 ���߽�ų ���ڿ��� ��ġ�ϴ��� Ȯ��
					if(result.charAt(result.length()-len+idx) != bomb.charAt(idx)) {
						explode = false;	//��ġ���� �ʴ� ��� ���� �Ƚ�Ŵ
						break;
					}
				}
				if(explode) result.delete(result.length()-len, result.length());	//���߽�Ű�� ��� result���� �ش� ���ڿ���ŭ ����
			}
		}
		if(result.length()==0) System.out.println("FRULA");	//�ƹ� ���ڿ��� ���� ���� ���
		else System.out.println(result);	//����� ���ڿ� ���� ���
		
		
		/*int idx = input.indexOf(bomb);
		while(idx != -1) {
			input = input.delete(idx, idx+len);
			idx = input.indexOf(bomb, idx-len);
		}
		if(input.length()!=0) System.out.println(input);
		else System.out.println("FRULA");
		*/
	}
}
