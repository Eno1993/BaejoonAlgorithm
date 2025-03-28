import java.util.*;

class Solution {
    
    int[] x_ = {1, -1, 0, 0};
    int[] y_ = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        maps[0][0] = 0;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            for (int n=0; n<4; n++) {
                int xx = now[0] + x_[n];
                int yy = now[1] + y_[n];
                
                if (xx==maps.length-1 && yy==maps[0].length-1) {
                    return now[2]+2;
                }
                
                if (0<=xx && xx<maps.length && 0<=yy && yy<maps[0].length) {
                    if (maps[xx][yy]==1) {
                        q.offer(new int[]{xx, yy, now[2]+1});
                        maps[xx][yy] = 0;
                    }
                }
            }        
        }
        return -1;
    }
}