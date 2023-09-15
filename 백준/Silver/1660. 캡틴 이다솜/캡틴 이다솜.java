import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{

        //System.setIn(new FileInputStream("C:\\Baekjoon\\Baekjoon\\src\\main\\java\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int[] An = new int[123];
        int[] Bn = new int[123];
        An[1] = 1;
        Bn[1] = 1;
        for(int i=2; i<123; i++){
            An[i] = An[i-1] + i;
            Bn[i] = Bn[i-1] + An[i];
        }

        int[] Cn = new int[N+1];
        Arrays.fill(Cn, Integer.MAX_VALUE);
        Cn[0] = 0;
        Cn[1] = 1;

        
        for(int c=2; c<Cn.length; c++){
            for(int b=1; b<Bn.length&&Bn[b]<=c; b++){
                Cn[c] = Math.min(Cn[c], Cn[c-Bn[b]]+1);
            }
        }

        System.out.println(Cn[N]);
    }
}