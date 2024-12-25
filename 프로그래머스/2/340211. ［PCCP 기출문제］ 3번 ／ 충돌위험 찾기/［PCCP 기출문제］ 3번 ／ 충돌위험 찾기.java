import java.util.*;

class Solution {
    
    public class Node {
        int x;
        int y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
        public String getKey () {
            return x + "_" + y;
        }
    }
    
    public List<Node> getRoot (int[] start, int [] end) {
        
        List<Node> res = new ArrayList<>();
        
        int n_x = start[0];
        int n_y = start[1];
        
        if(start[0] <= end[0]) { //DOWN
            for (n_x = start[0]; n_x<=end[0]; n_x++) {
                res.add(new Node(n_x, n_y));
            } n_x--;
        } else { // UP
            for (n_x = start[0]; n_x>=end[0]; n_x--) {
                res.add(new Node(n_x, n_y));
            } n_x++;
        }
        
        if(start[1] <= end[1]) { //RIGHT
            for (n_y = start[1]+1; n_y<=end[1]; n_y++) {
                res.add(new Node(n_x, n_y));
            } n_y--;
        } else { // LEFT
            for (n_y = start[1]-1; n_y>=end[1]; n_y--) {
                res.add(new Node(n_x, n_y));
            } n_y++;
        }
        
        return res.subList(0, res.size()-1);
        
    }
    
    public int solution(int[][] points, int[][] routes) {
        
        List<List<Node>> nodeList = new ArrayList<>();
        
        for (int i=0; i<routes.length; i++) {
            int[] route = routes[i];
            List<Node> totalNode = new ArrayList<>();
            for (int n=0; n<route.length-1; n++) {
                int s = route[n];
                int e = route[n+1];
                int[] start = points[s-1];
                int[] end = points[e-1];
                totalNode.addAll(getRoot(start, end));   
                if (n==route.length-2) {
                    totalNode.add(new Node(end[0], end[1]));
                }
            }
            nodeList.add(totalNode);     
        }
        
        Map<String, Integer> map = new HashMap<>();
        for (List<Node> nodes : nodeList) { 
            for(int i=0; i<nodes.size(); i++) {
                Node now = nodes.get(i);
                String key = i + "_" + now.getKey();
                //System.out.println(key);
                if (!map.containsKey(key)) {
                   map.put(key, 1); 
                } else {
                    map.put(key, map.get(key)+1);
                }
            }
        }
        
        int answer = 0;
        for (int value : map.values()) {
            if (1<value) {
                answer++;
            }
        }
        
        return answer;
    }
}