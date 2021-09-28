package week4;

import java.io.*;
import java.util.*;

public class _1062_가르침 {
	
	static String[] lang; 
	static boolean[] visit;
	static int n, k, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		lang = new String[n];
		visit = new boolean[26];
		
		for(int i=0; i<n; i++) {
			lang[i] = br.readLine();
		}
		
		//무조건 배워야하는 단어 
		visit['a' - 'a'] = true;
		visit['n' - 'a'] = true;
		visit['t' - 'a'] = true;
		visit['i' - 'a'] = true;
		visit['c' - 'a'] = true;
		
		dfs(0, 0);
		System.out.println(ans);
	}
	static void dfs(int idx, int depth) {
		if(depth == k-5) {
			int cnt = 0;
			
			for(String word : lang) {
				boolean ok = true;
				for(int i=4; i < word.length()-4; i++) {
					if(!visit[word.charAt(i) - 'a']) {
						ok = false;
						break;
					}
				}
				if(ok) cnt++;
			}
			if(cnt > ans) ans = cnt;
			return;
			
		}
		for(int i=idx; i < 26; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i+1, depth+1);
				visit[i] =false;
			}
		}
	}

}
