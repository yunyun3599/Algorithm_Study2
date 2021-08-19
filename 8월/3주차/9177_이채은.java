import java.io.*;
import java.util.*;

public class Main {
	static char[] s1, s2, s3;
	static int l1, l2, l3, N;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int t = 1; t <= N; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			s1 = stk.nextToken().toCharArray();
			s2 = stk.nextToken().toCharArray();
			s3 = stk.nextToken().toCharArray();
			l1 = s1.length;
			l2 = s2.length;
			l3 = l1 + l2;
			flag = false;

			Set<Character> set = new HashSet<>();
			for (int i = 0; i < Math.max(l1, l2); i++) {
				if(i < l1) set.add(s1[i]);
				if(i < l2) set.add(s2[i]);
			}
			boolean chk = true;
			for (int i = 0; i < l3; i++) {
				if (!set.contains(s3[i])) {
					chk = false; break;
				}
			}
			
			if (!chk) {
				System.out.println("Data set " + t + ": no");
				continue;
			}

			find(0, 0, 0);
			System.out.println("Data set " + t + ": " + (flag? "yes":"no"));
		}
	}

	private static void find(int idx1, int idx2, int cnt) {
		if(flag) return; 
		
		if (idx1 + idx2 == l3) {
			flag = true; return;
		}

		if (idx1 < l1 && s3[cnt] == s1[idx1])
			find(idx1 + 1, idx2, cnt + 1);
		
		if (idx2 < l2 && s3[cnt] == s2[idx2])
			find(idx1, idx2 + 1, cnt + 1);
	}
}
