import java.io.*;
import java.util.*;

public class Main{
    public static int[] order;
    public static int[][] arr;
    public static int[][] bottom;
    public static int[][] max;


    public static int findBottom(int i, int j){
        return arr[i][order[j]];
    }

    public static int findMax(int i, int j){
        for(int max=6; 1<max; max--){
            if(max!=arr[i][j]&&max!=bottom[i][j]){
                return max;
            }
        }
        return 3;
    }

    public static int findLastMax(int i, int j){
        int up = arr[i][j];
        for(int last = 0; last<6; last++){
            if(bottom[i-1][last]==up){
                return last;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {


        order = new int[]{5, 3, 4, 1, 2, 0};

        //System.setIn(new FileInputStream("C:\\Baekjoon\\Baekjoon\\src\\main\\java\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][6];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<6; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bottom = new int[n][6];
        max = new int[n][6];
        for(int j=0; j<6; j++){
           bottom[0][j] = findBottom(0, j);
           max[0][j] = findMax(0, j);
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<6; j++){
                bottom[i][j] = findBottom(i, j);
                max[i][j] = max[i-1][findLastMax(i, j)] + findMax(i, j);
            }
        }

        int answer = 0;
        for(int j=0; j<6; j++){
            answer = Math.max(max[n-1][j], answer);
        }

        System.out.print(answer);
    }
}