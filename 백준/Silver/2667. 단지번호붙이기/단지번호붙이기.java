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

        //System.setIn(new FileInputStream("C:\\Baekjoon\\Baekjoon\\src\\main\\java\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int[][] arr = new int[K][K];
        for(int i=0; i<K; i++){
            String temp = br.readLine();
            for(int j=0; j<K; j++){
                arr[i][j] = temp.charAt(j)-'0';
            }
        }

        int[] _x = {-1, 1, 0, 0};
        int[] _y = {0, 0, -1, 1};
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<K; i++){
            for(int j=0; j<K; j++){
                if(arr[i][j]==1){
                    arr[i][j] = 0;
                    int count = 1;
                    Queue<Node> q = new LinkedList<>();
                    q.offer(new Node(i, j));

                    while(!q.isEmpty()){
                        Node now = q.poll();
                        for(int n=0; n<4; n++){
                            int x = now.x + _x[n];
                            int y = now.y + _y[n];
                            if(0<=x&&x<K&&0<=y&&y<K&&arr[x][y]==1){
                                arr[x][y] = 0;
                                count++;
                                q.offer(new Node(x, y));
                            }
                        }
                    }
                    list.add(count);
                }
            }
        }
        Collections.sort(list);

        System.out.println(list.size());
        for(int n : list){
            System.out.println(n);
        }

    }
}