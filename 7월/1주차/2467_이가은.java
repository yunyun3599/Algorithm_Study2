import java.io.*;
import java.awt.Point;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int left = 0, right = N-1, min = Integer.MAX_VALUE;
		Point p = new Point(left, right);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	
		while(left < right) {
			int sum = arr[left] + arr[right];
			
			if(Math.abs(sum) < min) {
				min = Math.abs(sum);
				p = new Point(left, right); //현재 값 저장 
			}
			
			if(sum < 0) left++;
			else right--;
		}
		
		System.out.println(arr[p.x]+" "+arr[p.y]);
	}

}
