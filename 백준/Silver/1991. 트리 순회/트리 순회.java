import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main{

    public static Map<String, Node> nodeMap = new HashMap<>();
    public static List<String> order = new ArrayList<>();
    
    public static class Node{
        String name;
        Node left;
        Node right;
        String[] nodeInfo;
        Node(String[] nodeInfo){
            this.nodeInfo = nodeInfo;
            this.name = this.nodeInfo[0];
        }
    }
    
    public static void preOrder(Node node){
        order.add(node.name);
        if(node.left!=null){ preOrder(node.left); }
        if(node.right!=null){ preOrder(node.right); }
    }
    
    public static void inOrder(Node node){
        if(node.left!=null){ inOrder(node.left); }
        order.add(node.name);
        if(node.right!=null){ inOrder(node.right); }
    }
    
    public static void postOrder(Node node){
        if(node.left!=null){ postOrder(node.left); }
        if(node.right!=null){ postOrder(node.right); }
        order.add(node.name);
    }
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for(int n=0; n<N; n++){
            String[] nodeInfo = br.readLine().split(" ");
            nodeMap.put(nodeInfo[0], new Node(nodeInfo));
        }
        for(String nodeName : nodeMap.keySet()){
            Node node = nodeMap.get(nodeName);
            String leftNodeName = node.nodeInfo[1];
            if( !leftNodeName.equals(".")){
                node.left = nodeMap.get(leftNodeName);
            }
            String rightNodeName = node.nodeInfo[2];
            if( !rightNodeName.equals(".")){
                node.right = nodeMap.get(rightNodeName);
            }
        }
        
        preOrder(nodeMap.get("A"));
        String orderStr = order.stream()
            .collect(Collectors.joining());
        System.out.println(orderStr);
        order.clear();
        
        inOrder(nodeMap.get("A"));
        orderStr = order.stream()
            .collect(Collectors.joining());
        System.out.println(orderStr);
        order.clear();
        
        postOrder(nodeMap.get("A"));
        orderStr = order.stream()
            .collect(Collectors.joining());
        System.out.println(orderStr);
        
    }
}