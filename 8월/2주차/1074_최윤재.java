package tmp;
import java.util.*;

public class _1074_������_Z {
	
	static int N;
	static int r;
	static int c;
	static int result;
	static int[] dx = {0,1,0,1};	//z���
	static int[] dy = {0,0,1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		N = (int)Math.pow(2, N);	//2�� N�������� ��ȯ
		r = sc.nextInt();
		c = sc.nextInt();
		divide(N,0,0);	//��������
	}
	public static void divide(int width, int y, int x) {
		if(y>r || x>c) {		//�ش� ������ (r,c)�� ���� ���� �ش� ���� ���� ĭ ������ŭ result�� �ø��� �ٷ� ����
			result += width*width;
			return;
		}
		if(y+width-1<r || x+width-1<c) {
			result += width*width;
			return;
		}
		if(width==2) {			//4ĭ�� ��
			for(int k=0; k<4; k++) {	//�����¿�Ȯ��
				if(y+dy[k] == r && x+dx[k]==c) {	//(r,c)�� ��쿡 �ɸ� Ƚ�� ���
					System.out.println(result);
					System.exit(0);
				}
				result++;
			}
		}
		else {
			divide(width/2, y, x);
			divide(width/2, y, x+width/2);
			divide(width/2, y+width/2, x);
			divide(width/2, y+width/2, x+width/2);
		}
	}
}
