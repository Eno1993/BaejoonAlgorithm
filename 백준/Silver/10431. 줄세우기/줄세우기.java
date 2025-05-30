//  줄세우기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int P = Integer.parseInt(st.nextToken());
        int[] arr = new int[P];
        for (int i=0; i<P; i++) {
            int hap = 0;
            List<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            for (int k=0; k<20; k++) {
                int value = Integer.parseInt(st.nextToken());
                int index = 0;
                for (; index<list.size(); index++) {
                    if (value < list.get(index)) {
                        break;
                    }
                }
                hap += list.size()-index;
                list.add(index, value);
            }
            arr[i] = hap;
            hap = 0;
            list.clear();
        }

        StringBuilder builder = new StringBuilder();
        for (int i=0; i<P; i++) {
            builder.append(i+1).append(" ").append(arr[i]).append('\n');
        }

        System.out.print(builder.toString());

    }
}