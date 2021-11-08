import java.io.*;
import java.util.*;

public class _14391_최윤재_종이조각 {

	static int N;
	static int M;
	static int[][] paper;
	static boolean[][] visited;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		paper = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				paper[i][j] = row.charAt(j) - '0';
			}
		}
		calc(0,0,0);
		System.out.println(max);
	}

	public static void calc(int row, int col, int sum) {
		if(row==N) {
			max = Math.max(sum, max);
			return;
		}
		if(visited[row][col]) {
			int nextrow = row + (col+1)/M;
			int nextcol = (col+1)%M;
			calc(nextrow, nextcol, sum);
			return;
		}
		for (int i = 0; i < N - row; i++) {
			int num = 0;
			for (int j = 0; j <= i; j++) {
				num = num * 10 + paper[row + j][col];
				visited[row + j][col] = true;
			}
			int nextrow = row + (col+1)/M;
			int nextcol = (col+1)%M;
			//System.out.println("row, col, sum, num: "+row+", "+col+", "+sum+", "+num);
			calc(nextrow, nextcol, sum+num);
		}
		for (int i = 1; i < N - row; i++) {
			visited[row+i][col] = false;
		}
		int i=1;
		for (i = 1; i < M - col; i++) {
			int num = 0;
			int j=0;
			if(visited[row][col+i]) break;
			for (j = 0; j <= i; j++) {
				num = num * 10 + paper[row][col+j];
				visited[row][col+j] = true;
			}
			int nextrow = row + (col+j)/M;
			int nextcol = (col+j)%M;
			//System.out.println("row, col, sum, num: "+row+", "+col+", "+sum+", "+num);
			calc(nextrow, nextcol, sum+num);
		}
		for (int k = 0; k < i; k++) {
			visited[row][col+k] = false;
		}
	}

}
