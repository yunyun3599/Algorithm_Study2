package tmp;
import java.util.*;
import java.util.regex.Pattern;
public class _2671_������_����Խĺ� {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String pattern = "(100+1+|01)+";		//����� Ȯ���ϴ� ���Խ�
		if(Pattern.matches(pattern, input)) 	//���� ���Խ��� �����ϴ��� Ȯ��
			System.out.println("SUBMARINE");
		else System.out.println("NOISE");
	}
}
