import java.util.*;
import java.io.*;

public class Main{
    public static int N;
    public static LinkedList<Integer> graph[];
    public static Queue<Integer> list = new LinkedList<>();
    public static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new LinkedList[N+1];
        visit = new boolean[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new LinkedList<>();
        }
        for(int i=0; i<N-2; i++){
            String[] tmp = br.readLine().split(" ");
            graph[Integer.parseInt(tmp[0])].add(Integer.parseInt(tmp[1]));
            graph[Integer.parseInt(tmp[1])].add(Integer.parseInt(tmp[0]));
        }
        
        list.add(1);
        visit[1] = true;
        while(!list.isEmpty()){
            int island = list.poll();
            for(int num:graph[island]){
                if(!visit[num]){
                    visit[num] = true;
                    list.add(num);
                }
            }
        }
        for(int i=2; i<=N; i++){
            if(!visit[i]){
                System.out.println(1+" "+i);
                break;
            }
        }
    }
}
