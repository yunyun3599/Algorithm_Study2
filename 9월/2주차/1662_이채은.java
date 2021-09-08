import java.util.*;

public class Main{
    static int ans, len;
    static char[] S;
    static boolean[] visit;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        S = sc.next().toCharArray();
        len = S.length;
        visit = new boolean[len];
        System.out.println(calc(0));
        sc.close();
    }
    
    public static int calc(int idx){
        int cnt = 0;
        for(int i=idx; i<len; i++){
            if(visit[i]) continue;
            if(S[i] == '(') {
                visit[i] = true;
                int num = S[i-1]-'0';
                cnt--;
                cnt += num * calc(i+1);
            } else if(S[i] == ')') {
                visit[i] = true;
                return cnt;
            } else {
                visit[i] = true;
                cnt++;
            }
        }
        return cnt;
    }
}
