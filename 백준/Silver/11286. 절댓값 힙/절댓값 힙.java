import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args)throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
	        @Override
	        public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)>Math.abs(o2)){
                    return 1;
                }else if(Math.abs(o1)==Math.abs(o2)){
                    if(o1>o2){
                        return 1;
                    }else{
                        return -1;
                    }
                }else{
                    return -1;
                }
	        }
        });
        
        for(int i=0; i<n; i++){
            int m = Integer.parseInt(br.readLine());
            if(m==0){
                if(!pq.isEmpty()){
                    System.out.println(pq.poll());
                }else{
                    System.out.println(0);
                }
            }else{
                pq.offer(m);
            }
        }
    }
}