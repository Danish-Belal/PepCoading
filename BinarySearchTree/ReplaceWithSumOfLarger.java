package BinarySearchTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
/*
1. You are given a partially written BST class.
2. You are required to complete the body of rwsol function.
  "rwsol" function is expected to replace a node's value with sum of all nodes greater than it.
3. Input and Output is managed for you.

15
50 25 12 n n 37 n n 75 62 n n 87 n n

Sample Output

311 <- 224 -> 87
336 <- 311 -> 274
. <- 336 -> .
. <- 274 -> .
162 <- 87 -> 0
. <- 162 -> .
. <- 0 -> .
 */
public class ReplaceWithSumOfLarger {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    static int sum = 0;
    public static void rwsol(Node node){
        // write your code here
       if(node == null){
           return;
       }

       rwsol(node.right);
        int v = node.data;
        node.data = sum;
        sum += v;

       rwsol(node.left);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);
        rwsol(root);

        display(root);
    }
}
