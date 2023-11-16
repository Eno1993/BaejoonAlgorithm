import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int value;
    int index;
    
    Node(int value, int index){
        this.value = value;
        this.index = index;
    }
    
    @Override
    public int compareTo(Node n) {
        return this.value - n.value;
    }
}

public class Main{
    
    public static void main(String[] arsg) throws IOException{
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            nodes[i] = new Node(n, i);
        }
        
        Arrays.sort(nodes);
        int answer = 0;
        for(int i=0; i<N; i++){
            answer = Math.max(answer, nodes[i].index - i);
        }
        System.out.print(answer+1);
    }
}