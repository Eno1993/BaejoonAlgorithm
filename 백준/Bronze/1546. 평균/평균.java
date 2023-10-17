import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] scores = br.readLine().split(" ");
        int hap = 0;
        int max = -1;
        
        for(String score : scores){
            int scoreInt = Integer.parseInt(score);
            max = max < scoreInt ? scoreInt : max;
            hap += scoreInt;
        }
        
        double answer = hap*100/max;
        System.out.print(answer/num);
        
    }
}