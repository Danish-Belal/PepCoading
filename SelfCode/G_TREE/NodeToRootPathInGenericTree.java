package SelfCode.G_TREE;

import java.util.Arrays;
import java.util.List;
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


    /*
    1. You are given a partially written GenericTree class.
    2. You are required to complete the body of lca function.
            The function is expected to return the lowest common ancestor of two data values that are passed to it.
     */
    public static int lca(Node node, int d1, int d2) {
        // write your code here
        ArrayList<Integer> root1 = nodeToRootPath(node , d1);
        ArrayList<Integer> root2 = nodeToRootPath(node , d2);

//        System.out.println(root1);
//        System.out.println(root2);

        int i = root1.size()-1;
        int j = root2.size()-1;
        while(i >=0 && j>=0 && root1.get(i) == root2.get(j)){
            i--;
            j--;
        }
        return root1.get(i+1);
    }

    public static int distanceBetweenNodes(Node node, int d1, int d2){
        // write your code here
        ArrayList<Integer> root1 = nodeToRootPath(node , d1);
        ArrayList<Integer> root2 = nodeToRootPath(node , d2);
        int i = root1.size()-1;
        int j = root2.size()-1;
        while(i >=0 && j>=0 && root1.get(i) == root2.get(j)){
            i--;
            j--;
        }
        System.out.println(root1);
        System.out.println(root2);
        System.out.println(i);
        System.out.println(j);

        return ((++i) +(++j));

    }


    public static void main(String[] args) {
        int[] arr = {10 ,20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1 ,-1, 90, -1, -1, 40 ,100, -1 ,-1 ,-1};
        Node root = construct(arr);
        int data = 50;
//        ArrayList<Integer> ans = nodeToRootPath(root , data);
//        System.out.println(ans);

       // System.out.println(lca(root , 100,110));
        System.out.println(distanceBetweenNodes(root , 100,110));


    }
}
