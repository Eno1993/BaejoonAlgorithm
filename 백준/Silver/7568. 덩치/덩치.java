//  덩치

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static class Person {

        int index;
        int height;
        int weight;
        int lose;

        Person (int index, int height, int weight) {
            this.index = index;
            this.height = height;
            this.weight = weight;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        List<Person> list = new ArrayList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            Person n = new Person(
                    i,
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));

            for (int j=0; j<list.size(); j++) {
                Person p = list.get(j);
                if (p.weight>n.weight && p.height>n.height) {
                    n.lose++;
                } else if (n.weight>p.weight && n.height>p.height) {
                    p.lose++;
                }

            }
            list.add(n);
        }

        for (int i=0; i<list.size(); i++) {
            Person p = list.get(i);
            arr[p.index] = p.lose + 1;
        }

        StringBuilder builder = new StringBuilder();
        for(int i=0; i<N; i++) {
            builder.append(arr[i]).append(" ");
        }
        System.out.print(builder.toString());
    }
}