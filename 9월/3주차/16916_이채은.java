import java.io.*;

public class Main{
    static char[] S, P;
    static int lenS, lenP;
    static int[] pi;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine().toCharArray();
        P = br.readLine().toCharArray();
        lenS = S.length; lenP = P.length;
        pi = new int[lenP];
        findPi();
        if(kmp()) System.out.println(1);
        else System.out.println(0);
    }
    
    public static void findPi(){
        int j = 0;
        for(int i=1; i<lenP; i++){
            while(j>0 && P[i] != P[j])
                j = pi[j-1];
            if(P[i]==P[j])
                pi[i] = ++j;
        }
    } //속도 감축 위해 접두사 - 접미사 배열 조사
    
    public static boolean kmp(){
        int j=0;
        for(int i=0; i<lenS; i++){
            while(j>0 && S[i] != P[j])
                j = pi[j-1];
            if(S[i]==P[j]){
                if(j==lenP-1){
                    j = pi[j];
                    return true;
                } else
                    j++;
            }
        }
        return false;
    }
} //kmp 알고리즘 사용
