import java.util.*;
import java.io.*;

public class Main{
    
    public static class Node{
        int now;
        long move;
        Node(int now, long move){
            this.now = now;
            this.move = move;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        int K = Integer.parseInt(temp[2]);
        int X = Integer.parseInt(temp[3])-1;
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        StringTokenizer st;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            if(!map.containsKey(a)){
                map.put(a, new HashSet<>());
            }
            map.get(a).add(b);
        }
        int[] visited = new int[N];
        
        Queue<Node> q = new LinkedList<>();
        for(int next : map.get(X)){
            visited[X] = 1;
            q.offer(new Node(next, 1));    
        }
        
        List<Integer> answer = new ArrayList<>();
        while(!q.isEmpty()){
            Node node = q.poll();
            if(visited[node.now]==0){
                visited[node.now] = 1;
                if(node.move==K){
                    answer.add(node.now+1);
                }else if(node.move<K){
                    if(map.containsKey(node.now)){
                        for(int next : map.get(node.now)){
                            q.offer(new Node(next, node.move+1));
                        }
                    }
                }
            }
        }
        
        Collections.sort(answer);
        StringBuilder builder = new StringBuilder();
        for(int ans : answer){
            builder.append(ans).append("\n");
        }
        if(builder.toString().length()==0){
            System.out.print(-1);
        }else{
            System.out.print(builder.toString());
        }
        
    }
}