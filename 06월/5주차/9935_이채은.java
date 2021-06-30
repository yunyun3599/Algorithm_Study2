import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        int Ssize = str.length(); int Bsize = bomb.length();
        Stack<Character> ans = new Stack<>();
        for(int i=0; i<Ssize; i++) {
        	if(str.charAt(i) != bomb.charAt(Bsize-1)) ans.push(str.charAt(i));
        	else {
        		boolean flag = true;
        		int idx = Bsize-2;
        		Stack<Character> tmp = new Stack<>();
        		tmp.add(str.charAt(i));
        		while(!ans.isEmpty() && idx>=0) {
        			if(ans.peek() != bomb.charAt(idx)) {
        				flag = false; break;
        			}
        			tmp.add(ans.pop());
        			idx--;
        		}
        		if(!flag || idx>=0) {
        			while(!tmp.isEmpty())
        				ans.push(tmp.pop());
        		}
        	}
        }
        
        if(ans.isEmpty()) System.out.println("FRULA");
        else {
        	StringBuilder sb = new StringBuilder("");
        	while(!ans.isEmpty())
        		sb.append(ans.pop());
        	System.out.println(sb.reverse().toString());
        }
    }
}
