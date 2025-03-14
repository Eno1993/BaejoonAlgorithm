//  1, 2, 3 더하기 4

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder builder = new StringBuilder();

        for (int i=0; i<n; i++) {
            answer = 0;
            int target = Integer.parseInt(br.readLine());

            int nextTarget = target;
            answer++;
            while (0 <= nextTarget-2) {
                nextTarget -= 2;
                answer++;
            }

            while (0 <= target-3) {
                target -= 3;
                nextTarget = target;
                answer++;
                while (0 <= nextTarget-2) {
                    nextTarget -= 2;
                    answer++;
                }
            }

            builder.append(answer).append('\n');
        }

        System.out.print(builder.toString());
    }



}