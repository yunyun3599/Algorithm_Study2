import java.io.*;
import java.util.*;

class XY{
	long x, y;
	public XY(long x, long y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static long area(XY A, XY B, XY C) {  //신발끈 공식 이용
		long a = A.x * B.y + B.x * C.y + C.x * A.y;
		long b = A.y * B.x + B.y * C.x + C.y * A.x;
 		return a-b;  //벡터이용 - 방향이 중요하기 때문에, 여기에 절대값 씌우면 안되고
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		XY[] pos = new XY[N];
		long sum = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pos[i] = new XY(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 1; i < N-1; i++) {
			sum += area(pos[0], pos[i], pos[i+1]);
		}
		
		System.out.println(String.format("%.1f", Math.abs(sum)/2.0)); //전체 결과에 절대값 씌워야함
	}

}
