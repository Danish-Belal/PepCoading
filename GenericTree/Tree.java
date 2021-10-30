package GenericTree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class Tree {
    public static class Node{
        int data;
        ArrayList<Node> children;
        public Node(){
            children = new ArrayList<>();
        }
    }
    public static Node construct(int[] arr){
        Node rootNode = new Node();
        rootNode.data = arr[0];

        Stack<Node> st = new Stack<>();
        st.push(rootNode);
        for(int i = 1 ; i<arr.length ; i++){
            if(arr[i] == -1){
                st.pop();
            }else{
                Node n = new Node();
                n.data = arr[i];
                st.peek().children.add(n);
                st.push(n);
            }
        }

        return rootNode;
    }
    public static  void display(Node node){
        String s = "";
        s += node.data+" -> ";
        for(Node child : node.children){
            s+= child.data + " , ";
        }
        s += ".";
        System.out.println(s);
        for(Node child : node.children){
            display(child);
        }
    }
    public static void main(String[] args) {
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,-1,80,-1,-1,40,100,-1,-1,-1};
        Node root = construct(arr);
        display(root);

    }
}
