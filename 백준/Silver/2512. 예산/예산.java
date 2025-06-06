import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int target = Integer.parseInt(br.readLine());

        int low = 0;
        int high = max;
        int answer = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += Math.min(arr[i], mid);
            }

            if (sum <= target) {
                answer = mid;  // 조건 만족 → 더 큰 상한선을 찾아볼 수 있음
                low = mid + 1;
            } else {
                high = mid - 1; // 초과 → 상한선 줄이기
            }
        }

        System.out.println(answer);
    }
}
