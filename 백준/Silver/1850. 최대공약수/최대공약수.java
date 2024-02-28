import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        long a = Long.parseLong(temp[0]);
        long b = Long.parseLong(temp[1]);

        long min = Math.min(a, b);
        long max = Math.max(a, b);
        
        long answer = 1;
        do{
            long nextMax = Math.max(max-min, min);
            long nextMin = Math.min(max-min, min);
            
            if(nextMax==nextMin||nextMin==0){
                answer = min;
                break;
            }
            
            if(nextMax%nextMin==0){
                answer = nextMin;
                break;
            }else{
                max = nextMax;
                min = nextMin;
            }
        }while(1<min);
        
        
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<answer; i++){
            builder.append("1");
        }
        System.out.print(builder.toString());
    }
}