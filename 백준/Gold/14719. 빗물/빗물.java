//  빗물

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] arr = new int[W][3];

        st = new StringTokenizer(br.readLine());
        int left_max = Integer.MIN_VALUE;
        for (int i=0; i<W; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            if (left_max < arr[i][0]) {
                left_max = arr[i][0];
            }
            arr[i][1] = left_max;
        }

        int right_max = Integer.MIN_VALUE;
        for (int i=W-1; 0<=i; i--) {
            if (right_max < arr[i][0]) {
                right_max = arr[i][0];
            }
            arr[i][2] = right_max;
        }

        int answer = 0;
        for (int i=0; i<W; i++) {
            int water = Math.min(arr[i][1], arr[i][2]);
            answer += ( water - arr[i][0] );
        }

        System.out.print(answer);

    }
}