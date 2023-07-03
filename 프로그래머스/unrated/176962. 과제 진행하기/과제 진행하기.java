import java.util.*;

class Solution {
    
    class Node{
        String subject;
        Integer start;
        Integer time;
        Node(String subject, int start, int time){
            this.subject = subject;
            this.start = start;
            this.time = time;
        }
    }
    
    public String[] solution(String[][] plans) {
        List<Node> list = new ArrayList<>();
        
        for(String[] plan : plans){
            String subject = plan[0];
            String[] start_str = plan[1].split(":");
            Integer time = Integer.parseInt(plan[2]);
            
            Integer start = Integer.parseInt(start_str[0])*60 + 
                Integer.parseInt(start_str[1]);
            list.add(new Node(subject, start, time));
        }
        
        Collections.sort(list, (o1, o2) -> (o1.start).compareTo(o2.start));
        Queue<Node> q = new LinkedList<>(list);
        Stack<Node> s = new Stack<>();
        
        List<String> answer = new ArrayList<>();
        Node now = q.poll();
        while(true){
            if(q.isEmpty()&&s.isEmpty()){
                answer.add(now.subject);
                break;
            }else if(q.isEmpty()&&!s.isEmpty()){
                answer.add(now.subject);
                while(!s.isEmpty()){
                    Node temp = s.pop();
                    answer.add(temp.subject);
                }
                break;
            }else if(!q.isEmpty()&&s.isEmpty()){
                Node temp = q.peek();
                if((now.start+now.time)<=temp.start){
                    answer.add(now.subject);
                }else{
                    now.time -= (temp.start-now.start);
                    s.push(now);
                }
                now = q.poll();
            }else{
                Node temp = q.peek();
                if((now.start+now.time)<temp.start){
                    int left_time = temp.start-(now.start+now.time);
                    answer.add(now.subject);
                    now = q.poll();
                    while(!s.isEmpty()){
                        if(0<(left_time-s.peek().time)){
                            left_time -=s.peek().time;
                            answer.add(s.pop().subject);
                        }else if(0==(left_time-s.peek().time)){
                            answer.add(s.pop().subject);
                            break;
                        }else{
                            s.peek().time -= left_time;
                            break;
                        }
                    }
                    
                }else if((now.start+now.time)==temp.start){
                    answer.add(now.subject);
                    now = q.poll();
                }else{
                    now.time -= (temp.start-now.start);
                    s.push(now);
                    now = q.poll();
                }
                
            }    
        }
//         for(String str : answer){
//             System.out.print(str + " ");
//         }
        
        return answer.stream().toArray(String[]::new);
    }
}