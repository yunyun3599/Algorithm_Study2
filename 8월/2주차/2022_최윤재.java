package tmp;
import java.util.*;

public class _2022_������_��ٸ� {

	static double x;
	static double y;
	static double c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextDouble();
		y = sc.nextDouble();
		c = sc.nextDouble();
		/////////////////////////////////�Է�
		if(x>y) {		//�� ū ���� y��
			double tmp = y;
			y=x;
			x=tmp;
		}
		
		double low = 0;	//�̺�Ž��. �ǹ��� �Ÿ��� mid
		double high = y;
		while(low<high) {
			double mid = (low+high)/2;
			double ya = Math.sqrt(y*y-mid*mid);
			double xa = Math.sqrt(x*x - mid*mid);
			double result = (ya*xa)/(ya+xa);		//�������� ���� ���� (sqrt((y^2-a^2)(x^2-a^2))/(sqrt(y^2-a^2)+sqrt(x^2-a^2))��
			if(Math.abs(result-c)<= 0.001) {		//������ 0.001���� ������ stop
				System.out.printf("%.3f",Math.round(mid*1000)/1000.0);	//��� �Ҽ��� ����° �ڸ����� ���
				System.exit(0);
			}
			else if(result > c) low = mid;	//���� c�� ��ǥ c���� ũ�� �ǹ��� �Ÿ��� �ʹ� ���� ���� ���̹Ƿ� low�� mid�� �ø�
			else high = mid;	//�ǹ��� �Ÿ��� �ʹ� �ְ� ���� ���
		}
	}

}
