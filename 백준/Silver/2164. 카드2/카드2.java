import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=1; i<=N; i++){
            q.offer(i);
        }
        boolean out = true;
        while(!q.isEmpty()){
            if(q.size()==1){
                break;
            }
            
            if(out){
                q.poll();
            }else{
                q.offer(q.poll());
            }
            out = !out;
        }
        System.out.print(q.poll());
    }
}