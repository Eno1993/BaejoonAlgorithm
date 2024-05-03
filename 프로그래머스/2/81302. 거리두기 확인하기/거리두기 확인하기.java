class Solution {
    public int[] solution(String[][] places){
        
        int[] answer = new int[places.length];
        
        
        for(int i=0; i<answer.length; i++){    
            answer[i] = check(places[i]);
        }
        
        return answer;
    }
    
    int check(String[] place){
        
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(place[i].charAt(j)!='P'){ continue; }
                else{
                    if(j+1<=4&&place[i].charAt(j+1)=='P'){ return 0; }//좌우 거리1 확인
                    if(j+2<=4&&place[i].charAt(j+2)=='P'){//좌우 거리2 확인
                        if(place[i].charAt(j+1)!='X'){ return 0; }
                    }
                    if(i+1<=4&&place[i+1].charAt(j)=='P'){ return 0; }//상하 거리1 확인
                    if(i+2<=4&&place[i+2].charAt(j)=='P'){//상하 거리2 확인
                        if(place[i+1].charAt(j)!='X'){ return 0; }
                    }                    
                    if(0<=j-1){
                        if(0<=i-1&&place[i-1].charAt(j-1)=='P'){
                            if(place[i].charAt(j-1)!='X'||place[i-1].charAt(j)!='X'){ return 0; }
                        }
                        if(i+1<=4&&place[i+1].charAt(j-1)=='P'){
                            if(place[i].charAt(j-1)!='X'||place[i+1].charAt(j)!='X'){ return 0; }    
                        }
                    }
                    if(j+1<=4){
                        if(0<=i-1&&place[i-1].charAt(j+1)=='P'){
                            if(place[i-1].charAt(j)!='X'||place[i].charAt(j+1)!='X'){ return 0; }    
                        }
                        if(i+1<=4&&place[i+1].charAt(j+1)=='P'){
                            if(place[i].charAt(j+1)!='X'||place[i+1].charAt(j)!='X'){ return 0; }    
                        }
                    }
                    
                    
                }
            }
        }
        return 1;
    }
}