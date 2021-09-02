package tmp;
import java.util.*;
import java.io.*;

public class _2212_������_���� {

	static int N;
	static int K;
	static int[] sensor;	//���� ��ġ
	static int[] dist;	//�� ������ �Ÿ�
	static int result;	//���� ���
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		sensor = new int[N];
		dist = new int[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) sensor[i] = Integer.parseInt(st.nextToken());	//�Է�
		Arrays.sort(sensor);	//���� ��ġ ������� ����
		for(int i=0; i<N-1; i++) 	//������ �Ÿ� �� ����
			dist[i] = sensor[i+1] - sensor[i];
		Arrays.sort(dist);	//������ �Ÿ� ���� ����
		for(int i=0; i<N-K; i++) {	//���� �������� ������ ������ ������ ���� ��ŭ�� �� �Ÿ��� �����ؾ���
			result += dist[i];	//�Ÿ��� ª�� ������ ����� ���ϱ�
		}
		System.out.println(result);
	}
}
