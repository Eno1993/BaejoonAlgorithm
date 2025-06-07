//  스카이라인 쉬운거

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int height = Integer.parseInt(st.nextToken());
            list.add(height);
        }
        list.add(0);

        int answer = 0;
        Stack<Integer> s = new Stack<>();
        for (int val : list) {

            while (!s.isEmpty() && val < s.peek()) {
                s.pop();
                answer++;
            }

            if (s.isEmpty() || s.peek() < val) {
                s.push(val);
            }
        }

        System.out.print(answer);
    }
}