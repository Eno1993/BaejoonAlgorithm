import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }
        
        int answer = 0;
        while(1<pq.size()){
            int temp = pq.poll();
            temp += pq.poll();
            answer += temp;
            pq.offer(temp);
        }
        
        System.out.print(answer);
        
        
    }
}