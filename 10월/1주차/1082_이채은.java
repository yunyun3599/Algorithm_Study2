import java.util.*;

public class Main {
	static int N, M, idx, min = 51;
	static int cost[];
	static char ans[];
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cost = new int[N];
        for (int i = 0; i < N; i++) {
            cost[i] = sc.nextInt();
            if (min >= cost[i]) {
                min = cost[i];
                idx = i;
            }
        }
        M = sc.nextInt();
        
        ans = new char[51];
        int cnt = 0, start = 0;
        while (M >= min) {
            ans[cnt++] = (char)(idx + '0');
            M -= min;
        }
 
        for (int i = 0; i < cnt; i++) {
            for (int j = N - 1; j >= 0; j--) {
                if (cost[j] <= M + min) {
                    ans[i] = (char) (j + '0');
                    M += min - cost[j];
                    break;
                }
            }
 
            if (ans[start] == '0') {
                start++;
                M += min;
            }
        }
 
        if (start == cnt)
        	System.out.println(0);
        else {
        	for(int i=start; i<cnt; i++)
        		System.out.print(ans[i]);
        }
        sc.close();
    }
 
}
