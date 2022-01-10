package SelfCode.G_TREE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/*
1. You are given a partially written GenericTree class.
2. You are require to complete the body of function IterativePreandPostOrder.
 The function does not use recursion and prints preorder and postorder of the tree.
 Both orders are printed in separate lines (preorder first, followed by post order in next line). Elements in an order are separated by space.

 Sample Input

24
10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1

Sample Output

10 20 -50 60 30 70 -80 110 -120 90 40 -100
-50 60 20 70 110 -120 -80 90 30 -100 40 10
 */
public class ItrativePreorderandPost {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    private static  class Pair{
        Node node;
        int state;

        public Pair(Node node , int stat){
            this.node = node;
            this.state = stat;
        }
        public Pair(){}
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

    public static void IterativePreandPostOrder(Node node) {
        // write your code here
        String pre = "";
        String post = "";
        Stack<Pair> st = new Stack<>();

        st.push(new Pair(node , 0));

        while (st.size() != 0){
            Pair tos = st.peek();
            if(tos.state == 0){
                pre += tos.node.data+" ";
                if(tos.node.children.size() >=1){
                    st.push(new Pair(tos.node.children.get(0) , 0));
                }
                tos.state++;
            }else  if(tos.state >= tos.node.children.size()){
                post += tos.node.data+" ";
                st.pop();
            }else{
                st.push(new Pair(tos.node.children.get(tos.state) , 0));
                tos.state++;
            }
        }
        System.out.println(pre);
        System.out.println(post);


    }

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int[] arr = new int[n];
//        String[] values = br.readLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(values[i]);
//        }
//
        int[] arr = {10 ,20, -50, -1, 60, -1, -1, 30, 70, -1, -80, 110, -1, -120, -1 ,-1, 90, -1, -1, 40, -100, -1, -1, -1};

        Node root = construct(arr);
        IterativePreandPostOrder(root);
    }
}
