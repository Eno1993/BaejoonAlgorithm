class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(0<storey){
            int left = storey%10;
            if(left<5){
                answer += left;
                storey = storey/10;
            }else if(left==5){
                int nextLeft = (storey/10)%10;
                if(5<=nextLeft){
                    answer += left;
                    storey += 10;
                    storey = storey/10;
                }else{
                    answer += left;
                    storey = storey/10;
                }
            }else if(5<left){
                answer += (10-left);
                storey += 10;
                storey = storey/10;
            }
            //System.out.println(storey + "  :  " + answer);
        }
        return answer;
    }
}