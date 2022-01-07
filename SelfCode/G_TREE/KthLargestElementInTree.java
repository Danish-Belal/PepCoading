package SelfCode.G_TREE;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.Stack;
import java.io.InputStreamReader;

/*
1. You are given a partially written GenericTree class.
2. You are given a number k. You are required to find and print the kth largest value in the tree.
3. Input and Output is managed for you.
 */

public class KthLargestElementInTree {
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


    static int ceil;
    static int floor;
    public static void ceilAndFloor(Node node, int data) {
        if(node.data > data){
            if(node.data < ceil){
                ceil = node.data;
            }
        }
        if(node.data < data){
            if(node.data > floor){
                floor = node.data;
            }
        }
        for (Node child : node.children) {
            ceilAndFloor(child, data);
        }
    }


    public static int kthLargest(Node node, int k){
        // write your code here.
        int data = Integer.MAX_VALUE;
        for(int i = 1 ; i<=k ; i++){
            ceilAndFloor(node , data);
            data = floor;
            floor = Integer.MIN_VALUE;
        }
        return data;
    }

    public static void main(String[] args) throws Exception {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int[] arr = new int[n];
//        String[] values = br.readLine().split(" ");
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(values[i]);
//        }
//
//        int k = Integer.parseInt(br.readLine());
//        Node root = construct(arr);
//        int kthLargest = kthLargest(root, k);
//        System.out.println(kthLargest);

        int[] arr = {10 ,20, -50, -1 ,60, -1 ,-1, 30, 70, -1, -80, 110, -1, -120, -1, -1, 90, -1, -1, 40, -100, -1, -1, -1};
        Node root = construct(arr);
        System.out.println(kthLargest(root , 8));

    }
}
