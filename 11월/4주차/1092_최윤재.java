import java.io.*;
import java.util.*;
 
public class _1092_최윤재_배 {
    
	static int N;
	static int M;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> crane = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N ; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }
        
        M = Integer.parseInt(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
        	box.add(Integer.parseInt(st.nextToken()));
        }
        ///////////입력
        
        Collections.sort(crane, Collections.reverseOrder());	//무거운 것 부터 정렬 
        Collections.sort(box, Collections.reverseOrder());
        
        if(crane.get(0) < box.get(0)) {	//불가능 한 경우 (크레인이 감당 가능한 최대 하중보다 박스의 무게가 무거운 경우)
        	System.out.println("-1");
        	System.exit(0);
        }
        int minute = 0;	//걸린 시간 
        while(!box.isEmpty()) {	//박스가 다 처리될 때 까지 반복 
            int boxidx = 0;	//처리할 박스의 idx
            for(int i = 0; i < N;) { //몇번째 크레인인지 
                if(boxidx == box.size()) break;	//박스 idx가 끝에 도달하면 종료 
                else if(crane.get(i) >= box.get(boxidx)) {	//들 수 있는 경우 다음 크레인으로 넘어감 
                    box.remove(boxidx);
                    i++;
                }
                else boxidx++;	//들 수 없는 경우 더 가벼운 박스로 넘어감 
            }
            minute++;	//시간 증
        }
        System.out.println(minute);
    }
}   