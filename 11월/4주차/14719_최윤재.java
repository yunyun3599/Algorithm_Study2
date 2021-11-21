package tmp;
import java.util.*;
public class _14719_������_���� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int result = 0;
		
		int block[] = new int[W];	//��� ����
		for(int i=0; i<W; i++) {
			block[i] = sc.nextInt();
		}
		
		for(int i=1; i<W-1; i++) {	//2��°���� ������-1 ��ġ���� Ȯ��
			int floor = block[i];	//������ �ٴ� ����
			int lmax = 0;	//���ʿ��� ���� ���� ���
			int rmax = 0;	//�����ʿ��� ���� ���� ���
			for(int j=0; j<i; j++) {	//���ʿ��� ���� ���� ��� ���ϱ�
				lmax = Math.max(lmax, block[j]);
			}
			for(int j=i+1; j<W; j++) {	//�����ʿ��� ���� ���� ��� ���ϱ�
				rmax = Math.max(rmax, block[j]);
			}
			if(lmax > floor && rmax > floor) {	//���� �����ʿ��� ���� ���� ��� ��� ���� �ٴں��� ���� ��쿡�� ���� ����
				result += Math.min(lmax, rmax) - floor;
			}
		}
		System.out.println(result);
	}

}
