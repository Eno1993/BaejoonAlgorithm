//  피보나치

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[44];
        arr[0] = 1;
        arr[1] = 2;
        for (int i=2; i<44; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            int value = Integer.parseInt(br.readLine());

            List<Integer> list = new ArrayList<>();
            for(int index = 43; 0<=index; index--) {
                if (0 <= value-arr[index]) {
                    list.add(arr[index]);
                    value -= arr[index];
                }

                if (value==0) {
                    break;
                }
            }
            StringBuilder builder = new StringBuilder();
            for (int n = list.size()-1; 0<=n; n--) {
                builder.append(list.get(n)).append(" ");
            }
            System.out.println(builder.toString());
        }
    }

}