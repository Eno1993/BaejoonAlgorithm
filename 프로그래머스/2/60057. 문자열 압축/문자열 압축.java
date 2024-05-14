import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i=0; i<s.length()/2; i++){
            
            ArrayList<String> list = new ArrayList<String>();
            int j =0;
            for(; j<s.length()-i; j +=(i+1)){
                list.add(s.substring(j, j+i+1));
            }list.add(s.substring(j, s.length()));
            
            int len =0;
            int count =1;
            String before = "";
            for(int k =0; k<list.size(); k++){
                String now = list.get(k);
                if(before.equals(now)){
                    if(count==1){
                        count++;
                        len += 1;
                    }else{
                        String b = Integer.toString(count);
                        count++;
                        String a = Integer.toString(count);
                        if(b.length()<a.length()){ len += 1; }
                    }
                }else{
                    count = 1;
                    len += now.length();
                }
                before = now; // 압축 문자열 정의.  길이 : i+1
            }
            if(len<answer){ answer = len;  }
        }
        return answer;
    }
}