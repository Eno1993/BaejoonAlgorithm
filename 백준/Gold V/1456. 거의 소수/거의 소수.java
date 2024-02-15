import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        long A = Long.parseLong(temp[0]);
        long B = Long.parseLong(temp[1]);

        int b = (int)Math.sqrt(B);

        Set<Integer> primes = new HashSet<>();
        int[] arr = new int[10000001];
        for(int i=2; i<=b; i++){
            if(arr[i]==0){
                primes.add(i);
            }
            for(int j=i; j<=b; j+=i){
                arr[j] = 1;
            }
        }

        int answer = 0;
        for(int prime : primes){
            int pow = 2;
            while(true){
                long target = (long)Math.pow(prime, pow);
                if(target<A){
                    pow++;
                    continue;
                }else if(A<=target && target<=B){
                    pow++;
                    answer++;
                    continue;
                }else if(B<target){
                    break;
                }
            }
            
        }

        System.out.print(answer);
    }
}