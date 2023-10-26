import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int left = 0;
        int right = 1;
        int sum = 1;
        int answer = 0;
        
        while(left<=right){
            if(sum<target){
                do{
                    right++;
                    sum += right;
                }while(sum<target);
            }else if(sum==target){
                answer++;
                right++;
                sum += right;
                sum -= left;
                left++;
            }else if(sum>target){
                do{
                    sum -= left;
                    left++;
                }while(sum>target && left<right);
            }
        }
        System.out.print(answer);
    }
}