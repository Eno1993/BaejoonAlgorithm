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
            if (!goHunt()) break; // 더 이상 먹을 물고기 없으면 종료
        }

        System.out.print(answer);

    }

    public static boolean goHunt() {
        boolean[][] visit = new boolean[N][N];

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) return Integer.compare(a[2], b[2]); // 거리 우선
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]); // 위쪽 우선
            return Integer.compare(a[1], b[1]);                   // 왼쪽 우선
        });

        // 큐에 시작 위치 넣기
        q.offer(new int[]{shark[0], shark[1], 0});
        visit[shark[0]][shark[1]] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0], y = now[1], dist = now[2];

            // 먹을 수 있는 물고기 발견
            if (arr[x][y] > 0 && arr[x][y] < sharkSize) {
                // 물고기 먹음
                shark[0] = x;
                shark[1] = y;
                arr[x][y] = 0; // 물고기 먹었으니까 위치 비움
                answer += dist; // 거리 더하기
                upgrade++;

                // 상어가 일정 크기 이상 먹었으면 크기 증가
                if (upgrade == sharkSize) {
                    sharkSize++;
                    upgrade = 0;
                }
                return true; // 먹을 수 있는 물고기를 찾았으면 바로 리턴
            }

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + x_[i];
                int ny = y + y_[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visit[nx][ny] && arr[nx][ny] <= sharkSize) {
                    visit[nx][ny] = true;
                    q.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }

        return false; // 더 이상 먹을 물고기 없음
    }
}