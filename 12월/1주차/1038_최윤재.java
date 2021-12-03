import java.util.*;
public class _1038_최윤재_감소하는수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Long> list = new ArrayList<>();	//감소하는 수를 저장할 리스트
		for(long i=0; i<=9; i++) {	//첫 자리가 i인 것
			ArrayList<Long> addList = new ArrayList<>();	//이번에 추가될 수를 저장할 리스트 
			for(long num : list) {	//앞에서 구한 감소하는 수 (i보다 작은 수로 시작하는 감소하는 수들)
				long newNum = Long.parseLong(i+""+num);	//앞에 i를 붙여줌 
				addList.add(newNum);
			}
			list.add(i);	//i도 저장 
			list.addAll(addList);	//구한 수들 저장 
		}
		Collections.sort(list);	//정렬 
		if(N < list.size()) {	//감소하는 숫자 총 개수 내에 있는 경우 
			System.out.println(list.get(N));
		} else {
			System.out.println(-1);
		}
	}
}
