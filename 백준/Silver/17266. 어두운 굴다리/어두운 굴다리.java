//  어두운 굴다리


import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        int maxLength = Integer.MIN_VALUE;
        int[] arr = new int[M];

        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());

        for (int i=1; i<M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxLength = Math.max(maxLength, (arr[i] - arr[i-1] + 1) / 2);
        }

        maxLength = Math.max(maxLength, arr[0] - 0);
        maxLength = Math.max(maxLength, N - arr[M-1]);

        System.out.print(maxLength);
    }
}