import java.io.*;
import java.util.*;

public class Main {

    public static int[] x_ = {-1, 1, 0, 0};
    public static int[] y_ = {0, 0, -1, 1};

    public static int N;
    public static int M;
    public static int[][] arr;
    public static int[][] root;

    //public static int answer;

    /*public static void dfs(int x, int y, int count){
        if(answer<=count){
            return;
        }

        if(x==N && y==M){
            answer = count<answer ? count : answer;
            return;
        }
        for(int n=0; n<4; n++){
            int X = x+x_[n];
            int Y = y+y_[n];
            if(0<=X&&X<N&&0<=Y&&Y<M&&arr[X][Y]==1&&root[X][Y]==0){
                root[X][Y] = 1;
                dfs(X, Y, count+1);
                root[X][Y] = 0;
            }
        }
    }*/

    public static class Node{
        int x;
        int y;
        int count;
        Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        String[] temp_split = temp.split(" ");
        N = Integer.parseInt(temp_split[0]);
        M = Integer.parseInt(temp_split[1]);

        arr = new int[N][M];
        root = new int[N][M];
        for(int i=0; i<N; i++){
            temp = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = temp.charAt(j)-'0';
            }
        }

        //answer = 999;
        root[0][0] = 1;
        //dfs(0, 0, 0);
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1));
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int n=0; n<4; n++){
                int X = now.x+x_[n];
                int Y = now.y+y_[n];
                if(0<=X&&X<N&&0<=Y&&Y<M&&arr[X][Y]==1&&root[X][Y]==0){
                    root[X][Y] = now.count+1;
                    q.offer(new Node(X, Y, root[X][Y]));
                }
            }
        }

        System.out.print(root[N-1][M-1]);
    }
}