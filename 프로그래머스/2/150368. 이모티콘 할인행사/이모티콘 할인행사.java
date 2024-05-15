class Solution {
    
    public int[] answer = new int[2];
    public int[] disTemp = {10, 20, 30, 40};
    public int[] discount;
    
    public void cal(int[][] users, int[] emoticons){

        int plusAccount = 0;
        int sales = 0;
        
        for(int[] user : users){
            int userSale = 0;
            for(int i=0; i<emoticons.length; i++){
                if(user[0]<=discount[i]){
                    userSale += emoticons[i]*(100-discount[i])/100;
                }
            }
            if(user[1]<=userSale){
                plusAccount++;
                userSale = 0;
            }        
            sales += userSale;
        }
        if(answer[0]<plusAccount){
            answer[0] = plusAccount;
            answer[1] = sales;
        }else if(answer[0]==plusAccount){
            if(answer[1]<sales){
                answer[1] = sales;
            }
        }
    }
    
    public void dfs(int[][] users, int[] emoticons, int index){
        if(discount.length<=index){
            cal(users, emoticons);
            return;
        }
            
        for(int disVal : disTemp){
            discount[index] = disVal;
            dfs(users, emoticons, index+1);
        }
    }
    
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        discount = new int[emoticons.length];
        dfs(users, emoticons, 0);
        
        return answer;
    }
}