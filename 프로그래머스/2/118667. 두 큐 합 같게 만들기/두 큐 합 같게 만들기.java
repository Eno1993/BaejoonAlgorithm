import java.util.*;

class Solution {
    
    
    public int solution(int[] queue1, int[] queue2) {
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long q1_hap =0, q2_hap = 0;
        
        if ((q1_hap + q2_hap)%2==1) {
            return -1;
        }
        
        for (int i=0; i<queue1.length; i++) {
            q1.offer(queue1[i]);
            q1_hap += queue1[i];
            
            q2.offer(queue2[i]);
            q2_hap += queue2[i];
        }
        
        int answer = 0;
        while (true) {
            if (answer > (queue1.length+queue2.length)*2) {
                return -1;    
            }
            
            if (q1_hap < q2_hap) {
                if (q1_hap ==0) {
                    answer = -1;
                    break;
                }
                
                int value = q2.poll();
                q1.offer(value);

                q2_hap -= value;
                q1_hap += value;
                answer++;
                
            } else if (q1_hap > q2_hap) {
                if (q2_hap ==0) {
                    answer = -1;
                    break;
                }
                
                int value = q1.poll();
                q2.offer(value);
                    
                q1_hap -= value;
                q2_hap += value;
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}