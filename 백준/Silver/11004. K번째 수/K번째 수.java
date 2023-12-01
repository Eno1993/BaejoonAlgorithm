import java.io.*;
import java.util.*;

public class Main{
    

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++){
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        
        for(int i=0; i<n; i++){
            int value = pq.poll();
            if(k==1){
                System.out.print(value);
                break;
            }else{
                k -=1;
            }
        }
    }
}