import java.io.*;
import java.util.*;

public class Main{
    
    public static int[] first = {2, 3, 5, 7};
    public static int[] notFirst = {1, 3, 7, 9};
    
    public static List<Integer> answer = new ArrayList<>();
    
    public static void checkPrimer(int num){
        int value = num;
        do{
            for(int i=2; i<=Math.sqrt(value); i++){
                if(value%i==0){
                    return;
                }
            }
            value /= 10;
        }while(0<value);

        answer.add(num);
    }
    
    public static void dfs(boolean flag, int n, int num){
        if(n==-1){
            checkPrimer(num);
        }else{
            if(flag){
                for(int i=0; i<4; i++){
                    int value = first[i]*(int)Math.pow(10, n);
                    dfs(false, n-1, num+value);
                }
            }else{
                for(int i=0; i<4; i++){
                    int value = notFirst[i]*(int)Math.pow(10, n);
                    dfs(false, n-1, num+value);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        //System.setIn(new FileInputStream("/Users/inho/IdeaProjects/untitled/src/main/java/org/example/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        
        dfs(true, N-1, 0);
        Collections.sort(answer);
        StringBuilder builder = new StringBuilder();
        for(int ans : answer){
            builder.append(ans);
            builder.append('\n');
        }
        System.out.print(builder.toString());
    }
}