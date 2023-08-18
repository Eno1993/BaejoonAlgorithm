import java.io.*;

public class Main{

    static int[] arr = new int[10];
    static int count = 0;
    static String answer = "-1";


    public static void dfs(int startIndex, int beforeNum, int nowIndex, int K){

        if(!answer.equals("-1")){
            return;
        }

        if(nowIndex == 10){
            if(count==K){
                StringBuilder builder = new StringBuilder();
                for(int i=startIndex; i<10; i++){
                    builder.append(arr[i]);
                }
                answer = builder.toString();
            }
            count++;
            return;
        }

        for(int i=9-nowIndex; i<beforeNum; i++){
            arr[nowIndex] = i;
            dfs(startIndex, i, nowIndex+1, K);
            arr[nowIndex] = 0;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());


        for(int i=9; 0<=i; i--){
            dfs(i, 10, i, K);
        }

        System.out.println(answer);
    }
}