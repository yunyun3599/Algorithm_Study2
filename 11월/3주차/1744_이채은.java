import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer arr[] = new Integer[N];
        for(int i=0; i<N; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr, Collections.reverseOrder());
        
        int i = 0, ans = 0;
        boolean zero = false;

        while(i<N && arr[i]>1) {
        	if(i%2==1) ans += arr[i]*arr[i-1];
        	i++;
        }
        if(i<=N && i%2==1) ans += arr[i-1];
        for(; i<N && arr[i]>0; i++) ans += arr[i];
        if(i<N){
        	while(i<N && arr[i]==0) {
        		zero = true; i++;
        	}
            if(i<N && (N-i)%2 == 1) {
            	if(!zero) ans += arr[i];
            	i++;
            }
            for(int j=i; j<N-1; j+=2) {
                ans+=arr[j]*arr[j+1];
            }
        }
        
        System.out.println(ans);
    }
}
