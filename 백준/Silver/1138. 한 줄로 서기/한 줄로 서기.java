//  한 줄로 서기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        for (int i=n-1; 0<=i; i--) {
            list.add(arr[i], i+1);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int value : list) {
            stringBuilder.append(value).append(" ");
        }

        System.out.print(stringBuilder.toString());
    }
}