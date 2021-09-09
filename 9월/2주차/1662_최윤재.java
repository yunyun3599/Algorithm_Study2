package tmp;
import java.util.Scanner;
import java.util.Stack;

class Strlen{
	int num;
	int depth;			//��ȣ ��� �����ִ��� 
	Strlen(int num, int depth){
		this.num = num;
		this.depth = depth;
	}
}
public class _1662_������_���� {

	static char[] input;	//�Է�
	static int depth=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine().toCharArray();
		Stack<Strlen> stack = new Stack<>();
		//////////////////////////////////////////////�Է�
		for(int i=0; i<input.length; i++) {	//������ char���� Ȯ��
			char num = input[i];
			if(num=='(') {	//���� ��ȣ�� depth ����
				depth++;
			}
			else if(num==')') {	//�ݴ� ��ȣ�� ��� ������ ��ȣ ���� �ִ� ������ ��� pop
				int tmp_len = 0;	//�ش� ��ȣ ���� ���ڿ� ����
				if(!stack.isEmpty() && stack.peek().depth==depth)tmp_len = stack.pop().num;	//stack�� ������� �ʰ� ()�� �ƴ� ��쿡 ����
				while(!stack.isEmpty() && stack.peek().depth==depth) {	//stack�� ������� �ʰ� ���� depth�� ���ؼ��� pop
					Strlen str = stack.pop();
					tmp_len += str.num;		//string�� ���̸�ŭ tmp_len�� ����
				}
				if(!stack.isEmpty())tmp_len *= stack.pop().num;	//stack�� ������� ���� ��쿡 ���ؼ��� ���� ��ȣ �ٷ� ���� ���ڸ� ���̿� ����
				depth--;	//��ȣ �������Ƿ� depth �ϳ� ����
				stack.push(new Strlen(tmp_len, depth));	//���ݱ��� ���� str�� ���̸� stack�� �ٽ� push
			}
			else {	//������ ���
				if(i != input.length-1 && input[i+1]=='(')	//���� character�� (�� ���� ���� �ִ� ���
					stack.push(new Strlen(num-'0', depth));	//���ڸ� �״�� ����
				else
					stack.push(new Strlen(1, depth));		//������ str�θ� ó���Ǵ� ����̹Ƿ� str������ 1�� ����
			}
		}
		int result = 0;
		while(!stack.isEmpty()) {	//stack���� ��� �����鼭 ���̸� result�� ����
			Strlen str = stack.pop();
			result += str.num;
		}
		System.out.println(result);
	}

}
