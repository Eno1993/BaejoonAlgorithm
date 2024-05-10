import java.util.*;

class Solution {
    
    class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    int[] x_ = {-1, 1, 0, 0};
    int[] y_ = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        int answer = 0;
        
        int[] oilArr = new int[land[0].length];
        
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[i].length; j++){
                if(land[i][j]==1){
                    land[i][j] = 0;
                    Node node = new Node(i, j);
                    
                    Set<Integer> columns = new HashSet<>();
                    int size = 1;
                    columns.add(j);
                    
                    Queue<Node> q = new LinkedList<>();
                    q.offer(node);
                    
                    while(!q.isEmpty()){                        
                        Node now = q.poll();
                        
                        for(int n=0; n<4; n++){
                            int x = now.x + x_[n];
                            int y = now.y + y_[n];
                            if(0<=x && x<land.length && 0<=y && y<land[0].length && land[x][y]==1){
                                land[x][y] = 0;
                                Node next = new Node(x, y);
                                
                                size += 1;
                                columns.add(y);
                                
                                q.offer(next);
                            }
                        }
                    }
                    for(int col : columns) {
                        oilArr[col] += size;
                    }
                }
            }
        }
        
        for(int j=0; j<oilArr.length; j++){
            answer = answer<oilArr[j] ? oilArr[j] : answer;
        }
        
        return answer;
    }
}