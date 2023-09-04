import java.io.*;

public class Main{

    static int answer = 0;
    static int[] cal;

    public static void dfs(int N, int r, int c){

        if(N==1){
            if(r==0&&c==0){
                answer += 0;
            }else if(r==0&&c==1){
                answer += 1;
            }else if(r==1&&c==0){
                answer += 2;
            }else if(r==1&&c==1){
                answer += 3;
            }
            return;
        }

        if(0<=r&&r<cal[N-1]&&0<=c&&c<cal[N-1]){
            dfs(N-1, r, c);
        }else if(0<=r&&r<cal[N-1]&&cal[N-1]<=c&&c<cal[N]){
            answer += cal[N-1]*cal[N-1];
            dfs(N-1, r, c-cal[N-1]);
        }else if(cal[N-1]<=r&&r<cal[N]&&0<=c&&c<cal[N-1]){
            answer += 2*cal[N-1]*cal[N-1];
            dfs(N-1, r-cal[N-1], c);
        }else if(cal[N-1]<=r&&r<cal[N]&&cal[N-1]<=c&&c<cal[N]){
            answer += 3*cal[N-1]*cal[N-1];
            dfs(N-1, r-cal[N-1], c-cal[N-1]);
        }
    }

    public static void main(String[] arsg) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");

        int N = Integer.parseInt(strArr[0]);
        int r = Integer.parseInt(strArr[1]);
        int c = Integer.parseInt(strArr[2]);

        cal = new int[N+1];
        for(int i=0; i<=N; i++){
            cal[i] = (int)Math.round(Math.pow(2, i));
        }

        dfs(N, r, c);

        System.out.print(answer);
    }
}