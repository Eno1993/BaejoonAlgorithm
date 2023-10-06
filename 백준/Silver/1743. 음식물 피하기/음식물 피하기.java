import java.io.*;
import java.util.*;

public class Main{
    
    public static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] setting = br.readLine().split(" ");
        
        int[][] arr = new int[Integer.parseInt(setting[0])][Integer.parseInt(setting[1])];
        for(int i=0; i<Integer.parseInt(setting[2]); i++){
            String[] temp = br.readLine().split(" ");
            arr[Integer.parseInt(temp[0])-1][Integer.parseInt(temp[1])-1] = 1;
        }
        
        int answer = 0;
        
        int[] _x = {-1, 1, 0, 0};
        int[] _y = {0, 0, -1, 1};
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j]==1){
                    arr[i][j] = 0;
                    int count = 1;
                    Queue<Node> q = new LinkedList<>();
                    q.offer(new Node(i, j));
                    while(!q.isEmpty()){
                        Node node = q.poll();
                        for(int n=0; n<4; n++){
                            int x = node.x + _x[n];
                            int y = node.y + _y[n];
                            if(0<=x&&x<arr.length&&0<=y&&y<arr[0].length&&arr[x][y]==1){
                                arr[x][y] = 0;
                                count++;
                                q.offer(new Node(x, y));
                            }
                        }
                    }
                    if(answer<count){
                        answer = count;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}