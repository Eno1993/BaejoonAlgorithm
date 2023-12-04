import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[100001];
        for(int i=0; i<N; i++){
            arr[Integer.parseInt(br.readLine())]++;
        }
        
        StringBuilder builder = new StringBuilder();
        for(int i=1; i<100001; i++){
            for(int j=0; j<arr[i]; j++){
                builder.append(i);
                builder.append('\n');
            }
        }
        System.out.print(builder.toString());
    }
}