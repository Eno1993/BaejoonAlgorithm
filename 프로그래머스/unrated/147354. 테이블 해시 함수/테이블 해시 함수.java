import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[col-1]==o2[col-1]){
                    return o2[0]-o1[0];
                }else{
                    return o1[col-1]-o2[col-1]; 
                }
            }
        });
        
        for(int i=row_begin; i<=row_end; i++){
            int temp = 0;
            for(int j=0; j<data[i-1].length; j++){
                temp += (data[i-1][j] % i);
            }
            answer = answer ^ temp;
        }
        
        return answer;
    }
}