import java.util.*;
public class _1300_최윤재_K번째수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();
		int left = 0;
		int right = k;	//값이 2개씩 있는 것이 있으므로 k번째 인덱스의 수는 무조건 k보다 작음
		while(left < right) {	//이분탐색 
			int mid = (left + right) / 2;
			int idx = 0;	//mid의 인덱스 
			for(int i=1; i<=N; i++) {	//1번행부터 더 작은 수를 구해서 idx에 더함 
				idx += Math.min(N, mid/i);	//특정 칸의 수는 i행 j열일 때 i*j값이므로 mid값을 해당 행으로 나눴을 때 나오는 것이 그 수보다 작은 열의 개수
			}
			if(idx < k) left = mid+1;	//mid보다 작을 때 
			else right = mid;	//mid보다 클 때 
		}
		System.out.println(left);
	}

}
