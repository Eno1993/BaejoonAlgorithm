//  쓰레기 치우기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int N;
    public static int M;
    public static int[][] arr;

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
                if (arr[i][j] == 1) {
                }
            }
        }

        int answer = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (arr[i][j] == 1) {
                    answer++;
                    dfs(i, j);
                }
            }
        }

        System.out.print(answer);
    }

    public static void dfs (int x, int y) {

        arr[x][y] = 0;

        for (int i=x; i<N; i++) {
            for (int j=y; j<M; j++) {
                if (arr[i][j] == 1) {
                    dfs(i, j);
                    return;
                }
            }
        }
    }
}