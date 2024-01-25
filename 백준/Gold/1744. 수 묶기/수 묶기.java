import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            if(0<n){
                plus.offer(n);
            }else{
                minus.offer(n);
            }
        }

        long answer = 0;
        if(!plus.isEmpty()){
            while(1<plus.size()){
                int a = plus.poll();
                int b = plus.poll();
                if(a==1 || b==1){
                    answer += a+b;
                }else{
                    answer += a*b;
                }
            }
            if(!plus.isEmpty()){
                answer += plus.poll();
            }
        }

        if(!minus.isEmpty()){
            while(1<minus.size()){
                int temp = minus.poll();
                temp *= minus.poll();
                answer += temp;
            }
            if(!minus.isEmpty()){
                answer += minus.poll();
            }
        }

        System.out.print(answer);

    }
}