import java.util.*;
public class _9252_최윤재_LCS2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] str1 = ("0" + sc.nextLine()).toCharArray();	//입력 
		char[] str2 = ("0" + sc.nextLine()).toCharArray();
		int[][] dp = new int[str2.length][str1.length];	//dp 
		
		for(int i=1; i<str2.length; i++) {	//동일 문자면 대각선 왼쪽 위 값 +1 아니면 왼쪽/위쪽 중 더 큰 값 그대로 
			for(int j=1; j<str1.length; j++) {
				if(str1[j] == str2[i]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		System.out.println(dp[str2.length-1][str1.length-1]);	//결과 출력 
		if(dp[str2.length-1][str1.length-1] != 0) {	//어떤 문자열인지 구해야하는 경우 
			System.out.println(getLongest(str1, dp));
		}
	}
	public static String getLongest(char[] str, int[][] dp) {
		Stack<Character> stack = new Stack();
		StringBuilder result = new StringBuilder();
		int row = dp.length-1;
		int column = dp[0].length-1;
		while(row != 0 && column != 0) {
			int cur = dp[row][column];
			if(cur != dp[row-1][column] && cur != dp[row][column-1] && cur == dp[row-1][column]+1) {	//왼쪽/위쪽이랑 같지 않으면서 대각선보다 하나 작은 경우 (공통 문자열에 해당) 
				stack.push(str[column]);
				column--; row--;
			} else {	//왼쪽이나 위쪽에서 그대로 온 경우 
				if(cur == dp[row-1][column]) row--;
				else column--;
			}
		}
		while(!stack.isEmpty()) {	//찾은 문자열 합하기 
			result.append(stack.pop());
		}
		return result.toString();
	}
}
