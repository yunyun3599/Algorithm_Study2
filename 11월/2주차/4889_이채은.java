import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        while(true){
            char[] str = sc.next().toCharArray();
            Stack<Character> stk = new Stack<>();
            int ans = 0;
            for(int i=0; i<str.length; i++){
                if(str[i]=='-') return;
                if(str[i]=='{') stk.push(str[i]);
                else if(stk.isEmpty()){
                    stk.push('{'); ans++;
                }
                else stk.pop();
            }
            ans += stk.size()/2;
            System.out.println(++cnt+". "+ans);
        }
    }
}
