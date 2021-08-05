import java.util.*;

public class Main{
    static int cnt;
    static int flag;
    public static void restore(StringBuilder sb, String s){
        for(int i=0; i<4-s.length(); i++)
            sb.append("0");
        sb.append(s+":");
        cnt++;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String ip = sc.next();
        StringTokenizer stk = new StringTokenizer(ip, ":", true);
        StringBuilder front = new StringBuilder("");
        StringBuilder back = new StringBuilder("");
        while(stk.hasMoreTokens()){
        	String s = stk.nextToken();
        	if(s.equals(":")) {
        		flag++;
        		continue;
        	}
            if(flag<2) restore(front, s);
            else restore(back, s);
            if(flag==1) flag = 0;
        }
        
        for(int i=8-cnt; i>0; i--){
            for(int j=0; j<4; j++)
                front.append("0");
            front.append(":");
        }
        
        if(flag<2 || back.length()==0) front.deleteCharAt(front.length()-1);
        else back.deleteCharAt(back.length()-1);
        System.out.println(front.toString()+back.toString());
        sc.close();
    }
}
