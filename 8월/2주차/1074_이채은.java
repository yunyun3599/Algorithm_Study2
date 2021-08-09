import java.util.*;

public class Main{
    static int N, r, c;
    public static int search(int sr, int sc, int l){
        if(l<1) return 0;
        int ans = 0, area = l*l;
        if(r<sr+l && c<sc+l){
            return ans+=search(sr, sc, l/2);
        } else if(r<sr+l && c>=sc+l){
            ans+=area;
            return ans+=search(sr, sc+l, l/2);
        } else if(r>=sr+l && c<sc+l){
            ans+=area*2;
            return ans+=search(sr+l, sc, l/2);
        } else{
            ans+=area*3;
            return ans+=search(sr+l, sc+l, l/2);
        }
    }
  
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        System.out.println(search(0, 0, (int)Math.pow(2, N-1)));
        sc.close();
    }
}
