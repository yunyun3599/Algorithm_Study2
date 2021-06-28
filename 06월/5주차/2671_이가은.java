import java.util.Scanner;
import java.util.regex.*;

public class _2671 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		boolean check = Pattern.matches("(100+1+|01)+", str);
		System.out.println(check ? "SUBMARINE" : "NOISE");
	}
}
