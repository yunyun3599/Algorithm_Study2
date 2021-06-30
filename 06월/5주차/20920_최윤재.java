package tmp;
import java.util.*;
import java.io.*;

public class _20920_������_���ܾ�ϱ�¾���� {

	static int N;
	static int M;
	static HashMap<String, Integer> map = new HashMap<>();	//�ܾ� �̸��� key��, ���� ������ value��
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			String word = br.readLine();	//�ܾ� �Է¹���
			if(word.length()<M) continue;	//�ʹ� ª�� ��� �׳� �ѱ��
			if(!map.containsKey(word)) {	//ó�� ������ �ܾ��� ���
				map.put(word, 1);	//�ش� �ܾ Ű���ϰ� ���� 1���ϴ� �� put
			}
			else {		//�̹� map �ȿ� �����ϴ� ���
				int value = map.get(word);	//�ش� �ܾ��� �� �����ͼ� �� ������ 1 Ű���� �ֱ�
				map.put(word, value+1);
			}
		}
		List<Map.Entry<String, Integer>> words = new ArrayList<>(map.entrySet());	//������ ���� List�� �ٲ�
		Collections.sort(words, new Comparator<Map.Entry<String, Integer>>(){	//comparator �պ��� ���ǿ� �µ��� ����
			public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
				int val2 = obj2.getValue();
				int val1 = obj1.getValue();
				if(val1 == val2) {		//������ �󵵰� ���� ���
					String key1 = obj1.getKey();
					String key2 = obj2.getKey();
					if(key1.length() == key2.length()) return key1.compareTo(key2);	//���̵� ������ ������
					else return key2.length() - key1.length();	//���̰� �ٸ��� ���̰� �� �� ����
				}
				else return val2 - val1;	//���� ���� ���� �� ������ ������
			}
		});
		for(Map.Entry<String, Integer> word : words) {	//������� ���
			bw.write(word.getKey());
			bw.write("\n");
		}
		bw.flush();
	}
}
