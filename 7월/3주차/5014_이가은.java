import java.io.*;
import java.util.*;

public class _5104 {
	
	static int F,S,G,U,D;
	static int[] arr; //방문여부체크 및 i층까지 버튼횟수 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		F = Integer.parseInt(s[0]);
		S = Integer.parseInt(s[1]);
		G = Integer.parseInt(s[2]);
		U = Integer.parseInt(s[3]);
		D = Integer.parseInt(s[4]);
		arr = new int[F+1];
		System.out.println(bfs());
	}
	
	static String bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(S); 
		arr[S] = 1; //초기화 
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == G) return (arr[G]-1)+"";
			
			if(cur + U <= F) {
				if(arr[cur+U] == 0) { //범위 내에 있고 아직 방문하지 않았다면 큐에 삽입 
					arr[cur+U] = arr[cur] + 1;
					q.add(cur+U);
				}
			}
			if(cur - D > 0) {
				if(arr[cur-D] == 0) { //범위 내에 있고 아직 방문하지 않았다면 큐에 삽입 
					arr[cur-D] = arr[cur] + 1;
					q.add(cur-D);
				}
			}
		}
		return "use the stairs";
	}

}
