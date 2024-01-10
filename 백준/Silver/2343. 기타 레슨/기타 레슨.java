import java.util.*;
import java.io.*;

public class Main{

    static int[] arr;

    public static int binaryDfs(int left, int right, int target){
        int mid;

        if(left<=right){
            mid = (left+right)/2;
            int count = getCount(mid);
            if(count==-1){
                return binaryDfs(mid+1, right, target);
            }else if(target<count){
                return binaryDfs(mid+1, right, target);
            }else if(target==count){
                return binaryDfs(left, mid-1, target);
            }else if(count<target){
                return binaryDfs(left, mid-1, target);
            }
        }
        return left;
    }

    public static int getCount(int time){
        int count = 0;
        int runningTime = 0;
        for(int i=0; i<arr.length; i++){
            if(time<arr[i]){
                return -1;
            }else if(runningTime+arr[i] < time){
                runningTime += arr[i];
            }else if(runningTime+arr[i] == time){
                runningTime = 0;
                count++;
            }else if(runningTime+arr[i] > time){
                runningTime = arr[i];
                count++;
            }
        }
        if(0<runningTime){
            count++;
        }
        return count;
    }


    public static void main(String[] args) throws IOException{
        //System.setIn(new FileInputStream("C:\\homework\\src\\main\\java\\com\\example\\homework\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        int left = 0;
        int right = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            right += arr[i];
        }
        left = arr[0];


        System.out.print(binaryDfs(left, right, M));



    }
}