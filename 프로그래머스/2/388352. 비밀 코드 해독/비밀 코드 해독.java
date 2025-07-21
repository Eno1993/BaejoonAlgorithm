class Solution {
    
    int answer = 0;
    
    public boolean compare (int[] a, int[] b, int cnt) {
        
        int check = 0;
        
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if (a[i]==b[j]) {
                    check++;
                }
            }
        }
        //System.out.print(check + " ");
        return check==cnt;
    }
    
    
    public void check (int[] target, int[][] q, int[] ans) {
        
        //System.out.print(target[0] + " "+target[1]+" "+target[2] + " "+target[3]+ " "+target[4]+" : ");
        
        int try_cnt = q.length;
        
        for (int i=0; i<try_cnt; i++) {
            int[] a = q[i];
            if (!compare(a, target, ans[i])) {
                System.out.println();
                return;
            }
        }
        
        answer++;
    }
    

    public int solution(int n, int[][] q, int[] ans) {
        
        int[] target = null;
        for (int a=1; a<=n-4; a++) {
            for (int b = a+1; b<=n-3; b++) {
                for (int c = b+1; c<=n-2; c++) {
                    for (int d = c+1; d<=n-1; d++) {
                        for (int e = d+1; e<=n; e++) {
                            target = new int[]{a, b, c, d, e};
                            check(target, q, ans);
                        }
                    }                    
                }
            }
        }
        

        return answer;
    }
}