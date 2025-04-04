//  쉬운 최단거리

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int[] x_ = {-1, 1, 0, 0};
    public static int[] y_ = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int[][] root = new int[N][M];
        for (int[] r : root) {
            Arrays.fill(r, -1);
        }

        int[] start = null;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    start = new int[]{i, j, 0};
                    arr[i][j] = 0;
                    root[i][j] = -1;
                } else if (arr[i][j] == 1) {
                    root[i][j] = -1;
                } else if (arr[i][j] == 0) {
                    root[i][j] = 0;
                }

            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int[] now = q.poll();
            root[now[0]][now[1]] = now[2];
            for (int n=0; n<4; n++) {
                int x = now[0] + x_[n];
                int y = now[1] + y_[n];
                if (0<=x && x<N && 0<=y && y<M) {
                    if (arr[x][y] == 1) {
                        arr[x][y] = 0;
                        q.offer(new int[]{x, y, now[2]+1});
                    }
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                builder.append(root[i][j]).append(" ");
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }
}