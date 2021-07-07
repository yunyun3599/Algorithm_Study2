import java.io.*;
import java.util.*;

class Student implements Comparable<Student>{
	int like, number, time;
	public Student(int number, int time) {
		this.number = number; this.time = time;
		like = 1;
	}
	@Override
	public int compareTo(Student o) {
		if(this.like != o.like) return this.like - o.like; //추천수 작은순 
		else return this.time - o.time; //오래된 순(더빠른시간 순)
	}
}

public class _1713 {
	
	static List<Student> frame = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
		int N = Integer.parseInt(br.readLine());
		int ppl = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < ppl; i++) {
			int s = Integer.parseInt(st.nextToken());
			Student candidate;
			if((candidate = isUp(s)) != null) { //중복체크 먼저하기: 처음부터 같은 애가 여러번 추천되는 경우 중복되어 리스트에 추가되므로
				candidate.like++;
			}
			else{
				if(frame.size() >= N) {
					Collections.sort(frame);
					frame.remove(0);
				}
				frame.add(new Student(s, i));
			}
		}
		
		int f = frame.size(); //frame size =/= N일수도 있음
		int[] ans = new int[f];
		for(int i = 0; i < f; i++) ans[i] = frame.get(i).number;

		Arrays.sort(ans);
		for(int i = 0; i < f; i++) bw.write(ans[i]+" ");
		
		bw.flush();
		bw.close();
	}
	
	static Student isUp(int num) { //frame에 걸려있는 학생이면 걔 리턴, 아니면 null 리턴
		for(Student s : frame) {
			if(s.number == num) return s;
		}
		return null;
	}

}
