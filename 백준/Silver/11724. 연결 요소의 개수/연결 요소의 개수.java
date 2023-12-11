import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        
        int[][] arr = new int[N][N];
        int[] check = new int[N];
        
        for(int i=0; i<M; i++){
            temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0])-1;
            int b = Integer.parseInt(temp[1])-1;
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        
        int answer = 0;
        for(int i=0; i<N; i++){
            if(check[i]==1){
                continue;
            }
            check[i] = 1;
            Queue<Integer> q = new LinkedList<>();
            for(int j=0; j<N; j++){
                if(arr[i][j]==1){
                    q.offer(j);
                    check[j] = 1;
                }
            }
            while(!q.isEmpty()){
                int value = q.poll();
                for(int j=0; j<N; j++){
                    if(arr[value][j]==1&&check[j]==0){
                        q.offer(j);
                        check[j] = 1;
                    }
                }
            }
            answer += 1;
        }
        System.out.print(answer);
    }
}