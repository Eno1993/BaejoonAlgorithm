import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main{
    public static List<Integer> list = new ArrayList<>();
    public static Set<String> answer = new HashSet<>();
    public static void dfs(){
        StringBuilder builder = new StringBuilder();
        String str = 
            list.stream()
            .map(value -> String.valueOf(value))
            .collect(Collectors.joining("+"));
        answer.add(str);
        
        for(int i=0; i<list.size()-1; i++){
            int a = list.get(i);
            int b = list.get(i+1);
            if(a+b<=3){
                list.remove(i);
                list.remove(i);
                list.add(i, a+b);
                dfs();
                list.remove(i);
                list.add(i, b);
                list.add(i, a);
            }
        }
    }
    
    public static void main(String[] args)throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] read = br.readLine().split(" ");
        int N = Integer.parseInt(read[0]);
        int K = Integer.parseInt(read[1]);
        
        for(int i=0; i<N; i++){
            list.add(1);
        }
        
        dfs();
        
        List<String> ans = new ArrayList<String>(answer);
        Collections.sort(ans);
        
        if(ans.size()<K){
            System.out.print(-1);
        }else{
            System.out.print(ans.get(K-1));
        }
        
        
    }
}