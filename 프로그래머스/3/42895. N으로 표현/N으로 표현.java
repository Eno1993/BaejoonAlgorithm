import java.util.*;

class Solution {
    
    List<Set<Integer>> list = new ArrayList<>();
    
    public int num_n (int num, int n) {
        
        int res = num;
        for (int i=1; i<n; i++) {
            res = res*10 + num;
        }
        return res;
    }
    
    public int solution(int N, int number) {
        
        if (N==number) {
            return 1;
        }
        
        for (int i=0; i<=8; i++) {
            list.add(new HashSet<>());
        }
        list.get(1).add(num_n(N, 1));
        
        for (int i=2; i<=8; i++) {
            list.get(i).add(num_n(N, i));
            for (int l=1; l<=i-1; l++) {
                int r = i-l;
                for (int left : list.get(l)) {
                    for (int right : list.get(r)) {
                        list.get(i).add(left+right);
                        if (left > right) {
                           list.get(i).add(left-right); 
                        }
                        list.get(i).add(left*right);
                        if (left/right > 0 && left%right==0) {
                            list.get(i).add(left/right);
                        }
                    }
                }
            }
            if (list.get(i).contains(number)) {
                return i;
            }
        }
        
        //for (int i=1; i<=8; i++) {
        //    if (list.get(i).contains(number)) {
        //        return i;
        //  }
        //}
        
        return -1;
    }
}