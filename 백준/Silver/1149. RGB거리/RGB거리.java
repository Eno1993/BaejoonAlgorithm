import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][][] arr = new int[2][N][3];
        for(int i=0; i<N; i++){
            String[] strArr = br.readLine().split(" ");
            for(int j=0; j<3; j++){
                arr[0][i][j] = Integer.parseInt(strArr[j]);
            }
        }
        
        arr[1][0][0] = arr[0][0][0];
        arr[1][0][1] = arr[0][0][1];
        arr[1][0][2] = arr[0][0][2];
        for(int i=1; i<N; i++){
            arr[1][i][0] += arr[0][i][0] + Math.min(arr[1][i-1][1], arr[1][i-1][2]);
            arr[1][i][1] += arr[0][i][1] + Math.min(arr[1][i-1][0], arr[1][i-1][2]);
            arr[1][i][2] += arr[0][i][2] + Math.min(arr[1][i-1][0], arr[1][i-1][1]);
        }
        
        System.out.print(Math.min(Math.min(arr[1][N-1][0], arr[1][N-1][1]), arr[1][N-1][2]));
    }
}