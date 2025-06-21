//  블로그

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        int hap = 0;
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i<X) {
                hap += arr[i];
            } else {
                hap += arr[i];
                hap -= arr[i-X];
            }

            if (map.containsKey(hap)) {
                map.put(hap, map.get(hap)+1);
            } else {
                map.put(hap, 1);
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort(Comparator.reverseOrder());

        if (list.get(0) == 0) {
            System.out.print("SAD");
        } else {
            System.out.println(list.get(0));
            System.out.print(map.get(list.get(0)));
        }

    }
}