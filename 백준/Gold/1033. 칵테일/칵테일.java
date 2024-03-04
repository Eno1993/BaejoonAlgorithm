import java.io.*;
import java.util.*;
public class Main{

    static long[] answer = null;

    public static class Node{
        int a;
        int b;
        long p;
        long q;
        Node(int a, int b, long p, long q){
            this.a = a;
            this.b = b;
            while(p%7==0&&q%7==0){
                p = p/7;
                q = q/7;
            }
            while(p%5==0&&q%5==0){
                p = p/5;
                q = q/5;
            }
            while(p%3==0&&q%3==0){
                p = p/3;
                q = q/3;
            }
            while(p%2==0&&q%2==0){
                p = p/2;
                q = q/2;
            }
            this.p = p;
            this.q = q;
        }
    }

    public static void multiple(long x){
        for(int i=0; i<answer.length; i++){
            answer[i] = answer[i]*x;
        }
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long arrayGCD() {
        long result = answer[0];
        for (int i=1; i<answer.length; i++) {
            result = gcd(result, answer[i]);
        }
        return result;
    }

    public static void main(String[] args) throws IOException{

        Queue<Node> q = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N-1; i++){
            String[] tmp = br.readLine().split(" ");
            q.offer(new Node(
                    Integer.parseInt(tmp[0]),
                    Integer.parseInt(tmp[1]),
                    Long.parseLong(tmp[2]),
                    Long.parseLong(tmp[3])));
        }

        answer = new long[N];
        Node first = q.poll();
        answer[first.a] = first.p;
        answer[first.b] = first.q;

        while(!q.isEmpty()){
            Node node = q.poll();

            if(answer[node.a]==0&&answer[node.b]==0){
                q.offer(node);
            }else if(answer[node.a]!=0&&answer[node.b]==0){
                if(answer[node.a]%node.p!=0){
                    multiple(node.p);
                }
                answer[node.b] = answer[node.a]/node.p*node.q;
            }else if(answer[node.a]==0&&answer[node.b]!=0){
                if(answer[node.b]%node.q!=0){
                    multiple(node.q);
                }
                answer[node.a] = (answer[node.b]/node.q)*node.p;
            }
        }

        long gcd = arrayGCD();

        StringBuilder builder = new StringBuilder();
        for(int i=0; i<answer.length; i++){
            answer[i] = answer[i]/gcd;
            builder.append(answer[i]).append(" ");
        }
        System.out.print(builder.toString());
    }
}