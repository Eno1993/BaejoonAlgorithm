//  스위치 켜고 끄기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int N;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int cycle = Integer.parseInt(st.nextToken());

        for (int i=0; i<cycle; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            if (sex == 1) {
                man(target);
            } else {
                woman(target);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i=1; i<=N; i++) {
            builder.append(arr[i]).append(" ");
            if (i%20 == 0) {
                builder.append('\n');
            }
        }
        System.out.print(builder.toString());
    }

    public static void man (int target) {

        for (int s=target; s<=N; s+=target) {
            reverse(s);
        }
    }

    public static void woman (int target) {

        reverse(target);

        int end = Math.min(target-1, N-target);

        for (int i=1; i<=end; i++) {
            if (arr[target-i]!=arr[target+i]) {
                break;
            }
            reverse(target-i);
            reverse(target+i);
        }
    }

    public static void reverse (int target) {
        if (arr[target]==1) {
            arr[target] = 0;
        } else {
            arr[target] = 1;
        }
    }
}