import java.util.*;
import java.awt.Point;

public class _2551_물통 {
	
	static Queue<Point> q = new LinkedList<>();
	static boolean[][] visit = new boolean[201][201];
	
	static void move(int x, int y, boolean[][] visit, Queue<Point> q) {
		if(!visit[x][y]) {
			visit[x][y] = true;
			q.add(new Point(x,y));
		}
	}
	
	static void bfs(int a, int b, int c) {
		PriorityQueue<Integer> ans = new PriorityQueue<>();
		q.add(new Point(0,0));
		visit[0][0] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			int x = cur.x, y = cur.y, z = c-x-y;
			if(x==0) ans.add(z);
		
		
			int w = Math.min(z, a-x);
			move(x+w, y, visit, q);//z->x
			
			w = Math.min(z, b-y);
			move(x, y+w, visit, q);//z->y
			
			w = Math.min(x, b-y);
			move(x-w, y+w, visit, q);//x->y
			
			w = Math.min(x, c-z);
			move(x-w, y, visit, q);//x->z
			
			w = Math.min(y, c-z);
			move(x, y-w, visit, q);//y->z
			
			w = Math.min(y, a-x);
			move(x+w, y-w, visit, q);//y->x	
		}
		StringBuilder sb = new StringBuilder();
		while(!ans.isEmpty()) sb.append(ans.poll()+" ");
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt(); 
		int c = sc.nextInt();
		bfs(a,b,c);
	}

}
