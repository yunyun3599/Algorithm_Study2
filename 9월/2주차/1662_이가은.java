import java.io.*;
import java.util.Stack;

public class _1662_압축 {
	
	static char[] s;
	static int[] close;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stk = new Stack<>();
		s = br.readLine().toCharArray();
		close = new int[s.length];
		
		for(int i=0; i<s.length; i++) {
			if(s[i]=='(') stk.push(i);
			else if(s[i] ==')') close[stk.pop()] = i; //여는 괄호에 대한 닫는 괄호위치 저장
		}
		
		System.out.println(unzip(0, s.length));
	}
  //재귀
	static int unzip(int start, int end) {
		int len = 0;
		for(int i=start; i<end; i++) {
			if(s[i] == '(') {
				len += (s[i-1]-'0') * unzip(i+1, close[i]) - 1;
				i = close[i];
			}
			else {
				len++;
			}
		}
		return len;
	}

}
