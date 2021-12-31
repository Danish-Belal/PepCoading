package SelfCode.G_TREE;
/*
        Generic Tree is a tree which can have n number of child.
        It has a node data and arrayList od Node which contain address of Children Node.
 */
import java.util.ArrayList;
import java.util.Stack;

public class CreateGTree {

    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static Node createTree(int[] arr){
        Node root = new Node();
        root.data = arr[0];

        Stack<Node> st = new Stack<>();
        st.push(root);

        for(int i = 1 ; i<arr.length ; i++){
            if(arr[i] == -1){
                st.pop();
            }else{
                Node node = new Node();
                node.data = arr[i];
                st.peek().children.add(node);
                st.push(node);
            }
        }
        return root;
    }

    public static void display(Node node){
        String s = "";
        s += node.data+" -> ";
        for (Node child : node.children){
            s += child.data + ", ";
        }
        s += ". ";
        System.out.println(s);
        for(Node child : node.children){
            display(child);
        }
    }
    public static void main(String args[]){
        int[] arr = {10,20,50,-1 , 60 , -1,-1,30 , 70,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = createTree(arr);
        display(root);

    }
}
