import java.util.*;
import java.io.*;

public class Main{

    public static int compare(String a, String b){

        if(a.length()>b.length()){
            return 0; // 불일치, 탐색 가치 O
        }
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)<b.charAt(i)){
                return 1; // 불일치, 탐색 가치 X
            }
        }
        return 2; // 일치, 탐색 가치 X
    }

    public static void main(String[] args) throws Exception{

        //System.setIn(new FileInputStream("C:\\Baekjoon\\Baekjoon\\src\\main\\java\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for(int i=0; i<num; i++){
            list.add(br.readLine());
        }

        Collections.sort(list);

        int answer = num;
        for(int i=0; i<num; i++){
            for(int j=i+1; j<num; j++){
                int res = compare(list.get(i), list.get(j));
                if(res==0){
                    ;
                }else if(res==1){
                    break;
                }else{
                    answer--;
                    break;
                }
            }
        }

        System.out.print(answer);
    }
}