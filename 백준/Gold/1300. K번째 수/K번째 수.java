import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        
        long min = 1;
        long max = K;
        long mid = 0;
        long count = 0;
        
        while(min<max){
            mid = (min+max)/2;
            count = 0;
            
            for(int i=1; i<=N; i++){
                count += Math.min(mid/i, N);
            }
            
            if(K<=count){
                max = mid;
            }else{
                min = mid + 1;
            }
        }
        
        System.out.print(min);
        
    }
}