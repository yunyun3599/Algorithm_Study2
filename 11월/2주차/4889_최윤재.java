import java.io.*;
import java.util.*;
public class _4889_최윤재_안정적인문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = 1;
		String input = br.readLine();
		StringBuilder result = new StringBuilder();
		
		while(input.charAt(0)!='-') {		//----가 입력으로 들어올 때까지 반
			Stack<Integer> stack = new Stack<>();	//스택 이용 
			int change = 0;		//바꿔야하는 괄호 개
			for(int i=0; i<input.length(); i++) {	//하나하나에 대해 확인 
				if(input.charAt(i)=='{') {	//여는 괄호면 stack에 넣기 
					stack.push(1);
				}
				else {
					if(stack.isEmpty()) {	//닫는 괄호인데 stack이 비어있는 경우(여는 괄호 쌍이 없는 경우)
						change++;	//해당 괄호의 방향을 바꿔서 여는 괄호로 만든 후 stack에 넣음 
						stack.push(1);
					}
					else stack.pop();	//닫는 괄호인데 여는 괄호 쌍이 존재하는 경우 
				}
			}
			change += stack.size()/2;	//stack에 남은 여는 괄호의 개수에서 반의 방향을 바꾸기 
			result.append((testcase++) + ". "+change+"\n");	//결과 append
			input = br.readLine();	//다음 케이
		}
		System.out.println(result);
	}

}
