import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
        
            int min = Math.min(a, b);
            int max = Math.max(a, b);
        
            int answer = max;
            while(true){
                if(answer%min==0){
                    break;
                }else{
                    answer += max;
                }
            }
            System.out.println(answer);
        }
    }
}