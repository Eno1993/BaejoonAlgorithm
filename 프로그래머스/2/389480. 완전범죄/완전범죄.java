import java.util.*;

class Solution {
    
    int answer = Integer.MAX_VALUE;
    
    public void dfs (int[][] info, int index, int n, int m, int ans) {
        
        if (index == info.length) {
            answer = Math.min(ans, answer);
            return;
        }
        
        if (answer <= ans) {
            return;
        }
        
        if (info[index][1] < m) {
            dfs(info, index+1, n, m-info[index][1], ans);
        }
        
        if (info[index][0] < n) {
            dfs(info, index+1, n-info[index][0], m, ans+info[index][0]);
        }
        
    }
    
    
    
    public int solution(int[][] info, int n, int m) {
        
        Arrays.sort(info, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(b[0], a[0]); // [0] 오름차순
            } else {
                return Integer.compare(b[1], a[1]); // [1] 내림차순
            }
        });
        
        dfs(info, 0, n, m, 0);
        return answer==Integer.MAX_VALUE ? -1 : answer;
    }
}