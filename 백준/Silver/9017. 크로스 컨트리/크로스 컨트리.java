//  크로스 컨트리

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int t=0; t<testCase; t++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new LinkedList<>();
            Map<Integer, List<Integer>> map = new HashMap<>(); // 점수, 인원수,  인덱스

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                int v = Integer.parseInt(st.nextToken());
                q.offer(v);
                map.computeIfAbsent(v, value -> new ArrayList<>()).add(i);
            }

            List<Integer> list = new ArrayList<>();
            while(!q.isEmpty()) {
                int v = q.poll();
                if (map.get(v).size()==6) {
                    list.add(v);
                }
            }
            map.clear();

            for (int i=0; i<list.size(); i++) {
                map.computeIfAbsent(list.get(i), value -> new ArrayList<>()).add(i);
            }
            
            int answer = 0;
            int score = Integer.MAX_VALUE;
            int lastIndex = Integer.MAX_VALUE;

            for (int key : map.keySet()) {
                List<Integer> now = map.get(key);
                if (now.size()==6) {
                    int hap = 0;
                    for (int j=0; j<4; j++) {
                        hap += now.get(j);
                    }
                    if (hap < score) {
                        answer = key;
                        score = hap;
                        lastIndex = now.get(4);
                    } else if (hap == score) {
                        if (now.get(4) < lastIndex) {
                            answer = key;
                            lastIndex = now.get(4);
                        }
                    }

                }
            }
            System.out.println(answer);
        }

    }
}