import java.io.*;
import java.util.Arrays;

public class _16916_부분문자열 {
	
	static int[] table; //이동거리 저장하는 테이블 (이동거리 = 일치하는패턴의길이 - 최대공통부분의길이) 
	static String str, pattern;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		pattern = br.readLine();
		
		table = new int[pattern.length()];
		
		createTable();
		kmp();
	}
  //kmp 알고리즘
	static void kmp() {
		int j=0;
		for(int i=0; i<str.length(); i++) {
			while(str.charAt(i) != pattern.charAt(j) && j > 0) {
				j = table[j-1];
			}
			//일치하는 경우 
			if(str.charAt(i) == pattern.charAt(j)) {
				if(j == pattern.length()-1) {
					System.out.println(1);
					return;
				}
				else j++;
			}
		}
		System.out.println(0);	
	}
	static void createTable() {
		int j=0;
		for(int i=1; i<pattern.length(); i++) {
			while(pattern.charAt(i) != pattern.charAt(j) && j > 0) {
				j = table[j-1];
			}
			if(pattern.charAt(i) == pattern.charAt(j)) {
				//i길이 문자열의 공통부분의 길이 = j+1
				table[i] = ++j; 
			}
		}
	}

}
