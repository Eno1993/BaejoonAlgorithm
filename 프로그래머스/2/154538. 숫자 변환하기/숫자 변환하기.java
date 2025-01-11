import java.util.*;

class Solution {
    
    public class Node {
        int n;
        int cnt;
        public Node (int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }
    
    public int solution(int x, int y, int n) {
        int answer = -1;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(y, 0));
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.n==x) {
                return now.cnt;
            } else if (now.n < x) {
                continue;
            } else {
                if (now.n%3 == 0)
                    q.offer(new Node(now.n/3, now.cnt+1));
                if (now.n%2 == 0)
                    q.offer(new Node(now.n/2, now.cnt+1));
                q.offer(new Node(now.n-n, now.cnt+1));
            }
        }
        return answer;
    }
}