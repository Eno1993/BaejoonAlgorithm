//  불!

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;

class Main {

    public static int[] x_ = {-1, 1, 0 ,0};
    public static int[] y_ = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] arr = new int[row][col];

        Queue<int[]> fire = new LinkedList<>();
        Queue<int[]> root = new LinkedList<>();

        for (int i=0; i<row; i++) {
            String tmp = br.readLine();
            for (int j=0; j<col; j++) {
                char c = tmp.charAt(j);
                if (c == '#') {
                    arr[i][j] = 1; // 벽
                } else if (c == '.') {
                    arr[i][j] = 0; // 갈 수 있음
                } else if (c == 'J') {
                    root.offer(new int[]{i, j, 1});
                    arr[i][j] = 1;
                } else if (c == 'F') {
                    fire.offer(new int[]{i, j});
                    arr[i][j] = 1;
                }
            }
        }

        Set<int[]> fireSet = new HashSet<>();
        Set<int[]> rootSet = new HashSet<>();
        while (!fire.isEmpty() || !root.isEmpty()) {
            while (!fire.isEmpty()) {
                int[] f = fire.poll();
                for (int n=0; n<4; n++) {
                    int xx = f[0] + x_[n];
                    int yy = f[1] + y_[n];
                    if (0<=xx && xx<row && 0<=yy && yy<col) {
                        if (arr[xx][yy] == 0) {
                            arr[xx][yy] = 1;
                            fireSet.add(new int[]{xx, yy});
                        }
                    }
                }
            }
            fire.addAll(fireSet.stream().collect(Collectors.toList()));
            fireSet.clear();

            while (!root.isEmpty()) {
                int[] r = root.poll();

                if (r[0]==0 || r[0]==row-1 || r[1]==0 || r[1]==col-1) {
                    System.out.print(r[2]);
                    return;
                }

                for (int n=0; n<4; n++) {
                    int xx = r[0] + x_[n];
                    int yy = r[1] + y_[n];
                    if (0<=xx && xx<row && 0<=yy && yy<col) {
                        if (arr[xx][yy] == 0) {
                            arr[xx][yy] = 1;
                            rootSet.add(new int[]{xx, yy, r[2]+1});
                        }
                    }
                }
            }
            root.addAll(rootSet.stream().collect(Collectors.toList()));
            rootSet.clear();
        }

        System.out.print("IMPOSSIBLE");

    }
}