//  단어 공부

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();

        int c;
        while ((c = br.read()) != '\n') {

            if (97 <= c) {
                c -= 32;
            }

            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c)+1);
            }
        }

        int maxValue = 0;
        int cnt = 0;
        boolean check = true;
        for (int key : map.keySet()) {
            if (cnt < map.get(key)) {
                maxValue = key;
                cnt = map.get(key);
                check = true;
            } else if (cnt == map.get(key)){
                check = false;
            }
        }

        if (check) {
            char answer = (char) maxValue;
            System.out.print(answer);
        } else {
            System.out.print("?");
        }
    }
}