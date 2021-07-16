package tmp;
import java.util.*;
import java.io.*;

public class _11054_������_����������м��� {
	
	static int N;
	static int[] input;
	static int asc_dp_val[];	//�� �ε����� ������ ���� �κ� ���� ���� ���� {1,2,3,2,1}�̸� {1,2,3,3,3}����� ��
	static int desc_dp_val[];	//�� �ε����� ������ ���� �κ� ���� ���� ���� {1,2,3,2,1,}�̸� {3,3,3,2,1}����� ��
	static ArrayList<Integer> asc_dp = new ArrayList<>();	//ascending ó���� ���� �� ����
	static ArrayList<Integer> desc_dp = new ArrayList<>();	//descending ó���� ���� �� ����
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		asc_dp_val = new int[N];
		desc_dp_val = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) input[i] = Integer.parseInt(st.nextToken());	//�Է�
		
		asc_dp_val[0] = 1;	//asc�� �տ������� dp�� ����
		desc_dp_val[N-1] = 1;	//desc�� �ڿ������� asc�ΰ�ó�� dp�� ����
		asc_dp.add(input[0]);	//��â ó�� ���� �־�α�
		desc_dp.add(input[N-1]);
		for(int i=0; i<N; i++) {
			
			int asc_idx = binary_search(input[i], true);	//binary search�� �̿��� ���� Ž���ϴ� ���� asc_dp Ȥ�� desc_dp �� ����� ���� ���� �������� idx ����
			int desc_idx = binary_search(input[N-i-1], false);
			
			if(asc_dp.get(asc_idx) >= input[i]) asc_dp.set(asc_idx, input[i]);	//���� ���� �߰��� �ִ� ���� ��ü�ϴ� ��� (10, 20, 40, 50)�� �־��µ� �̹� ���� 30�̸� idx�� 2�� ��ȯ�ǰ� (10, 20, 30, 50)�� ��
			else if(asc_idx==asc_dp.size()-1) asc_dp.add(input[i]);	//���� ���� ������ ������ �� ū ��� (10,20,30)�� �־��µ� 40�� ������ asc_dp���� (10,20,30,40)�� ��
			asc_dp_val[i] = asc_dp.size();
			
			if(desc_dp.get(desc_idx) >= input[N-i-1]) desc_dp.set(desc_idx, input[N-i-1]);	//desc�� ��쵵 input�� �ڿ������� Ȯ���ϸ� asc�� �����ϰ� ����
			else if(desc_idx==desc_dp.size()-1) desc_dp.add(input[N-i-1]);
			desc_dp_val[N-i-1] = desc_dp.size();
		}
		int result = 0;
		for(int i=0; i<N; i++) {	//asc_dp_val�� desc_dp_val���� ���� �Ϳ��� 1 �� ���� �ش� ����  asc�� ������ desc�� ������ ���� ����� ������� �κм��� ��. (asc�� desc���� �ش� �� �ι� ���ǹǷ� 1 ������)
			result = Math.max(result, asc_dp_val[i]+desc_dp_val[i]);
		}
		System.out.println(result-1);
		
	}
	public static int binary_search(int num, boolean asc) {	//�̺�Ž�� asc���� ���� �޾ƿͼ� �ٸ� dp�迭 �� ���Ḯ��Ʈ �̿�
		int low = 0;
		if(asc) {
			int high = asc_dp.size()-1;
			int mid = (low+high)/2;
			while(low<high) {
				if(num==asc_dp.get(mid)) {
					return mid;
				}
				else if(num>asc_dp.get(mid)) {
					low = mid+1;
				}
				else {
					high=mid;
				}
				mid = (low+high)/2;
			}
		}
		else {
			int high = desc_dp.size()-1;
			int mid = (low+high)/2;
			while(low<high) {
				if(num==desc_dp.get(mid)) {
					return mid;
				}
				else if(num>desc_dp.get(mid)) {
					low = mid+1;
				}
				else {
					high=mid;
				}
				mid = (low+high)/2;
			}
		}
		return low;
	}

}






