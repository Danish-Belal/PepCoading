package SelfCode.G_TREE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;
/*
1. You are given a partially written GenericTree class.
2. You are required to complete the body of IsSymmetric function.
    The function is expected to check if the tree is symmetric, if so return true otherwise return false.
      For knowing symmetricity think of face and hand. Face is symmetric while palm is not.
    Also, we are check only smmetricity of shape and not content. Check the question video for clarity.
 */
public class IsTreeSymmetric {
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

    public static int size(Node node) {
        int s = 0;

        for (Node child : node.children) {
            s += size(child);
        }
        s += 1;

        return s;
    }

    public static int max(Node node) {
        int m = Integer.MIN_VALUE;

        for (Node child : node.children) {
            int cm = max(child);
            m = Math.max(m, cm);
        }
        m = Math.max(m, node.data);

        return m;
    }

    public static int height(Node node) {
        int h = -1;

        for (Node child : node.children) {
            int ch = height(child);
            h = Math.max(h, ch);
        }
        h += 1;

        return h;
    }


    public static boolean areMirror(Node n1, Node n2) {
        // write your code here
        if(n1.children.size() != n2.children.size()){
            return false;
        }
        for(int i = 0  , j = n2.children.size()-1;i <n1.children.size() && j>=0 ; i++ , j--){
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(j);
            if(!areMirror(c1,c2)) return false;
        }
        return true;
    }

    public static boolean IsSymmetric(Node node) {
        // write your code here
        for(int i = 0; i< node.children.size() ; i++){
            if(!areMirror(node.children.get(i) , node.children.get(node.children.size()-1-i))) return false;
        }
        return true;


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        boolean sym = IsSymmetric(root);
        System.out.println(sym);
        // display(root);
    }
}
