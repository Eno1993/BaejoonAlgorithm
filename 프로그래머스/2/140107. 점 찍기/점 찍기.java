import java.lang.Math;

class Solution {
    public long solution(int k, int d) {
        
        long max = (long)d*(long)d;
        long answer = 0;
        
        for (int i=0; i<=1000000; i+=k) {
            long temp = max - (long)i*(long)i;
            if (temp < 0) {
                break;
            }
            
            long last = (long) Math.sqrt(temp);
            //System.out.println("temp : " + temp+ " last : "+last);
            answer += last/k+1;
        }
        
        return answer;
    }
}