import java.io.*;

public class _9935 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String bomb = br.readLine();
		char[] res = new char[s.length()];
		int idx = 0; //res의 인덱스를 나타내기위한 인덱스 
		
		for(int i = 0; i < s.length(); i++) { //s 한 문자씩 돌며 확인
			res[idx] = s.charAt(i);
			if(isBomb(res, idx, bomb)) idx -= bomb.length(); //bomb의 길이만큼을 res에 추가하지 않을거니 
			idx++;
		}
		
		String ans = String.valueOf(res, 0, idx); //어떤 값이라도 String 문자열로 만들어주는 메소드. 배열 경우: (start,end)까지만 변환
		System.out.println(ans.length() > 0 ? ans : "FRULA");
	}
	
	static boolean isBomb(char[] c, int idx, String bomb) {
		if(idx < bomb.length() - 1 ) return false;
		
		for(int i = 0; i <  bomb.length(); i++) {
			if(c[i + idx - bomb.length() + 1] != bomb.charAt(i)) return false;
		}
		return true;
	}

}
