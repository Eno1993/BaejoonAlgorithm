//  인구 이동

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int[] x_ = {-1, 1, 0 ,0};
    public static int[] y_ = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{

        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                int v = Integer.parseInt(st.nextToken());
                arr[i][j] = v;
            }
        }

        int[][] check = new int[N][N];
        int again = 0;

        do {

            for (int[] c : check) {
                Arrays.fill(c, 0);
            }
            again = 0;

            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {

                    if (check[i][j]==1) {
                        continue;
                    }

                    boolean c = false;
                    for (int n=0; n<4; n++) {
                        int ii = i + x_[n];
                        int jj = j + y_[n];
                        if (0<=ii && ii<N && 0<=jj && jj<N && check[ii][jj]==0) {
                            int cal = Math.abs(arr[i][j]-arr[ii][jj]);
                            if (L<=cal && cal<=R) {
                                c = true;
                                break;
                            }
                        }
                    }

                    if (c) {
                        again++;
                        List<int[]> list = new ArrayList<>();
                        Queue<int[]> queue = new LinkedList<>();
                        queue.offer(new int[]{i, j});
                        check[i][j] = 1;
                        long hap = arr[i][j];
                        while (!queue.isEmpty()) {
                            int[] t = queue.poll();
                            list.add(t);
                            for (int m=0; m<4; m++) {
                                int x = t[0] + x_[m];
                                int y = t[1] + y_[m];
                                if (0<=x && x<N && 0<=y && y<N && check[x][y]==0) {
                                    int cal = Math.abs(arr[t[0]][t[1]] - arr[x][y]);
                                    if (L<=cal && cal<=R) {
                                        hap += arr[x][y];
                                        check[x][y] = 1;
                                        queue.offer(new int[]{x, y});
                                    }
                                }
                            }
                        }

                        long avg = hap/(long)list.size();
                        int avgInt = (int) avg;
                        for (int[] t : list) {
                            arr[t[0]][t[1]] = avgInt;
                        }
                    }
                }
            }

            /*for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    System.out.print(arr[i][j] + " ");
                } System.out.println();
            }
            System.out.println();*/

            if (0 < again) {
                answer++;
            }

        } while (0 < again);

        System.out.print(answer);
    }
}