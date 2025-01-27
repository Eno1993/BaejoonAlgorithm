import java.util.*;

class Solution {
    
    public class Node {
        int start;
        int end;
        Node (int start, int end) {
            this.start = start;
            this.end = end;
        }
        int[] getRoot () {
            return new int[]{start, end};
        }
    }

    public List<Node> hanoi(int n, int s, int m, int e){
        List<Node> root = new ArrayList<>();

        if (n==1) {
            root.add(new Node(s, e));
        } else {
            root.addAll(hanoi(n-1, s, e, m));
            root.add(new Node(s, e));
            root.addAll(hanoi(n-1, m, s, e));
        }
        return root;
    }



    public int[][] solution(int n) {

        List<Node> root = hanoi(n, 1, 2, 3);

        int[][] answer = new int[root.size()][];
        for (int i=0; i<root.size(); i++) {
            answer[i] = root.get(i).getRoot();
        }

        return answer;
    }

}