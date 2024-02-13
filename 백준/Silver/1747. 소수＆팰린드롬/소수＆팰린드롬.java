import java.io.*;

public class Main{

    public static boolean palindrom(int value){
        if(value<10){
            return true;
        }
        String str = Integer.toString(value);
        int len = str.length();
        for(int i=0; i<len/2; i++){
            if(str.charAt(i)!=str.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }

    public static boolean prime(int value){
        if(value<2){
            return false;
        }
        for(int i=2; i<=value/2; i++){
            if(value%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(true){
            if(palindrom(N)&&prime(N)){
                System.out.print(N);
                break;
            }
            N++;
        }

    }
}