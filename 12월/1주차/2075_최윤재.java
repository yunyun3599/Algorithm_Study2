package tmp;
import java.io.*;
import java.util.*;
public class _2075_������ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue pq = new PriorityQueue(Collections.reverseOrder());	//�Է°� �켱����ť�� ����
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
		}
		for(int i=1; i<N; i++) pq.poll(); //N��° ���� ���� ���� ��� poll
		System.out.println(pq.poll());

	}

}
