import java.util.*;

class Solution {
    
    static int[][] arr;
    static int x_left = 3, y_left=0;
    static int x_right = 3, y_right = 2;
    
    public static String findRoot(int x_move, int y_move, String hand){
        
        double leftMove = Math.abs(x_left-x_move) + Math.abs(y_left-y_move);
        double rightMove = Math.abs(x_right-x_move) + Math.abs(y_right-y_move); 
        
        if(leftMove<rightMove){
            x_left = x_move;
            y_left = y_move;
            return "L";
        }else if(leftMove>rightMove){
            x_right = x_move;
            y_right = y_move;
            return "R";
        }else{
            if(hand.equals("left")){
                x_left = x_move;
                y_left = y_move;
                return "L";
            }else{
                x_right = x_move;
                y_right = y_move;
                return "R";
            }
        }
    }
    
    public String solution(int[] numbers, String hand) {
        
        arr = new int[][]{
            {3, 1},
            {0, 0}, {0, 1}, {0, 2},
            {1, 0}, {1, 1}, {1, 2},
            {2, 0}, {2, 1}, {2, 2}};
        
        Map<Integer, int[]> map = new HashMap<>();
        for(int i=0; i<10; i++){
            map.put(i, arr[i]);
        }
        
        StringBuilder builder = new StringBuilder();
        for(int number : numbers){
            int x_move = map.get(number)[0], y_move = map.get(number)[1];
            if(number==1 || number==4 || number==7){
                x_left = x_move;
                y_left = y_move;
                builder.append("L");
            }else if(number==3 || number==6 || number==9){
                x_right = x_move;
                y_right = y_move;
                builder.append("R");
            }else{
                builder.append(findRoot(x_move, y_move, hand));
            }
        }
        return builder.toString();
    }
}