import java.util.*;

class Solution {
    
    public int[] solution(int[][] edges) {
        
        Map<Integer, Integer> out = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>();
        int[] answer = new int[4];

        for (int[] edge : edges) {
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
        }
        
        for(int outNode : out.keySet()){
            if(1<out.get(outNode)){
                if(!in.containsKey(outNode)){
                    answer[0] = outNode;
                }else{
                    answer[3]++;
                }
            }
        }
        
        for(int inNode : in.keySet()){
            if(!out.containsKey(inNode)){
                answer[2]++;
            }
        }
        
        answer[1] = out.get(answer[0])-answer[2]-answer[3];
        return answer;
    }
}