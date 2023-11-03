import java.io.*;
import java.util.*;

public class Main{
   
    public static void main(String[] args) throws IOException{

        //System.setIn(new FileInputStream("/Users/inho/IdeaProjects/homework/src/main/java/com/example/homework/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int l = Integer.parseInt(temp[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<int[]> dq = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            int value = Integer.parseInt(st.nextToken());
            
            while(!dq.isEmpty() && dq.peekLast()[1]>value){
                dq.pollLast();
            }
            
            dq.offer(new int[]{i, value});
            
            if(dq.peek()[0]<i-l+1){
                dq.poll();
            }
            
            bw.write(dq.peek()[1]+" ");
        }
        bw.flush();
        bw.close();
    }
}