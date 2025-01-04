import java.lang.Math;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
    
        for (int x=1; x<=r1; x++) {
            double y2 = Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2));
            double y1 = Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2));
            
            int int_y2 = (int) y2;
            int int_y1 = y1%1 == 0 ? (int)y1 : (int)y1 + 1; 
            
            //System.out.print("x : "+x+",  y1 : "+int_y1 +",  y2 : " + int_y2);
            answer += int_y2-int_y1+1;
            //System.out.println(",  answer : "+answer);
        }
        
        
        for (int x=r1+1; x<=r2; x++) {
            double y2 = Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2));
            
            int int_y2 = (int) y2;
            int int_y1 = 0;
            
            //System.out.print("x : "+x+",  y1 : "+int_y1 +",  y2 : " + int_y2);
            answer += int_y2-int_y1+1;
            //System.out.println(",  answer : "+answer);
        }
        
    
        return answer*4;
    }
}