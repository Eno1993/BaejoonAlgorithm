class Solution {
    
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] in = new int[24];
        int[] out = new int[24];
        
        int max = m;
        
        for (int time=0; time<24; time++) {
            int player = players[time];
            
            if (max <= player) { // 서버 증설이 필요 한 경우
                int left_player = player - (max-1);
                int server = 0 < left_player%m ? 
                    left_player/m + 1 : left_player/m;
                max += server*m;
                in[time] = server;
                if (time+k-1 <= 23) {
                    out[time+k-1] = server;
                }
                
                answer += server;
            }
            
            max -= out[time]*m;
                
        }
        
        for (int i=0; i<23; i++) {
            System.out.print(in[i] + " ");
        }System.out.println();
        for (int i=0; i<23; i++) {
            System.out.print(out[i] + " ");
        }
        
        return answer;
    }
}