import java.util.regex.*;
import java.util.HashSet;

class Solution {
   static HashSet<String> used = new HashSet<>();
	
	static boolean checkDuplicate(String s) {
		if(used.contains(s)) return true;
		else { used.add(s); return false; }
	}
	
	static String solution(String sentence) {
		String answer = sentence;
		
		for(int idx = 0; idx < answer.length(); idx++) {
			Pattern lowcase = Pattern.compile("[a-z]"); //lowcase 하나 
			Matcher matcher = lowcase.matcher(answer);
			if(!matcher.find(idx)) break;
			
			String dummy = matcher.group(); //찾은 소문자 
			System.out.println(dummy);
			idx = answer.indexOf(dummy.charAt(0));
			System.out.println("idx0:"+idx);
			
			Pattern rule1 = Pattern.compile("[A-Z]("+dummy+"[A-Z])+");
			Pattern rule2 = Pattern.compile(dummy+"([A-Z]+|([A-Z]([a-z][A-Z])+))"+dummy);
        	Pattern rule3 = Pattern.compile("[A-Z]+");
        	
        	Matcher m1 = rule1.matcher(answer);
        	Matcher m2 = rule2.matcher(answer);
        	Matcher m3 = rule3.matcher(answer);			
        	
			if(checkDuplicate(dummy)) { //중복된 dummy 이면 invalid 
				answer  = "invalid";
				break;
			}
			
			if(m2.find(idx)) {	//규칙2 찾기 ex)bWORLDb -> WORLD
				String res = "";
				
				//규칙2로만 이루어진경우
        		res = m2.group(1);	 
        		answer = m2.replaceAll(res+" "); //answer의 매칭되는 부분을 대체
        		System.out.println("rule2, res:"+res);
        		System.out.println("rule2, ans:"+answer);
        		
				//규칙2안에 규칙1이 중첩된 경우 
        		if(m1.find()) {	
        			String tmp = m1.group(); 
        			String tmp_dummy = tmp.charAt(1)+"";
        			
        			StringBuilder sb = new StringBuilder("");
    				for(String s : tmp.split(tmp_dummy)) {
    					sb.append(s);
    				}
    				answer = m1.replaceAll(sb.toString()+" "); //answer의 매칭되는 부분을 대체
    				System.out.println("rule2-2, ans:"+answer);
        		}
			}
			//규칙1 찾기 (찾은 dummy는 rule1의 시작이 아니므로 idx-1부터 find) ex)AxAxA -> AAA
			else if(m1.find()) { 
				String tmp = m1.group();
				StringBuilder res = new StringBuilder("");
				for(String s : tmp.split(dummy)) {
					res.append(s);
				}
				answer = m1.replaceAll(res.toString()+" "); //answer의 매칭되는 부분을 대체
				idx = answer.indexOf(res.toString()) + res.toString().length();
				System.out.println(answer);
			}
			else if(m3.find()) {	//규칙3 찾기 - 공백없는 대문자 
            	String tmp = m3.group();
            	int end = m3.end();
            	System.out.println("rule3, res:"+tmp);
            	if(tmp.length() == sentence.length()) break;
            	else if(Character.isLowerCase(answer.charAt(end))) { //바로뒤에 규칙일 경우 
            		answer = m3.replaceAll(tmp+ " "); continue;
            	}
            }
			else {
				answer = "invalid"; break;
			}
		}
        //최종 결과에 소문자가 포함되어 있으면 invalid로, 아니면 앞뒤공백 제거한 다음 answer 반환 
        Pattern check = Pattern.compile("[a-z]");
        Matcher lowMatcher = check.matcher(answer);
        return lowMatcher.find()? "invalid" : answer.trim();
    }
}
