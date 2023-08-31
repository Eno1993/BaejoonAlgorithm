import java.io.*;
import java.util.*;

public class Main{

    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
        public boolean equals(Object o){
            if(o instanceof Node){
                if(x==((Node)o).x&&y==((Node)o).y){
                    return true;
                }
            }
            return false;
        }
        public int hashCode(){
            return Objects.hash(x, y);
        }
    }

    static final int[] x_ = {-1, 1, 0, 0};
    static final int[] y_ = {0, 0, 1, -1};

    static Set<Node> sPoint;
    static Set<Node> tPoint;

    static int[][] arr;
    static int needBlock;

    public static boolean isShortest(Node s, Node t, int select){
        if(select==0){
            for(int j=Math.min(s.y, t.y)+1; j<Math.max(s.y, t.y); j++){
                Node temp = new Node(s.x, j);
                if(sPoint.contains(temp)||tPoint.contains(temp)){
                    return false;
                }
            }
        }else{
            for(int i=Math.min(s.x, t.x)+1; i<Math.max(s.x, t.x); i++){
                Node temp = new Node(i, s.y);
                if(sPoint.contains(temp)||tPoint.contains(temp)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void remove(int X, int Y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(X, Y));

        int crossCount = 0;
        while(!q.isEmpty()){
            Node p = q.poll();
            if(2<arr[p.x][p.y]){
                crossCount++;
            }
            for(int n=0; n<4; n++){
                if(0<=n&&n<2&&arr[p.x][p.y]==2){ continue; }
                if(2<=n&&n<4&&arr[p.x][p.y]==1){ continue; }
                int x = p.x+x_[n];
                int y = p.y+y_[n];
                if(0<=x&&x<arr.length&&0<=y&&y<arr.length&&0<arr[x][y]){
                    q.offer(new Node(x, y));
                }
            }
            arr[p.x][p.y] = 0;
        }
        if(crossCount<=2){
            needBlock += 1;
        }else{
            needBlock += crossCount-1;
        }
    }

    public static void main(String[] args) throws IOException{
        //System.setIn(new FileInputStream("C:\\Baekjoon\\Baekjoon\\src\\main\\java\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        sPoint = new HashSet<Node>();
        tPoint = new HashSet<Node>();
        for(int i=0; i<N; i++){
            String[] temp = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                if(temp[j].equals("S")){
                    sPoint.add(new Node(i, j));
                }else if(temp[j].equals("T")){
                    tPoint.add(new Node(i, j));
                }
            }
        }

        arr = new int[N][N];
        for(Node s : sPoint){
            for(Node t : tPoint){
                if(s.x==t.x){
                    if(Math.abs(s.y-t.y)==1){
                        System.out.print("NO");
                        return;
                    }
                    if(isShortest(s, t, 0)){
                        for(int j=Math.min(s.y, t.y)+1; j<Math.max(s.y, t.y); j++){
                            arr[s.x][j] +=2;
                        }
                    }
                }else if(s.y==t.y){
                    if(Math.abs(s.x-t.x)==1){
                        System.out.print("NO");
                        return;
                    }
                    if(isShortest(s, t, 1)){
                        for(int i=Math.min(s.x, t.x)+1; i<Math.max(s.x, t.x); i++){
                            arr[i][s.y] += 1;
                        }
                    }
                }
            }
        }
        needBlock = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(0<arr[i][j]){
                    remove(i, j);
                }
            }
        }
        if(needBlock<=3){
            System.out.print("YES");
        }else{
            System.out.print("NO");
        }
    }
}