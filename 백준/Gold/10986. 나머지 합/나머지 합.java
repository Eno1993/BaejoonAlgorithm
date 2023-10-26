import java.io.*;

public class Main{
    
    public static long combie(long n){
        if (n < 2){
            return 0;
        }else{
            return n*(n-1)/2;
        }
    }
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        
        long[] arr = new long[n];
        int[] leftArr = new int[m];
        String[] strArr = br.readLine().split(" ");
        arr[0] = Integer.parseInt(strArr[0]);
        leftArr[(int)(arr[0]%m)]++;
        for(int i=1; i<n; i++){
            arr[i] = Integer.parseInt(strArr[i]) + arr[i-1];
            leftArr[(int)(arr[i]%m)]++;
        }
        
        long answer = leftArr[0];
        for(int i=0; i<m; i++){
            answer += combie(leftArr[i]);
        }
        
        System.out.print(answer);
    }
}