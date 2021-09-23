import java.io.*;
import java.util.*;

public class _15961_회전초밥 {
	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken()); //접시 수 
    	int d = Integer.parseInt(st.nextToken()); //초밥 가짓수 
    	int k = Integer.parseInt(st.nextToken()); //연속해 먹는 개수 
    	int c = Integer.parseInt(st.nextToken()); //coupon 번호 
    	int max = 0, cnt = 0;
    	
    	int[] arr = new int[N];
    	int[] visit = new int[d+1];
    	
    	for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
    	
    	//초기셋팅 - 일단 0번부터 k개 먹어보기 
    	for(int i = 0; i < k; i++) {
    		//먹었던 초밥이 아니면 count 증가 
    		if(visit[arr[i]] == 0) cnt++;
    		visit[arr[i]]++;
    	}
    	
    	for(int i = 1; i < N; i++) {
    		//max값 갱신
    		if(max <= cnt) {
    			if(visit[c] == 0) max = cnt+1;
    			else max = cnt;
    		}
    		//바로전에 먹었던거 뱉기 (단,뱉은 직후 0이되는 경우는 cnt에서 빼기)
    		visit[arr[i-1]]--;
    		if(visit[arr[i-1]] == 0) cnt--;
    		//다음 초밥 먹기 (단, 처음먹는 종류의 초밥일경우 cnt증가)
    		if(visit[arr[(i + k - 1) % N]] == 0) cnt++;
    		visit[arr[(i + k - 1) % N]]++;
    	}
    	
    	System.out.println(max);
	}

}

