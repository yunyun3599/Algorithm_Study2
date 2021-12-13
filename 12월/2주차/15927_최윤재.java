import java.util.*;
public class _15927_최윤재_회문은회문아니야 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int left = 0;	//왼쪽 인덱스 
		int right = input.length()-1;	//오른쪽 인덱스 
		char usedChar = input.charAt(0);	//모두 같은 문자인지 확인용 
		boolean allSameChar = true;	//모두 같은 문자라고 가정하고 시작 
		while(left <= right) {	//문자열의 가운데까지 확인 
			char leftchar = input.charAt(left);
			char rightchar = input.charAt(right);
			if(leftchar != usedChar || rightchar != usedChar) allSameChar = false;	//문자열이 모든 같은 문자가 아닌 경우 
			if(leftchar != rightchar) break;	//전체 문자열이 회문이 아님 
			left++; right--;
		}
		if(left < right) System.out.println(input.length());	//전체 문자열이 회문이 아닌 경우 
		else {	//전체 문자열이 회문인 경우 
			if(allSameChar) System.out.println(-1);	//모두 같은 문자로 이루어 진 경우 
			else System.out.println(input.length() - 1);	//전체가 회문이면 전체에서 마지막 char 빼면 회문 아님 
		}
	}

}
