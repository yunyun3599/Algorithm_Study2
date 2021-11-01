import java.util.*;
import java.io.*;
public class _2042_최윤재_구간합구하기 {

	public static long[] input;
	public static long[] tree;
	public static int N;
	public static int M;
	public static int K;
	public static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		input = new long[N];
		tree = new long[4*N];
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		init(0, N-1, 1);
		
		for(int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1) {
				long dif = c - input[b-1];
				input[b-1] = c;
				update(0, N-1, 1, b-1, dif);
			} else {
				result.append(getSum(0,N-1, 1, b-1, (int)c-1)+"\n");
			}
		}
		System.out.println(result);
	}

	public static long init(int start, int end, int node) {
		if(start == end) return tree[node] = input[start];
		int mid = (start + end) / 2;
		return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
	}
	//left, right가 원하는 구간합의 범위, start, end가 인덱스
	public static long getSum(int start, int end, int node, int left, int right) {
		if(left > end || right < start) return 0;	// 해당 노드가 구하고자 하는 범위 밖인 경우
		if(left <= start && end <= right) return tree[node];	//해당 노드가 구하고자 하는 범위 내에 모두 포함되는 경우
		int mid = (start + end) / 2;
		return getSum(start, mid, node*2, left, right) + getSum(mid+1, end, node*2+1, left, right);
	}
	public static void update(int start, int end, int node, int index, long dif) {
		if(index < start || index > end) return;
		tree[node] += dif;
		if(start==end) return;
		int mid = (start + end) / 2;
		update(start, mid, node*2, index, dif);
		update(mid+1, end, node*2+1, index, dif);
	}
}
