import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        int[] arr = new int[n];
        
        Stack<int[]> stack = new Stack<>();
        for(int index=0; index<n; index++){
            int value = Integer.parseInt(temp[index]);
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && stack.peek()[1]<value){
                    int[] pop = stack.pop();
                    arr[pop[0]] = value;
                }
                stack.push(new int[]{index, value});
            }else{
                stack.push(new int[]{index, Integer.parseInt(temp[index])});
            }
        }
        while(!stack.isEmpty()){
            int[] popArr = stack.pop();
            arr[popArr[0]] = -1;
        }
        
        for(int i=0; i<n; i++){
            bw.write(arr[i]+" ");
        }
        bw.flush();
        bw.close();
    }
}