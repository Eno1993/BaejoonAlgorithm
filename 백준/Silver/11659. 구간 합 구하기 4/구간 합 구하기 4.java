import java.io.*;

public class Main{


    public static void main(String[] args) throws IOException{
        //System.setIn(new FileInputStream("C:\\homework\\src\\main\\java\\com\\example\\homework\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int size  = Integer.parseInt(str[0]);
        int answerSize = Integer.parseInt(str[1]);

        int[] arr = new int[size+1];
        String[] strArr = br.readLine().split(" ");
        for(int i=1; i<=size; i++){
            arr[i] = Integer.parseInt(strArr[i-1]) + arr[i-1];
        }

        for(int i=0; i<answerSize; i++){
            String[] temp = br.readLine().split(" ");
            System.out.println(arr[Integer.parseInt(temp[1])]-arr[Integer.parseInt(temp[0])-1]);

        }
    }
}