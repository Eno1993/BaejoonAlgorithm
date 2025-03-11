//  회전 초밥

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] additional = new int[k];
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int answer = Integer.MIN_VALUE;

        for (int i=0; i<k; i++) {
            int value = Integer.parseInt(br.readLine());

            additional[i] = value;
            q.offer(value);
            if (!map.containsKey(value)) {
                map.put(value, 1);
            } else {
                map.put(value, map.get(value) + 1);
            }
        }

        if (map.containsKey(c)) {
            answer = map.keySet().size();
        } else {
            answer = map.keySet().size() + 1;
        }


        for (int i=k; i<n; i++) {

            int out = q.poll();
            map.computeIfPresent(out, (key, value) -> {
               if (1 < value) {
                   return value -1;
               } else {
                   return null;
               }
            });

            int in = Integer.parseInt(br.readLine());
            q.offer(in);
            if (!map.containsKey(in)) {
                map.put(in, 1);
            } else {
                map.put(in, map.get(in) + 1);
            }

            if (map.containsKey(c)) {
                answer = Math.max(answer, map.keySet().size());
            } else {
                answer = Math.max(answer, map.keySet().size() + 1);
            }

        }

        for (int i=0; i<additional.length; i++) {
            int out = q.poll();
            map.computeIfPresent(out, (key, value) -> {
                if (1 < value) {
                    return value -1;
                } else {
                    return null;
                }
            });

            int in = additional[i];
            q.offer(in);
            if (!map.containsKey(in)) {
                map.put(in, 1);
            } else {
                map.put(in, map.get(in) + 1);
            }

            if (map.containsKey(c)) {
                answer = Math.max(answer, map.keySet().size());
            } else {
                answer = Math.max(answer, map.keySet().size() + 1);
            }
        }

        System.out.print(answer);
    }
}