import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception{

        //System.setIn(new FileInputStream("C:\\Baekjoon\\Baekjoon\\src\\main\\java\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        
        int n = 2;
		while(n<10000000){
		    n = n*2;
		}

        int answer = 0;
		while(1<=N){
		    while(N<n){
		        n = n/2;
		    }
		    
		    if(K==1){
		        if(N!=n){
		            answer = n*2-N;
		        }
		        break;
		    }else{
		        N = N-n;
		        K--;
		    }
		    
		}
		
		System.out.print(answer);
    }
}