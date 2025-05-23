//  숨바꼭질

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());


        boolean[] check = new boolean[100001];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{ S, 0 });
        check[S] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == E) {
                System.out.print(now[1]);
                break;
            }
            if (now[0] + 1 <= 100000 && !check[now[0] + 1]) {
                q.offer(new int[]{ now[0] + 1, now[1] + 1 });
                check[now[0] + 1] = true;
            }
            if (0 <= now[0] - 1 && !check[now[0] - 1]) {
                q.offer(new int[]{ now[0] - 1, now[1] + 1 });
                check[now[0] - 1] = true;
            }
            if (now[0] * 2 <= 100000 && !check[now[0] * 2]) {
                q.offer(new int[]{ now[0] * 2, now[1] + 1 });
                check[now[0] * 1] = true;
            }
        }
    }
}