import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class _20920 {
	public static void main(String[] args) throws IOException {
		//TreeMap: HashMap과 다르게 내부적으로 RB tree를 이용해 key를 기준으로 정렬된다
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();  
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		// 입력이 들어오면 맵에 단어-개수 쌍으로 저장 
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			int len = s.length();
			if(len >= m) {
				if(map.containsKey(s)) map.replace(s, map.get(s)+1);
				else map.put(s, 1);
			}
		}
		// 정렬하기: 엔트리 리스트를 만들어 리스트를 정렬, 람다표현식 사용
		List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
		Collections.sort(entries, (o1, o2) -> {
			if(o1.getValue() != o2.getValue()) return o2.getValue() - o1.getValue();
			else if(o1.getKey().length() != o2.getKey().length()) return o2.getKey().length() - o1.getKey().length();
			else return o1.getKey().compareTo(o2.getKey()); 
			});
		// 정렬이 끝나면 순서대로 sb에 쌓고 출력
		for (Entry<String, Integer> entry : entries) sb.append(entry.getKey()+"\n");
		System.out.println();
		System.out.println(sb.toString());

	}

}
