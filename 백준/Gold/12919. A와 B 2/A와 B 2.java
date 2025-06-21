//  A와 B 2

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();
        String start = br.readLine();

        Queue<String> q = new LinkedList<>();
        q.offer(start);
        boolean check = false;

        while (!q.isEmpty()) {
            String str = q.poll();

            if (str.length() == target.length()) {
                if (str.equals(target)) {
                    check = true;
                    break;
                }
            } else {
                // 첫 번째 경우
                if (str.charAt(str.length()-1) == 'A') {
                    q.offer(str.substring(0, str.length()-1));
                }

                // 두 번째 경우
                String reverse = new StringBuilder(str).reverse().toString();
                if (reverse.charAt(reverse.length()-1) == 'B') {
                    q.offer(reverse.substring(0, reverse.length()-1));
                }
            }

        }
        if (check) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}