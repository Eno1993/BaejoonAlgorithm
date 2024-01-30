import java.util.*;
import java.io.*;

public class Main{
    
    public static class Node implements Comparable<Node>{
        int start;
        int end;
        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Node n){
            if(this.end<n.end){
                return -1;
            }else if(this.end==n.end){
                if(this.start<=n.start){
                    return -1;
                }else{
                    return 1;
                }
            }else{
                return 1;
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        //System.setIn(new FileInputStream("/Users/inho/IdeaProjects/untitled/src/main/java/org/example/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new Node(start, end));
        }
       
        Node first = pq.poll();
        int start = first.start;
        int end = first.end;
        int answer = 1;
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(end<=now.start){
                start = now.start;
                end = now.end;
                answer += 1;
            }
        }
        
        System.out.print(answer);
    }
}