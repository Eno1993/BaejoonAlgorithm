import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder builder = new StringBuilder();
        Queue<String> q = new LinkedList<>();

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if('0'<=c&&c<='9'){
                builder.append(c);
            }else{
                q.offer(builder.toString());
                builder.delete( 0, builder.length());
                if(c=='+'){
                    q.offer("+");
                }else{
                    q.offer("-");
                }
            }
        }
        q.offer(builder.toString());

        int answer = Integer.parseInt(q.poll());
        int check = 0;
        int hap = 0;
        while(!q.isEmpty()){
            String poll = q.poll();
            if(poll.equals("+")){
                ;
            }else if(poll.equals("-")){
                answer -= hap;
                hap = 0;
                check = 1;
            }else{
                if(check==0){
                    answer += Integer.parseInt(poll);
                }else{
                    hap += Integer.parseInt(poll);
                }
            }
        }
        answer -= hap;

        System.out.print(answer);
    }
}