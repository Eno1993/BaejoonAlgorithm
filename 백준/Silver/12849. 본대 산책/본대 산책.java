import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer D = Integer.parseInt(br.readLine());
        
	    int[][] arr = 
    	{{0, 1, 1, 0, 0, 0, 0, 0}, 
	    {1, 0, 1, 1, 0, 0, 0, 0},
        {1, 1, 0, 1, 1, 0, 0, 0}, 
        {0, 1, 1, 0, 1, 1, 0, 0},   
        {0, 0, 1, 1, 0, 1, 1, 0},
        {0, 0, 0, 1, 1, 0, 0, 1},
        {0, 0, 0, 0, 1, 0, 0, 1},
        {0, 0, 0, 0, 0, 1, 1, 0}};
	
    	int[] now = {1, 0, 0, 0, 0, 0, 0, 0};
	
    	for(int d=0; d<D; d++){
    		int[] next = new int[8];
    		for(int i=0; i<8; i++){
    			for(int j=0; j<8; j++){
    				if(i!=j&&arr[i][j]==1){
    					next[j] += now[i];
    					next[j] %= 1000000007;
    				}
    			}
    		}
    		now = next;
    	}
	    System.out.print(now[0]);
    }
}