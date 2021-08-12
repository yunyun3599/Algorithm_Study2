package tmp;
import java.util.*;
import java.io.*;

public class _17779_������_�Ը��Ǵ���2 {

	static int N;
	static int map[][];
	static int min = Integer.MAX_VALUE;
	static int total;		//��� �α��� ��
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				total += map[i][j];
			}
		}
		/////////////////////////////////////////////////�Է�
		for(int x=0; x<N; x++) {		//(x,y)�� ���� ������
			for(int y=0; y<N; y++) {
				for(int d1 = 1; d1<N; d1++) {	//d1�� d2 ������ ��츦 ��� �غ�
					for(int d2=1; d2<N; d2++) {
						if(x+d1+d2<N && y-d1>=0 && y+d2<N) divide(x,y,d1,d2);	//���� ������ ���ű� ����
					}
				}
			}
		}
		System.out.println(min);
	}
	public static void divide(int x, int y, int d1, int d2) {	//���ű� �����ϴ� �Լ�
        int[] population = new int[5];	//�� ������ �α��� ��


        for (int i = 0; i < x + d1; i++) {	//1���ű�
        	int end = y;	//x��ǥ ������ �κ� ���
        	if(i>=x) end = y-(i-x+1);
            for (int j = 0; j <= end; j++) {
                population[0] += map[i][j];
            }
        }

        for (int i = 0; i <= x + d2; i++) {	//2���ű�
        	int start = y+1;
        	if(i>x) start = start+(i-x);	//x��ǥ �����ϴ� �κ� ���
            for (int j = start; j <N ; j++) {
                population[1] += map[i][j];
            }
        }

        int k=0;
        for (int i = x + d1; i < N; i++) {	//3���ű�
        	int end = y-d1+d2;
        	if(i < x+d1+d2) end = y-d1+k++;	//x��ǥ ������ �κ� ���
            for (int j = 0; j < end; j++) {
                population[2] += map[i][j];
            }
        }

        k=0;
        for (int i = x + d2 + 1; i < N; i++) {	//4���ű�
        	int start = y-d1+d2;
        	if(i<=x+d1+d2) start = y+d2+k--;	//x��ǥ �����ϴ� �κ� ���
            for (int j = start; j<N; j++) {
                population[3] += map[i][j];
            }
        }
        population[4] = total-population[0]-population[1]-population[2]-population[3];	//�� �α������� �� ���ű� �α��� ���� 5���ű� �α���
        Arrays.sort(population);	//�α������ ����
        min = Math.min(min, population[4] - population[0]);	//���� �ּڰ� ������Ʈ
    }

}
