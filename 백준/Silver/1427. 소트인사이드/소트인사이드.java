import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[10];
        
        for(int i=0; i<str.length(); i++){
            int n = str.charAt(i)-'0';
            arr[n]++;
        }
        for(int i=9; 0<=i; i--){
            while(0<arr[i]){
                System.out.print(i);
                arr[i]--;
            }
        }
    }
}