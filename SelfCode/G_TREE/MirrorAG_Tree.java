package SelfCode.G_TREE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
/*
1. You are given a partially written GenericTree class.
2. You are required to complete the body of mirror function.
    The function is expected to create a mirror image of the tree. For more details, check out the question video.
3. Input and Output is managed for you.

 */
public class MirrorAG_Tree {

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
        public Node(){};
        public Node(int n){
            Node a  = new Node();
            a.data = n;
        }
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node createTree(int[] arr){
        Node root = new Node();
        root.data = arr[0];

        Stack<Node> st = new Stack<>();
        st.push(root);
        for(int i = 1; i<arr.length ; i++){
            if(arr[i] == -1){
                st.pop();
            }else{
                Node n = new Node();
                n.data = arr[i];
                st.peek().children.add(n);
                st.push(n);
            }
        }
        return root;
    }
    public static int size(Node node){
        // write your code here
        int ans = 0;
        for(Node child : node.children){
            int cs =   size(child);
            ans += cs;
        }
        return ans+1;
    }

    public static void mirror(Node node){
        // write your code here
        for(Node child : node.children){
            mirror(child);
        }
        // Inbuild Function.
      //  Collections.reverse(node.children);
        int left = 0;
        int right = node.children.size()-1;
        while(left < right){
            Node temp = node.children.get(left);
            node.children.set(left , node.children.get(right));
            node.children.set(right , temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,20,50,-1 , 60 , -1,-1,30 , 70,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = createTree(arr);
       // display(root);
        mirror(root);
        display(root);

    }
}

