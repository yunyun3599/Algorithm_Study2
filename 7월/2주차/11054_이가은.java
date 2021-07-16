import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] asc = new int[n];
		int[] desc = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		//가장 긴 증가하는 부분수열 
		for(int i=0; i<n; i++) {
			asc[i] = 1;
			for(int j=0; j<i; j++) {
				if(a[j] < a[i] && asc[i] < asc[j]+1) {
					asc[i] = asc[j]+1;
				}
			}
		}
		//가장 긴 감소하는 부분수열 
		for(int i=n-1; i>=0; i--) {
			desc[i] = 1;
			for(int j=n-1; j>i; j--) {
				if(a[j] < a[i] && desc[i] < desc[j]+1) {
					desc[i] = desc[j]+1;
				}
			}
		}
		int max = 0;
		for(int i = 0; i < n; i++) {
			max = Math.max(max, asc[i] + desc[i]);
		}
		System.out.println(max-1);
	}
}
