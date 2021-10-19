import java.util.*;

public class Main{
    static int N, M, L;
    static int pos[];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        L = sc.nextInt();
        pos = new int[N+2];
        for(int i=0; i<N; i++)
            pos[i] = sc.nextInt();
        pos[N] = 0; pos[N+1] = L;
        Arrays.sort(pos);
        
        int l=1, r=L;
        while(l<=r) {
            int mid = (l+r)/2;
            if(can_make(mid)) l = mid+1;
            else r = mid-1;
        }
        System.out.println(l);
        sc.close();
    }
 
    public static boolean can_make(int mid){
        int cnt = 0;
        for(int i=1; i<N+2; i++) {
            cnt += (pos[i]-pos[i-1]-1)/mid;
        }
        if(cnt > M) return true;
        return false;
    }
}
