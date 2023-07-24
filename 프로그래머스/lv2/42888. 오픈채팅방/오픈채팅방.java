import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    public class Node{
        String userId;
        String behavior;
        Node(String userId, String behavior){
            this.userId = userId;
            this.behavior = behavior;
        }
    }
 
    public String[] solution(String[] record) {
        
        Map<String, String> userMap = new HashMap<>();
        List<Node> list = new ArrayList<>();
        
        for(int i=record.length-1; 0<=i; i--){
            String[] split = record[i].split(" ");
            if(3==split.length&&!userMap.containsKey(split[1])){
                userMap.put(split[1], split[2]);
            }
            
            if(split[0].equals("Enter")){
                list.add(new Node(split[1], "님이 들어왔습니다."));
            }else if(split[0].equals("Leave")){
                list.add(new Node(split[1], "님이 나갔습니다."));
            }
        }
        
        List<String> newList = list
            .stream()
            .map(node -> userMap.get(node.userId)+node.behavior)
            .collect(Collectors.toList());
        Collections.reverse(newList);
        
        return newList.toArray(String[]::new);
        
    }
    
}