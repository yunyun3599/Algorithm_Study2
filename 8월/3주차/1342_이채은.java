import java.util.*;

public class Main{
    static char[] input, str;
    static boolean[] visit;
    static int size, ans;
    static int alphabet[] = new int[26];
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        input = sc.next().toCharArray();
        for(char c:input)
        	alphabet[c-'a']++;
        size = input.length;
        str = new char[size];
        visit = new boolean[size];
        findLucky(0);
        for(int i:alphabet) {
        	if(i==0 || i==1) continue;
        	ans/=factorial(i);
        }
        System.out.println(ans);
        sc.close();
    }
    
    public static void findLucky(int cnt){
        if(cnt == size){
            for(int i=1; i<size; i++)
                if(str[i]==str[i-1]) return;
            ans++;
            return;
        }
        for(int i=0; i<size; i++){
            if(!visit[i]){
                visit[i] = true;
                str[cnt] = input[i];
                findLucky(cnt+1);
                visit[i] = false;
            }
        }
    }
    
    public static int factorial(int num) {
    	int ans = 1;
    	for(int i=1; i<=num; ans*=i++);
    	return ans;
    }
}
