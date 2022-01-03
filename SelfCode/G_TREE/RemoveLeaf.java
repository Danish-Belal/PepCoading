package SelfCode.G_TREE;

import java.util.ArrayList;
import java.util.Stack;

public class RemoveLeaf {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();

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

    public static  int maximum(Node node){
        int max = node.data;
        for(Node child : node.children){
            int maxc = maximum(child);
            max = Integer.max(max , maxc);
        }
        return max;
    }
    public static int hight(Node node){
        int mxh = -1;
        for(Node child : node.children){
            mxh = Math.max(mxh , hight(child));
        }
        return mxh+1;

    }
    public static void display(Node root){
        String s = "";
        s += root.data+" -> ";
        for(Node child : root.children){
            s += child.data+", ";
        }
        s += ".";
        System.out.println(s);
        for(Node child : root.children){
            display(child);
        }
    }

    public static void removeLeaves(Node node) {
        // write your code here
       for(int i = 0 ; i<node.children.size() ; i++){
           Node ch = node.children.get(i);
           if(ch.children.size() == 0){
               node.children.remove(i);
               i--;
           }
       }
       for(Node child : node.children){
           removeLeaves(child);
       }

    }


    public static void main(String[] args) {
        int[] arr = {10,20,50,-1 , 60 , -1,-1,30 , 70,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = createTree(arr);
       // display(root);
        removeLeaves(root);
        display(root);
    }
}
