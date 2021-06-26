import java.io.*;

public class _16113 {
	
	static int width; 
	static String l;
	static StringBuilder sb = new StringBuilder("");

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		l = br.readLine();
		width = n / 5;
		
		int cnt = 0;
		for(int i = 0; i < width; i++) { // 제일 윗 줄에만 대해서 
			if(l.charAt(i) == '#') {
				cnt++; continue;
			}
			else {
				if(cnt == 3) check1(i-3);	//0,2,3,5,6,7,8,9인지 확인 
				else if(cnt == 1) {
					if(check2(i-1) == 4) i++;	 // 1,4인지 확인. 4이면 인덱스2만큼 앞으로 이동
				}
				cnt = 0;
			}
		}
		if(cnt == 3) check1(width-3); if(cnt == 1) check2(width-1);
		
		System.out.println(sb.toString());
	}
	
	static void check1(int idx) { 
		if(l.charAt(idx + width) == '#') { //0.8,9 |-|모양인 경우 
			if(l.charAt(idx + width +2) == '#') {	
				if(l.charAt(idx + width*2 + 1) == '.') sb.append("0");
				else if(l.charAt(idx + width*3) == '#') sb.append("8");
				else sb.append("9");
			}
			else { //5,6 |- 모양인 경우 
				if(l.charAt(idx + width*3) == '#') sb.append("6");
				else sb.append("5");
			}
	
		}//2,3,7 -|모양인 경우 
		else if(l.charAt(idx + width +2) == '#') { 
			if(l.charAt(idx + width*2) == '.') sb.append("7");
			else if(l.charAt(idx + width*3) == '#') sb.append("2");
			else sb.append("3");
		}
	}
	
	static int check2(int idx) {
		if(l.charAt(idx + width*4) == '#') {
			sb.append("1"); return 1;
		}
		else {
			sb.append("4"); return 4;
		}
	}

}
