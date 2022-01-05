package SelfCode.G_TREE;

import java.util.Arrays;
import java.util.Stack;
import java.util.ArrayList;

public class NodeToRootPathInGenericTree {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
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

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        // write your code here
       if(node.data == data){
           ArrayList<Integer> ans = new ArrayList<>();
           ans.add(node.data);
           return ans;
       }
       for(Node child : node.children){
         ArrayList<Integer> call =  nodeToRootPath(child , data);
         if(call.size() > 0){
             call.add(node.data);
             return call;
         }
       }

       return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] arr = {};
        Node root = construct(arr);
        int data = 40;
        ArrayList<Integer> ans = nodeToRootPath(root , data);
       for(int i  =0 ; i<ans.size() ; i++){
           System.out.print(i+" ");
       }
    }
}
