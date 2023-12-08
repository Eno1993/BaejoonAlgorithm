import java.util.*;
import java.io.*;

public class Main{
    
    public static long answer;
    public static int[] src;
    public static int[] tmp;
    
    public static void mergeSort(int start, int end) {
        if (start<end) {
            int mid = (start+end) / 2;
            mergeSort(start, mid);
            mergeSort(mid+1, end);
            
            int p = start;
            int q = mid + 1;
            int idx = p;
            while (p<=mid || q<=end) {
                if (q>end || (p<=mid && src[p]<=src[q])) {
                    if(idx<p){
                        answer += p-idx;
                    }
                    tmp[idx++] = src[p++];
                } else {
                    if(idx<q){
                        answer += q-idx;
                    }
                    tmp[idx++] = src[q++];
                }
            }
            for (int i=start;i<=end;i++) {
                src[i]=tmp[i];
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        answer = 0;
        src = new int[N];
        tmp = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            src[i] = Integer.parseInt(st.nextToken());
        }
        
        mergeSort(0, src.length-1);
        System.out.print(answer);
    }
}