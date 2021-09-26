package tmp;
import java.util.*;

public class _2290_������_LCDTest {
	
	static int s;
	static String n;
	static char[][] result;
	static char[][] num = {
			{'-', ' ', '-', '|', '|', '|', '|'},	// �ε����� ��ġ
			{' ', ' ', ' ', ' ', ' ', '|', '|'},	//   0
			{'-', '-', '-', ' ', '|', '|', ' '},	// 3   5
			{'-', '-', '-', ' ', ' ', '|', '|'},	//   1
			{' ', '-', ' ', '|', ' ', '|', '|'},	// 4   6
			{'-', '-', '-', '|', ' ', ' ', '|'},	//   2
			{'-', '-', '-', '|', '|', ' ', '|'},
			{'-', ' ', ' ', ' ', ' ', '|', '|'},
			{'-', '-', '-', '|', '|', '|', '|'},
			{'-', '-', '-', '|', ' ', '|', '|'}
	};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		s = Integer.parseInt(st.nextToken());
		n = st.nextToken();
		int width = (s+3)*n.length()-1;
		result = new char[2*s+3][width];
		
		for(int i=0; i<result.length; i++) {		//result�迭�� ���� �켱 �� ' '���� ä����
			for(int j=0; j<result[0].length; j++) {
				result[i][j] = ' ';
			}
		}
		
		int startloc = 0;
		for(int i=0; i<n.length(); i++) {
			int number = n.charAt(i) - '0';
			int y, x;
			for(int j=0; j<7; j++) {	//0��~7�������� �ڸ��� �ݺ��ؼ� ä��������
				y = 0;			//�� �ڸ��� ���� �ε���(y,x)
				x = startloc;
				switch(j) {
				case 0:
					x = startloc + 1;
					break;
				case 1:
					x = startloc + 1;
					y = s + 1;
					break;
				case 2:
					x = startloc + 1;
					y = 2 * s + 2;
					break;
				case 3:
					y = 1;
					break;
				case 4:
					y = s + 2;
					break;
				case 5:
					x = startloc + s + 1;
					y = 1;
					break;
				case 6:
					x = startloc + s + 1;
					y = s + 2;
					break;
				}
				
				if(j<3) fill(y, x, 0, 1, num[number][j]);	//result�迭�� ä��� �Լ� fill
				else fill(y, x, 1, 0, num[number][j]);		//���η� ä���� �� ���� row=0, col=1 ������ ��쿡�� �� �ݴ�� �Ķ���� �ѱ��
			}
			startloc += s+3;
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<result.length; i++) {		//��� stringbuffer�� ���� �� ���
			for(int j=0; j<result[0].length; j++)
				sb.append(result[i][j]);
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	public static void fill(int y, int x, int row, int col, char bar) {	//y,x�� ���� �ε���, row,col�� ���η� ä���� ���η� ä����, bar�� '|'���� '-'����
		if(bar==' ') return;	//����κ��̸� �ٷ� ����
		for(int i=0; i<s; i++, y+=row, x+=col) {	//s��ŭ �ݺ��ؼ� ä��
			result[y][x] = bar;
		}
	}

}
