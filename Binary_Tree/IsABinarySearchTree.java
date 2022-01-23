package Binary_Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Stack;
/*
1. You are given a partially written BinaryTree class.
2. You are required to check if the tree is a Binary Search Tree (BST) as well.
    In a BST every node has a value greater than all nodes on it's left side and smaller value than all node on it's right side.
3. Input is managed for you.

Sample Input
15
50 25 12 n n 37 n n 75 62 n n 87 n n

Sample Output
true

 */
public class IsABinarySearchTree {
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

    public static class Triplate{
        boolean isBST;
        int max;
        int min;

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

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        int th = Math.max(lh, rh) + 1;
        return th;
    }

    public static boolean isBST(Node root){
        if(root == null) return true;

        if(root.left != null && root.left.data > root.data) return false;
        if(root.right != null && root.right.data < root.data) return false;

        if(!isBST(root.left) || !isBST(root.right)) return false;

        return true;

    }

    public static Triplate solution(Node node){
        if(node == null){
            Triplate bans = new Triplate();
            bans.isBST = true;
            bans.max = Integer.MIN_VALUE;
            bans.min = Integer.MAX_VALUE;
            return bans;
        }
        Triplate l = solution(node.left);
        Triplate r = solution(node.right);
        Triplate ans = new Triplate();

        if(l.isBST && r.isBST && l.max < node.data && r.min > node.data){
            ans.isBST = true;
        }else{
            ans.isBST = false;
        }
        ans.min = Math.min(node.data,  Math.min(l.min , r.min));
        ans.max = Math.max(node.data,  Math.max(l.max , r.max));
        return ans;
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

       // System.out.println(isBST(root));
        Triplate ans = solution(root);
        System.out.println(ans.isBST);
    }
}
