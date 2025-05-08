//  뮤탈리스크

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[][] damage = new int[][]{
            {9, 3, 1},
            {9, 1, 3},
            {3, 9, 1},
            {3, 1, 9},
            {1, 9, 3},
            {1, 3, 9}};

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[4];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][][] visit = new boolean[61][61][61];
        Queue<int[]> q = new LinkedList<>();
        q.offer(arr);

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (visit[now[0]][now[1]][now[2]]) {
                continue;
            }

            visit[now[0]][now[1]][now[2]] = true;
            if (now[0]==0 && now[1]==0 && now[2]==0) {
                answer = Math.min(answer, now[3]);
                continue;
            }

            for (int d=0; d<6; d++) {

                q.offer(new int[]{
                        Math.max(now[0]-damage[d][0], 0),
                        Math.max(now[1]-damage[d][1], 0),
                        Math.max(now[2]-damage[d][2], 0),
                        now[3]+1});
            }
        }

        System.out.print(answer);

    }

}