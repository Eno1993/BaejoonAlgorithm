import java.io.*;

public class Main{
   
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[10000001];
        
        int answer = 0;
        String[] arrStr = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            int now = Integer.parseInt(arrStr[i]);
            if(m <= now){
                continue;
            }
            if(0 < arr[m-now]){
                arr[m-now]--;
                answer++;
            }else{
                arr[now]++;
            }
        }
        
        System.out.print(answer);
    }
}