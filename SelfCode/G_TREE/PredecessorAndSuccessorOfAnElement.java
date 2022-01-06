package SelfCode.G_TREE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/*
1. You are given a partially written GenericTree class.
2. You are required to find the preorder predecessor and successor of a given element.
Use the "travel and change" strategy explained in the earlier video.
The static properties have been declared for you. You can declare more if you want.

Sample Input
24
10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1
-120

Sample Output
Predecessor = 110
Successor = 90

 */
public class PredecessorAndSuccessorOfAnElement {
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

    static Node predecessor;
    static Node successor;
    static  int state = 0;

    public static void predecessorAndSuccessor(Node node, int data) {
        // write your code here
       if(state == 0){
           if(node.data == data){
               state++;
           }else{
               predecessor = node;
           }
       }else if(state == 1){
           successor = node;
           state++;
       }else{
           return;
       }

        for(Node child : node.children){
            predecessorAndSuccessor(child, data);
        }
    }

    /*
    1. You are given a partially written GenericTree class.
    2. You are required to find the ceil and floor value of a given element.
        Use the "travel and change" strategy explained in the earlier video.
        The static properties - ceil and floor have been declared for you. You can declare more if you want.
        If the element is largest ceil will be largest integer value (32 bits),
        if element is smallest floor will be smallest integer value (32 bits). Watch the question video for clarity.

 Sample Input
24
10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1
70

Sample Output
CEIL = 90
FLOOR = 60

     */

    static int ceil;
    static int floor;
    public static void ceilAndFloor(Node node, int data) {
        // Write your code here
        if(node.data > data){
            ceil = Math.min(ceil , node.data);
        }else if(node.data < data){
            floor = Math.max(floor, node.data);
        }

        for(Node child : node.children){
            ceilAndFloor(child , data);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        int data = Integer.parseInt(br.readLine());

        Node root = construct(arr);
//        predecessor = null;
//        successor = null;
//        predecessorAndSuccessor(root, data);
//        if(predecessor == null){
//            System.out.println("Predecessor = Not found");
//        } else {
//            System.out.println("Predecessor = " + predecessor.data);
//        }
//
//        if(successor == null){
//            System.out.println("Successor = Not found");
//        } else {
//            System.out.println("Successor = " + successor.data);
//        }


        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
        ceilAndFloor(root, data);
        System.out.println("CEIL = " + ceil);
        System.out.println("FLOOR = " + floor);
    }


}
