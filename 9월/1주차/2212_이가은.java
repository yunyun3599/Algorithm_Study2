import java.io.*;
import java.util.*;

public class _2212_센서 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] dif = new int[n-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a); //1) 센서의 위치를 정렬한다.
		
		for(int i=1; i<n; i++) { //2) 간격 배열 dist[]를 만든다
			dif[i-1] = a[i] - a[i-1];
		}
		Arrays.sort(dif); //3) dist를 정렬한다.
		
		int sum = 0;
		for(int i=0; i<n-k; i++) { //4) 0 ~ (n-k)까지 dist의 합을 구한다.
			sum += dif[i];
		}
		System.out.println(sum);
		
	}
}
