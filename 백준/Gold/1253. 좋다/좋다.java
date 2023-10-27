import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        String[] arrStr = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        Arrays.sort(arr);
        int answer = 0;
        for(int i=0; i<n; i++){
            int target = arr[i];
            int left = i==0 ? 1 : 0;
            int right = i==n-1 ? n-2 : n-1;
            while(left<right){
                if(arr[left]+arr[right]<target){
                    while(arr[left]+arr[right]<target && left<right){
                        left = i==left+1 ? left+2 : left+1;
                    }
                }else if(arr[left]+arr[right]==target){
                    answer++;
                    break;
                }else if(target<arr[left]+arr[right]){
                    while(target<arr[left]+arr[right] && left<right){
                        right = i==right-1 ? right-2 : right-1;
                    }
                }
            }
        }
        System.out.print(answer);
    }
}