package tmp;
import java.util.*;
import java.io.*;

public class _15954_������_������ {

	static int N;
	static int K;
	static int dolls[];
	static double min = Double.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		dolls = new int[N];
		for(int i=0; i<N; i++) {
			dolls[i] = Integer.parseInt(st.nextToken());
		}///////////////////////////////////////////////////////�Է�
		for(int i=0; i<N-K+1; i++) {
			check(i, i+K-1);		//i��° �������� ������ i+K-1��° ���������� ���
		}
		System.out.printf("%.11f",min);	//�ּҰ� ���
	}
	
	public static void check(int start, int end) {		//���� ���պ��� ǥ������ ���ϴ� �Լ�
		double deviation = Math.sqrt(dispersion(start, end));	//�л� ���Ϲ��� ���� ��Ʈ ���찡
		min = Math.min(min, deviation);	//�� ���� �� min�� ����
		if(end<N-1) check(start, end+1);	//���� end���� ���� ������ �ƴ� ��� ���� �ϳ� �� �����ؼ� �õ��غ�
	}
	
	public static double dispersion(int start, int end) {	//�л� �����ϴ� �Լ�
		int sum = 0;
		double boonsan = 0;
		for(int i= start; i<=end; i++) {
			sum += dolls[i];
		}//////////////////////////////////////////���� ����
		double average = (double)sum/(end-start+1);	//���� ���
		for(int i= start; i<=end; i++) {	//�л� ���ϱ�
			double tmp = dolls[i] - average;
			boonsan += Math.pow(tmp, 2);
		}
		return (double)boonsan/(end-start+1);	//�л� ����
	}
}
