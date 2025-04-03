//  진우의 달 여행 (Small)

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int[] y_ = {-1, 0, 1};
    public static int[][] arr;
    public static int N;
    public static int M;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int j=0; j<M; j++) {
            dfs(0, j, -1, arr[0][j]);
        }
        System.out.println(answer);
    }

    public static void dfs (int i, int j, int move, int value) {
        if (i==N-1) {
            answer = Math.min(answer, value);
            return;
        }

        for (int n=0; n<3; n++) {
            int x = i+1;
            int y = j + y_[n];
            if (x<N && 0<=y && y<M && move!=n) {
                dfs(x, y, n, value + arr[x][y]);
            }
        }

    }
}