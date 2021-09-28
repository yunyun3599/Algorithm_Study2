import java.io.*;
import java.util.*;
import java.awt.Point;

public class _12886_돌그룹 {
	
	static boolean[][] visit = new boolean[1501][1501];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(a,b,c));
	}
	static int bfs(int a, int b, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(a,b));
		visit[a][b] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x, y = p.y, z = a+b+c-x-y;
				
			if(x == y && y == z) return 1;
				
			if(x > y) move(x-y, y+y, q); 
			if(x < y) move(x+x, y-x, q);
			if(z > y) move(x, y+y, q); 
			if(z < y) move(x, y-z, q);
			if(x > z) move(x-z, y, q); 
			if(x < z) move(x+x, y, q);
		}
		return 0;
	}
	static void move(int x, int y, Queue<Point> q) {
		if(!visit[x][y]) {
			visit[x][y] = true;
			q.add(new Point(x,y));
		}
	}

}
