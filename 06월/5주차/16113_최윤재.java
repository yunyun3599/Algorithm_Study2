package tmp;
import java.util.*;

public class _16113_������_�ñ׳� {

	static String[] numbers = {	//�� ���ں��� String���� ��Ÿ���� �� � �������
			"####.##.##.####",
			"",
			"###..#####..###",
			"###..####..####",
			"#.##.####..#..#",
			"####..###..####",
			"####..####.####",
			"###..#..#..#..#",
			"####.#####.####",
			"####.####..####"
			};
	static char[][] signal;	//�Է¹޴� ���ڿ� ���� ��
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		sc.nextLine();
		String input = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		
		signal = new char[5][len/5];
		for(int i=0; i<5; i++) {
			signal[i] = input.substring(i*(len/5), (i+1)*(len/5)).toCharArray();	//�ະ�� ����
		}
		///////////////////////////////�Է�
		for(int i=0; i<len/5; i++) {	//1������ ���ʴ�� ���� �������� Ȯ��
			if(signal[0][i]=='.') continue;
			if((i+2)<len/5 && signal[0][i]=='#'&&signal[0][i+2]=='#') {	//ù��ù���� ù��3���� ���� �� �� #�� ���, i+2<len/5���ϸ� ��Ÿ�ӿ��� 
				if(signal[0][i+1]=='#') {	//������� #�� ��� -> ###�� ù���� ���(2,3,5,6,7,8,9,0�� �ش�)
					String tmp="";
					for(int j=0; j<5; j++) {	//tmp�� �� �ະ ���� append�ؼ� �ϳ��� string������ ����
						tmp += signal[j][i];
						tmp += signal[j][i+1];
						tmp += signal[j][i+2];
					}
					for(int j=0; j<10; j++)	//numbers �迭�� �̸� �����س��� string���� ��
						if(tmp.equals(numbers[j])) {
							sb.append(j);
							break;
						}
					i += 3;	//�ε��� ������Ű��
				}
				else {
					if(signal[4][i]=='#') {	//���� �տ� 1�� ���� �� ���� ���� ���� ���ڰ� �� �� ���
						sb.append(1);
						i += 1;
					}
					else {	//4�ΰ��
						sb.append(4);
						i += 3;
					}
				}
			}
			else {		//1�ΰ��
				sb.append(1);
				i += 1;
			}
		}
		System.out.println(sb);	//��� ���
	}
}
