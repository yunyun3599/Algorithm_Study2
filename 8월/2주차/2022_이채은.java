import java.util.*;

public class Main{
    static double x, y, c;
    public static double search(double mid){
        double h1 = Math.sqrt(x*x - mid*mid);
        double h2 = Math.sqrt(y*y - mid*mid);
        
        return (h1*h2)/(h1+h2);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        x = sc.nextDouble();
        y = sc.nextDouble();
        c = sc.nextDouble();
        
        double low = 0, high = Math.min(x, y), res = 0;
        while(high-low>0.000001){
            double mid = (low+high)/2.0;
            if(search(mid)>=c){
                res = mid;
                low = mid;
            }
            else
                high = mid;
        }
        
        System.out.println(String.format("%.3f", res));
        sc.close();
    }
}
