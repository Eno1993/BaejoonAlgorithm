import java.util.*;

class Solution {
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
      
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] road : roads) {
            if (!map.containsKey(road[0]))
                map.put(road[0], new ArrayList<>());
            map.get(road[0]).add(road[1]);
            
            if (!map.containsKey(road[1])) 
                map.put(road[1], new ArrayList<>());
            map.get(road[1]).add(road[0]);
        }
        
        Queue<int[]> q = new ArrayDeque();
        int[] temp = new int[n+1];
        
        int[] ans = new int[n+1];
        Arrays.fill(ans, -1);
        
        q.add(new int[]{destination, 0});
        temp[destination] = 1;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            ans[node[0]] = node[1];
            
            if (map.containsKey(node[0])) {
                for (int next : map.get(node[0])) {
                    if (temp[next]==0) {
                        q.add(new int[]{next, node[1]+1});
                        temp[next] = 1;
                    }   
                }
            }
            
        }
        
        int[] answer = new int[sources.length];
        
        for (int i=0; i<sources.length; i++) {
            answer[i] = ans[sources[i]];
        }
        
        return answer;
    }
}