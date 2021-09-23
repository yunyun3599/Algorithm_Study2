import java.io.*;
import java.util.*;

class Town implements Comparable<Town> {
	int pos, num;
	public Town(int pos, int num) {
		this.pos = pos;
		this.num = num;
	}
	@Override
	public int compareTo(Town o) {
		//(1)위치순 (2)인구순으로 정렬 
		if(pos == o.pos) return o.num - num;
		else return pos - o.pos;
	}
}

public class _2141_우체국 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int total = 0;
		Town[] town = new Town[N];
		
		for(int i=0; i<N; i++) {
			String[] l = br.readLine().split(" ");
			int pos = Integer.parseInt(l[0]);
			int ppl = Integer.parseInt(l[1]);
			town[i] = new Town(pos, ppl);
			total += ppl;
		}
		Arrays.sort(town); //정렬
		
		long sum = 0;
		//우체국을 세워야하는 지점 = 양쪽 인구수가 제일 비슷한 지점이므로 처음으로 반절넘을 때 출력 
		for(Town t : town) {
			sum += t.num;
			if(sum >= (total+1)/2) {
				System.out.println(t.pos);
				break;
			}
		}	
		
	}
}
