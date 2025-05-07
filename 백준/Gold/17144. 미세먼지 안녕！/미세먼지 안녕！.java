//  미세먼지 안녕!

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int[] x_ = {-1, 1, 0, 0};
    public static int[] y_ = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int clean = -1;

        int[][] arr = new int[R][C];
        for (int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j]==-1 && clean==-1) {
                    clean = i;
                }
            }
        }


        for (int t=0; t<T; t++) {

            int[][] diffusion = new int[R][C];
            for (int i=0; i<R; i++) {
                for (int j=0; j<C; j++) {
                    if (0 < arr[i][j]) {
                        int diff = arr[i][j] / 5;
                        for (int n=0; n<4; n++) {
                            int x = i + x_[n];
                            int y = j + y_[n];
                            if (0<=x && x<R && 0<=y && y<C && arr[x][y]!=-1) {
                                diffusion[x][y] += diff;
                                arr[i][j] -= diff;
                            }
                        }
                    }
                }
            }

            for (int i=0; i<R; i++) {
                for (int j=0; j<C; j++) {
                    arr[i][j] += diffusion[i][j];
                }
            }

            for (int i=clean-2; 0<=i; i--) { arr[i+1][0] = arr[i][0]; }
            for (int j=1; j<C; j++) { arr[0][j-1] = arr[0][j]; }
            for (int i=1; i<=clean; i++) { arr[i-1][C-1] = arr[i][C-1]; }
            for (int j=C-2; 1<=j; j--) { arr[clean][j+1] = arr[clean][j]; }
            arr[clean][1] = 0;
            for (int i=clean+3; i<R; i++) { arr[i-1][0] = arr[i][0]; }
            for (int j=1; j<C; j++) { arr[R-1][j-1] = arr[R-1][j]; }
            for (int i=R-2; clean<i; i--) { arr[i+1][C-1] = arr[i][C-1]; }
            for (int j=C-2; 1<=j; j--) { arr[clean+1][j+1] = arr[clean+1][j]; }
            arr[clean+1][1] = 0;
        }

        int answer = 0;

        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (0 < arr[i][j]) {
                    answer += arr[i][j];
                }
            }
        }

        System.out.print(answer);
    }
    
}