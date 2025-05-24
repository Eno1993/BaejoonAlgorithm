//  등수 구하기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());


        if (N==0) {
            System.out.println(1);
            return;
        }

        List<Integer> list = new ArrayList<>();
        list.add(score);

        int order = 1;
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            int value = Integer.parseInt(st.nextToken());
            list.add(value);
            if (score < value) {
                order++;
            }
        }

        Collections.sort(list, Collections.reverseOrder());

        for (int i=list.size()-1; 0<=i; i--) {
            if (list.get(i)==score) {
                if (i+1<=P) {
                    System.out.print(order);
                } else {
                    System.out.print(-1);
                }
                break;
            }
        }

    }
}