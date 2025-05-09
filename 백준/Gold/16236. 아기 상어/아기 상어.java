//  아기 상어

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[] x_ = {-1, 0, 0, 1};
    static int[] y_ = {0, -1, 1, 0};

    static int N;
    static int[][] arr;
    static int[] shark; // i, j, size, upgrade
    static int sharkSize = 2;
    static int upgrade = 0;

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j]==9) {
                    shark = new int[]{i, j};
                    arr[i][j] = 0;
                }
            }
        }

        while (true) {
            if (!goHunt()) {
                break;
            }
        }

        System.out.print(answer);

    }

    public static boolean goHunt () {
        Queue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) return Integer.compare(a[2], b[2]);
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        q.offer(new int[]{shark[0], shark[1], 0});

        boolean[][] visit = new boolean[N][N];
        visit[shark[0]][shark[1]] = true;

        while (!q.isEmpty()) {
            int[] n = q.poll();

            if (0<arr[n[0]][n[1]] && arr[n[0]][n[1]]<sharkSize) {
                shark[0] = n[0];
                shark[1] = n[1];
                upgrade++;
                if (sharkSize==upgrade) {
                    sharkSize++;
                    upgrade = 0;
                }
                answer += n[2];
                arr[n[0]][n[1]] = 0;
                return true;
            }

            for (int i=0; i<4; i++) {
                int x = n[0] + x_[i];
                int y = n[1] + y_[i];
                if (0<=x && x<N && 0<=y && y<N && !visit[x][y] && arr[x][y]<=sharkSize) {
                    visit[x][y] = true;
                    q.offer(new int[]{x, y, n[2]+1});
                }
            }
        }
        return false;
    }
}