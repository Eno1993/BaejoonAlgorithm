class Solution {
    

    public long solution(int[] sequence) {
        
        long res = 0;
        
        long answer = 0;
        long answer_verse = 0;
        
        int start = 1;
        
        for (int i=0; i<sequence.length; i++) {
            answer += sequence[i] * start;
            answer_verse += sequence[i] * start * -1;
            start *= -1;
            
            answer = answer < 0 ? 0 : answer;
            answer_verse = answer_verse < 0 ? 0 : answer_verse;
            
            if (res < answer)
                res = answer;
            if (res < answer_verse)
                res = answer_verse;
        } 
        
        return res;
    }
}