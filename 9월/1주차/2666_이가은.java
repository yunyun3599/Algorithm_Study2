import java.io.*;

public class _2666_벽장문의이동 {
	
	static int[] b;
	static int n, ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		
		String[] input = br.readLine().split(" ");
		int open1 = Integer.parseInt(input[0]); //최초 열린칸의 위치 저장
		int open2 = Integer.parseInt(input[1]); //최초 열린칸의 위치 저장
		
		n = Integer.parseInt(br.readLine());
		b = new int[n];
		for(int i=0; i<n; i++) {
			b[i] = Integer.parseInt(br.readLine());
		}
		go(open1, open2, 0, 0);
		System.out.println(ans);
	}
	static void go(int open1, int open2, int depth, int move) {
		if(depth == n) {
			if(move < ans) ans = move;
			return;
		}
		int tmp1 = Math.abs(open1 - b[depth]);
		int tmp2 = Math.abs(open2 - b[depth]);
		go(open1, b[depth], depth+1, move+tmp2); //open2를 움직이는 경우 
		go(b[depth], open2, depth+1, move+tmp1); //open1을 움직이는 경우 
	}
}
