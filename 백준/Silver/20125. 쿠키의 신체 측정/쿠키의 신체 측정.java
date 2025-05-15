//  쿠키의 신체 측정

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];

        for (int i=0; i<N; i++) {
            String temp = br.readLine();
            for (int j=0; j<N; j++) {
                arr[i][j] = temp.charAt(j);
            }
        }

        int[] answer = new int[5];
        StringBuilder builder = new StringBuilder();

        f : for (int i=0; i<N; i++) {
            for (int j=1; j<N-1; j++) {
                if (arr[i][j-1]=='_' && arr[i][j]=='*' && arr[i][j+1]=='_') {
                    int x = i+1;
                    int y = j;
                    builder.append(x+1).append(" ").append(y+1).append('\n');

                    for (int n=y-1; 0<=n; n--) {
                        if (arr[x][n]!='*') {
                            break;
                        }
                        answer[0]++;
                    }

                    for (int n=y+1; n<N; n++) {
                        if (arr[x][n]!='*') {
                            break;
                        }
                        answer[1]++;
                    }

                    for (int n=x+1; n<N; n++) {
                        if (arr[n][y]!='*') {
                            break;
                        }
                        answer[2]++;
                        x = n;
                    }

                    for (int n=x+1; n<N; n++) {
                        if (arr[n][y-1]!='*') {
                            break;
                        }
                        answer[3]++;
                    }

                    for (int n=x+1; n<N; n++) {
                        if (arr[n][y+1]!='*') {
                            break;
                        }
                        answer[4]++;
                    }
                    break f;
                }
            }
        }

        builder.append(answer[0]).append(" ")
                .append(answer[1]).append(" ")
                .append(answer[2]).append(" ")
                .append(answer[3]).append(" ")
                .append(answer[4]).append(" ");
        System.out.print(builder.toString());
    }
}