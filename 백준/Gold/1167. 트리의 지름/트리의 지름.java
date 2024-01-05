import java.io.*;
import java.util.*;

public class Main{

    public static List<Node>[] list;
    public static int[] check;
    public static int answer;
    public static int doubleCheck;

    public static class Node{
        int n;
        int cost;
        Node(int n, int cost){
            this.n = n;
            this.cost = cost;
        }
    }

    public static void dfs(int start, int cost){
        check[start] = 1;
        if(answer<cost){
            answer = cost;
            doubleCheck = start;
        }
        for(Node node : list[start]){
            if(check[node.n]==0){
                dfs(node.n, cost+node.cost);
            }
        }
        check[start] = 0;
    }

    public static void main(String[] args) throws IOException{

        //System.setIn(new FileInputStream("/Users/inho/IdeaProjects/untitled/src/main/java/org/example/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        check = new int[N+1];

        for(int i=0; i<N; i++){
            String[] temp = br.readLine().split(" ");
            int startNode = Integer.parseInt(temp[0]);
            for(int j=1; j<temp.length-1; j+=2){
                int targetNode = Integer.parseInt(temp[j]);
                int distance = Integer.parseInt(temp[j+1]);
                list[startNode].add(new Node(targetNode, distance));
            }
        }

        /*for(int i=1; i<=N; i++){
            for(Node node : list[i]){
                System.out.println(i+" --> "+node.n+"  :  "+ node.cost);

            }
            System.out.println("----------");
        }*/


        answer = 0;
        dfs(1,0);

        dfs(doubleCheck, 0);

        System.out.print(answer);
    }
}