//  N-Queen

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int answer = 0;
    public static int N;
    public static int[][] arr;

    public static int[] x_ = {0, -1, -1, -1, 0};
    public static int[] y_ = {-1, -1, 0, 1, 1};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int j=0; j<N; j++) {
            arr[0][j] = 1;
            dfs(1);
            arr[0][j] = 0;
        }

        System.out.print(answer);

    }

    public static void dfs (int i) {
        if (i==N) {
            answer++;
            return;
        }

        for (int j=0; j<N; j++) {
            if (check(i, j)) {
                arr[i][j] = 1;
                dfs(i+1);
                arr[i][j] = 0;
            }
        }
    }


    public static boolean check (int i, int j) {

        for (int n=0; n<5; n++) {
            int x = i + x_[n];
            int y = j + y_[n];

            while (0<=x && x<N && 0<=y && y<N) {
                if (arr[x][y]==1) {
                    return false;
                }
                x += x_[n];
                y += y_[n];
            }
        }
        return true;
    }



}