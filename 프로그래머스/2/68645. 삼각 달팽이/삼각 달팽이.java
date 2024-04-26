import java.util.*;

class Solution {
    public int[] solution(int n) {
        int m = n;
        List<Integer> list = new ArrayList<>();
        
        int[][] arr = new int[n][n];
        int x=-1; 
        int y=0;
        int num = 1;
        
        while(true){
            if(n==0){
                break;
            }
            //down
            for(int i=1; i<=n; i++){
                x++;
                arr[x][y] = num;
                num++;
            }
            n--;
            
            if(n==0){
                break;
            }
            //right
            for(int i=1; i<=n; i++){
                y++;
                arr[x][y] = num;
                num++;
            }
            n--;
            
            if(n==0){
                break;
            }
            //up
            for(int i=1; i<=n; i++){
                x--;
                y--;
                arr[x][y] = num;
                num++;
            }
            n--;
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<i+1; j++){
                list.add(arr[i][j]);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}