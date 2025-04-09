//  감시

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int N;
    public static int M;
    public static int[][] arr;
    public static int[][] check;
    public static int camera;
    public static int[] directions = {4, 2, 4, 4, 1};
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        check = new int[N][M];
        camera = 0;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (1<=arr[i][j] && arr[i][j]<=5) {
                    camera++;
                }
            }
        }
        dfs(0);
        System.out.print(answer);

    }

    public static void dfs (int c) {

        if (c==camera) {
            checkAnswer();
            return;
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (1<=arr[i][j] && arr[i][j]<=5 && check[i][j]==0) {
                    for (int n=1; n<=directions[arr[i][j]-1]; n++) {
                        check[i][j] = n;
                        dfs(c+1);
                        check[i][j] = 0;
                    }
                    return;
                }
            }
        }
    }

    public static void checkAnswer () {

        int[][] results = new int[N][M];
        for (int i=0; i<N; i++) {
            results[i] = arr[i].clone();
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (1<=check[i][j] && check[i][j]<=4) {
                    observe(i, j, arr[i][j], check[i][j], results);
                }
            }
        }

        /*for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(arr[i][j] +" ");
            } System.out.print("     ");
            for (int j=0; j<M; j++) {
                System.out.print(check[i][j] +" ");
            } System.out.print("     ");
            for (int j=0; j<M; j++) {
                System.out.print(results[i][j] +" ");
            } System.out.println();
        } System.out.println();*/

        answer = Math.min(answer, findAnswer(results));
    }


    public static void observe (int x, int y, int target, int direction, int[][] results) {

        switch (target) {
            case 1 :
                cover(x, y, direction, results);
                break;
            case 2 :
                if (direction == 1) {
                    cover(x, y, 1, results);
                    cover(x, y, 3, results);
                } else {
                    cover(x, y, 2, results);
                    cover(x, y, 4, results);
                }
                break;
            case 3 :
                if (direction == 1) {
                    cover(x, y, 1, results);
                    cover(x, y, 2, results);
                } else if (direction == 2) {
                    cover(x, y, 2, results);
                    cover(x, y, 3, results);
                } else if (direction == 3) {
                    cover(x, y, 3, results);
                    cover(x, y, 4, results);
                } else {
                    cover(x, y, 4, results);
                    cover(x, y, 1, results);
                }
                break;
            case 4 :
                if (direction == 1) {
                    cover(x, y, 1, results);
                    cover(x, y, 2, results);
                    cover(x, y, 3, results);
                } else if (direction == 2) {
                    cover(x, y, 2, results);
                    cover(x, y, 3, results);
                    cover(x, y, 4, results);
                } else if (direction == 3) {
                    cover(x, y, 3, results);
                    cover(x, y, 4, results);
                    cover(x, y, 1, results);
                } else {
                    cover(x, y, 4, results);
                    cover(x, y, 1, results);
                    cover(x, y, 2, results);
                }
                break;
            case 5 :
                cover(x, y, 1, results);
                cover(x, y, 2, results);
                cover(x, y, 3, results);
                cover(x, y, 4, results);
        }

    }


    public static void cover (int x, int y, int direction, int[][] results) {
        if (direction == 1) {
            for (int i=x; 0<=i; i--) {
                if (results[i][y] == 6){
                    break;
                }
                results[i][y] = 1;
            }
        } else if (direction == 2) {
            for (int j=y; j<M; j++) {
                if (results[x][j] == 6){
                    break;
                }
                results[x][j] = 1;
            }
        } else if (direction == 3) {
            for (int i=x; i<N; i++) {
                if (results[i][y] == 6){
                    break;
                }
                results[i][y] = 1;
            }
        } else {
            for (int j=y; 0<=j; j--) {
                if (results[x][j] == 6){
                    break;
                }
                results[x][j] = 1;
            }
        }
    }

    public static int findAnswer (int[][] results) {
        int tmp = 0;

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (results[i][j] == 0) {
                    tmp++;
                }
            }
        }
        return tmp;
    }

}