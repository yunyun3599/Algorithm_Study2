package tmp;
import java.util.*;
import java.util.regex.Pattern;
public class _2671_최윤재_잠수함식별 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String pattern = "(100+1+|01)+";		//잠수함 확인하는 정규식
		if(Pattern.matches(pattern, input)) 	//위의 정규식을 만족하는지 확인
			System.out.println("SUBMARINE");
		else System.out.println("NOISE");
	}
}
