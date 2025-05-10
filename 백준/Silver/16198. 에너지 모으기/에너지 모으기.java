import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int answer = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int v = Integer.parseInt(st.nextToken());
            list.add(v);
        }

        dfs(list, 0);
        
        System.out.print(answer);
    }

    public static void dfs(List<Integer> list, int value) {
        if (list.size() == 2) {
                answer = Math.max(answer, value);
            } else {
                for (int i=1; i<list.size()-1; i++) {
                    int tempHap = list.get(i-1)*list.get(i+1);
                    int tempValue = list.get(i);
                    list.remove(i);
                    dfs(list, value + tempHap);
                    list.add(i, tempValue);
                }
            }
    }
}