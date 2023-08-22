import java.io.*;
import java.util.*;

public class Main{
    
    public static class Node{
        int x;
        int y;
        int num;
        Node(int x, int y, int num){
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rec = br.readLine().split(" ");
        int row = Integer.parseInt(rec[0]);
        int col = Integer.parseInt(rec[1]);
        int[][] arr = new int[row][col];
        int[][] answer = new int[row][col];
        StringTokenizer st;
        
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<row; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<col; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==2){
                    q.offer(new Node(i, j, 0));
                    arr[i][j] = -1;
                }
            }
        }
        
        int[] x_ = {-1, 1, 0, 0};
        int[] y_ = {0, 0, -1, 1};
     
        while(!q.isEmpty()){
            Node now = q.poll();
            
            for(int n=0; n<4; n++){
                int x = now.x+x_[n];
                int y = now.y+y_[n];
                if(0<=x&&x<row&&0<=y&&y<col&&arr[x][y]==1){
                    arr[x][y] = -1;
                    answer[x][y] = now.num+1;
                    q.offer(new Node(x, y, answer[x][y]));
                }
            }
        }
        
        for(int i=0; i<answer.length; i++){
            for(int j=0; j<answer[i].length; j++){
                if(arr[i][j]==-1){
                    System.out.print(answer[i][j]+" ");
                }else if(arr[i][j]==0){
                    System.out.print("0 ");
                }else if(arr[i][j]==1){
                    System.out.print("-1 ");
                }
            }
            System.out.println();
        }
            
    }
}