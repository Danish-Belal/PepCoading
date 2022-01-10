package SelfCode.G_TREE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/*

    1. You are given a partially written GenericTree class.
    2. You are required to find and print the diameter of tree.
    THe diameter is defined as maximum number of edges between any two nodes in the tree. Check the question video for clarity.
    3. Input is managed for you.

    Sample Input
    20
    10 20 -50 -1 60 -1 -1 30 -70 -1 80 -1 90 -1 -1 40 -100 -1 -1 -1

    Sample Output
    4
 */
public class DiameterOfTree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    private static class pair{
        int ht = -1;
        int diameter = -1;
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

    static  int diameter = 0;
    static  int hight (Node node){
        int maxh  = -1;
        int smaxh  = -1;
        for(Node child : node.children){
            int hoc = hight(child);
            if(hoc > maxh){
                maxh = hoc;
                smaxh = maxh;
            }else if(hoc > smaxh){
                smaxh = hoc;
            }
        }
        diameter = Math.max(diameter , maxh+smaxh+2);
        return maxh+1;
    }

    public  static  pair diameter(Node node){
        pair mp = new pair();
        int maxh  = -1;
        int smaxh  = -1;
        for (Node child : node.children){
            pair cp = diameter(child);
            if(cp.ht > maxh){
                smaxh = maxh;
                maxh = cp.ht;
            }else if(cp.ht > smaxh){
                smaxh = cp.ht;
            }
        }
        mp.diameter = Math.max(mp.diameter,  maxh+smaxh+2);
        mp.ht = 1+maxh;
        return mp;
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
        // write your code here
//        hight(root);
//        System.out.println(diameter);
        pair ans = diameter(root);
        System.out.println(ans.diameter);
    }
    
}
