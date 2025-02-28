//  IF문 좀 대신 써줘

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int test = Integer.parseInt(st.nextToken());


        int[] index = new int[num];
        String[] typeArr = new String[num];
        for (int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine());
            typeArr[i] = st.nextToken();
            index[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder builder = new StringBuilder();
        for (int i=0; i<test; i++) {
            int value = Integer.parseInt(br.readLine());

            int left = 0;
            int right = index.length-1;

            while (left<=right) {
                int mid = (left+right)/2;
                if (index[mid]<value) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            builder.append(typeArr[left]).append("\n");
        }

        System.out.print(builder.toString());


    }
}