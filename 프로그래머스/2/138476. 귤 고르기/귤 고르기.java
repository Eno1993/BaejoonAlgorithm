import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int target = k;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            if (!map.containsKey(t))
                map.put(t, 0);
            map.put(t, map.get(t) +1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        int answer = 0;
        for (int value : list) {
            
            target -= value;
            answer++;
            
            if (target <=0) {
                break;
            }
        }
        
        return answer;
    }
}