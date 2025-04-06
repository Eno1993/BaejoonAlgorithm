//  단지번호붙이기

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;

class Main {

    public static int[] x_ = {-1, 1, 0, 0};
    public static int[] y_ = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i=0; i<N; i++) {
            String tmp = br.readLine();
            for (int j=0; j<N; j++) {
                arr[i][j] = tmp.charAt(j)-'0';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int totalCnt = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (arr[i][j] == 1) {
                    totalCnt++;
                    q.offer(new int[]{i, j});
                    arr[i][j] = 0;

                    int cnt = 0;
                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        cnt++;

                        for (int n=0; n<4; n++) {
                            int x = now[0] + x_[n];
                            int y = now[1] + y_[n];

                            if (0<=x && x<N && 0<=y && y<N && arr[x][y]==1) {
                                arr[x][y] = 0;
                                q.offer(new int[]{x, y});
                            }
                        }
                    }
                    if (!map.containsKey(cnt)) {
                        map.put(cnt, 1);
                    } else {
                        map.put(cnt, map.get(cnt) + 1);
                    }
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append(totalCnt).append('\n');

        List<Integer> list = map.keySet().stream().sorted().collect(Collectors.toList());
        for (Integer key : list) {
            for (int n=0; n<map.get(key); n++) {
                builder.append(key).append('\n');
            }
        }

        System.out.print(builder.toString());
    }
}