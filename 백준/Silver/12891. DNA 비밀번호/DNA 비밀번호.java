import java.io.*;

public class Main{

    public static class Dna{
        private final int[] critical;
        private int[] now;
        public Dna(int[] arr){
            critical = arr;
            now = new int[4];
        }

        public void inNout(char c, int flag){
            if(c=='A'){
                now[0] += flag;
            }else if(c=='C'){
                now[1] += flag;
            }else if(c=='G'){
                now[2] += flag;
            }else if(c=='T'){
                now[3] += flag;
            }
        }

        public boolean check(){
            for(int i=0; i<4; i++){
                if(now[i]<critical[i]){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException{

        //System.setIn(new FileInputStream("/Users/inho/IdeaProjects/homework/src/main/java/com/example/homework/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] lenStr = br.readLine().split(" ");
        final int strLen = Integer.parseInt(lenStr[0]);
        final int subLen = Integer.parseInt(lenStr[1]);

        final String str = br.readLine();
        final String[] dnaStr = br.readLine().split(" ");
        int[] dnaInt = new int[dnaStr.length];
        for(int i=0; i<4; i++){
            dnaInt[i] = Integer.parseInt(dnaStr[i]);
        }
        Dna dna = new Dna(dnaInt);
        int left = 0;
        int right = 0;
        for(; right<subLen; right++){
            dna.inNout(str.charAt(right), 1);
        }
        right--;

        int answer = 0;
        while(true){
            if(dna.check()){
                answer++;
            }
            if(right+1==strLen){
                break;
            }

            right++;
            dna.inNout(str.charAt(right), 1);
            dna.inNout(str.charAt(left), -1);
            left++;
        }
        System.out.print(answer);
    }
}