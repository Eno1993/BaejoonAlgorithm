class Solution {
    
    public int[] solution(int[] sequence, int k) {
        int[] answer = {-1, -1};
        
        int left=0;
        int right=0;
        int hap = sequence[0];
        
        while(right<sequence.length){
            while(hap<k && right<sequence.length-1){
                right++;
                hap += sequence[right];
            }
            
            while(k<hap && left<right){
                hap -= sequence[left];
                left++;
            }
            
            if(k==hap){
                if(answer[0]==-1){
                    answer[0] = left;
                    answer[1] = right;
                }else{
                    if(right-left<answer[1]-answer[0]){
                        answer[0] = left;
                        answer[1] = right;
                    }else if(right-left==answer[1]-answer[0]){
                        if(left<answer[0]){
                            answer[0] = left;
                            answer[1] = right;
                        }
                    }
                }
            }

            if(right<sequence.length-1){
                right++;
                hap += sequence[right];
                hap -= sequence[left];
                left++;
            }else{
                break;
            }
            
        }
        return answer;
    }
}