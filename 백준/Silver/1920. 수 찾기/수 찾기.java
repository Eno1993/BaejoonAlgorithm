import java.io.*;
import java.util.*;

public class Main{

    public static int[] arr;

    public static int dfs(int left, int right, int target){
        int mid;

        if(left<=right){
            mid = (left+right)/2;

            if(target<arr[mid]){
                return dfs(left, mid-1, target);
            }else if(target==arr[mid]){
                return 1;
            }else if(arr[mid]<target){
                return dfs(mid+1, right, target);
            }
        }
        return 0;
    }



    public static void main(String[] args) throws IOException{

        //System.setIn(new FileInputStream("/Users/inho/IdeaProjects/untitled/src/main/java/org/example/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer stA = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(stA.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine(), " ");
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<M; i++){
            int target = Integer.parseInt(stB.nextToken());
            builder.append(dfs(0, N-1, target));
            builder.append("\n");
        }

        System.out.print(builder.toString());
    }
}