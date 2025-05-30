//  컨베이어 벨트 위의 로봇

import javax.swing.*;
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static class Belt {
        int durability;
        boolean robot;
        Belt(int durability) {
            this.durability = durability;
            this.robot = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int size = 2 * N;
        Belt[] belt = new Belt[size];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            belt[i] = new Belt(Integer.parseInt(st.nextToken()));
        }

        int startIdx = 0;
        int step = 0;

        while (true) {

            startIdx = (startIdx - 1 + size) % size;

            int downIdx = (startIdx + N - 1) % size;
            belt[downIdx].robot = false;

            for (int i = N - 2; i >= 0; i--) {
                int from = (startIdx + i) % size;
                int to = (startIdx + i + 1) % size;

                if (belt[from].robot && !belt[to].robot && belt[to].durability > 0) {
                    belt[from].robot = false;
                    belt[to].robot = true;
                    belt[to].durability--;
                }
            }

            belt[downIdx].robot = false;

            int firstIdx = startIdx;
            if (belt[firstIdx].durability > 0 && !belt[firstIdx].robot) {
                belt[firstIdx].robot = true;
                belt[firstIdx].durability--;
            }

            step++;

            int zeroCount = 0;
            for (int i = 0; i < size; i++) {
                if (belt[i].durability == 0) zeroCount++;
            }

            if (zeroCount >= K) break;
        }

        System.out.println(step);
    }
}