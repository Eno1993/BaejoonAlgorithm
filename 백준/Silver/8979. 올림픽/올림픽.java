//  올림픽

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static class Nation {
        int index;
        int score;
        int gold;
        int silver;
        int copper;
        Nation (int index, int gold, int silver, int copper) {
            this.index = index;
            this.score = 0;
            this.gold = gold;
            this.silver = silver;
            this.copper = copper;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Nation> list = new ArrayList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int copper = Integer.parseInt(st.nextToken());
            Nation nation = new Nation(index, gold, silver, copper);

            for (Nation n : list) {
                if (n.gold > nation.gold) {
                    nation.score += 1;
                } else if (n.gold == nation.gold) {
                    if (n.silver > nation.silver) {
                        nation.score += 1;
                    } else if (n.silver == nation.silver) {
                        if (n.copper > nation.copper) {
                            nation.score += 1;
                        } else if (n.copper == nation.copper) {
                            ;
                        } else {
                            n.score += 1;
                        }
                    } else {
                        n.score += 1;
                    }
                } else {
                    n.score += 1;
                }
            }
            list.add(nation);
        }

        for (Nation nation : list) {
            if (nation.index == K) {
                System.out.print(nation.score + 1);
                break;
            }
        }

    }
}