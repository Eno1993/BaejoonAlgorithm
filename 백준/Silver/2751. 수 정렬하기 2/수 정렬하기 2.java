import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<n; i++){
            int temp = Integer.parseInt(br.readLine());
            pq.offer(temp);
        }
        
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<n; i++){
            builder.append(pq.poll());
            builder.append("\n");
        }
        System.out.print(builder.toString());
    }
}