import java.util.*;

class Solution {
    
    int[] x_ = {-1, 1, 0, 0};
    int[] y_ = {0, 0, -1, 1};
    boolean[][] edge;
   
    public void removeAll (int target, int[][] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                if (arr[i][j]==target) {
                    arr[i][j] = -1;
                }
            }
        }
    }
    
    public boolean edgeCheck (int x, int y, int[][] arr) {
        
        if (edge[x][y]) {
            return true;
        }
        
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            if (edge[now[0]][now[1]] || now[0]==0 || now[0]==arr.length-1 || now[1]==0 || now[1]==arr[0].length-1) {
                return true;
            }
            for (int n = 0; n<4; n++){
                int X = now[0] + x_[n];
                int Y = now[1] + y_[n];
                if (0<=X && X<arr.length && 0<=Y && Y<arr[X].length && arr[X][Y]==-1 && !visited[X][Y]) {
                    visited[X][Y] = true;
                    q.offer(new int[]{X, Y});
                }
            }
            
        }
        
        return false;
    }
    
    public void removeEdge (int target, int[][] arr) {
        
        List<int[]> edgeList = new ArrayList<>();
        
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                if (arr[i][j]==target && edgeCheck(i, j, arr)) {
                    edgeList.add(new int[]{i, j});
                }
            }
        }
        
        for (int[] e : edgeList) {
            arr[e[0]][e[1]] = -1;
            
            for (int n =0; n<4; n++) {
                int x = e[0] + x_[n];
                int y = e[1] + y_[n];
                if (0<=x && x<arr.length && 0<=y && y<arr[x].length) {
                    edge[x][y] = true;
                }
            }
            
        }
    }
    
    public int solution(String[] storage, String[] requests) {
        
        int n = storage.length;
        int m = storage[0].length();
        int[][] arr = new int[n][m];
        edge = new boolean[n][m];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                arr[i][j] =  storage[i].charAt(j) - 'A';
                if (i==0 || i==n-1 || j==0 || j==m-1) {
                    edge[i][j] = true;
                }
                //System.out.print(arr[i][j] + " ");
            } //System.out.println();
        }
        
        for (String request : requests) {
        
            int target = request.charAt(0) - 'A';
            if (request.length()==1) { // 가장 자리만 삭제
                removeEdge(target, arr);
            } else { // 전체 삭제
                removeAll(target, arr);
            }
            
        }
        
        int answer = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (arr[i][j] != -1) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}