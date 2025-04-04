//  고층 건물

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MIN_VALUE;
        for (int target = 0; target<N; target++) {
            int cnt = 0;

            double left_lean = 0;
            if (0 <= target-1) {
                left_lean = arr[target] - arr[target-1];
                cnt++;
            }
            for (int i=target-2; 0<=i; i--) {
                double tmp_lean = (double) (arr[target]-arr[i])/(target-i);
                if (tmp_lean < left_lean) {
                    cnt++;
                    left_lean = tmp_lean;
                }
            }

            double right_lean = 0;
            if (target+1 < N) {
                right_lean = arr[target+1] - arr[target];
                cnt++;
            }
            for (int i=target+2; i<N; i++) {
                double tmp_lean = (double) (arr[i] - arr[target])/(i-target);
                if (right_lean < tmp_lean) {
                    cnt++;
                    right_lean = tmp_lean;
                }
            }

            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
}