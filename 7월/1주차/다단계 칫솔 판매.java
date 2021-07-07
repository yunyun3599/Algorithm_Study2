import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Integer> search = new HashMap<String, Integer>();
        for(int i=0; i<enroll.length; i++){
            search.put(enroll[i], i);
        }
        
        for(int i=0; i<seller.length; i++){
            String s = seller[i]; int val = amount[i]*100;
            while(!s.equals("-")){
                int num = search.get(s);
                if(val < 10){
                    answer[num] += val;
                    break;
                }
                else{
                    if(val%10 != 0) answer[num]++;
                    answer[num] += val*9/10;
                    val/=10;
                }
                s = referral[num];
            }
        }
        return answer;
    }
}
