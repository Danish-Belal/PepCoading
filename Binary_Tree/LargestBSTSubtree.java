package Binary_Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
1. You are given a partially written BinaryTree class.
2. You are required to find the root of largest sub-tree which is a BST.
Also, find the number of nodes in that sub-tree.
3. Input is managed for you.

Sample Input

15
50 25 12 n n 37 n n 75 62 n n 87 n n

Sample Output

50@7
 */
public class LargestBSTSubtree {
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

    public static class Pair2{
        boolean isBST;
        int max;
        int min;
        Node lBstNode;
        int bstSize;
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

    public static Pair2 solution(Node node){
        if(node == null){
            Pair2 b = new Pair2();
            b.max = Integer.MIN_VALUE;
            b.min = Integer.MAX_VALUE;
            b.lBstNode = null;
            b.bstSize = 0;
            b.isBST = true;
            return b;
        }

        Pair2  l = solution(node.left);
        Pair2  r = solution(node.right);
        Pair2 ans = new Pair2();


        ans.min = Math.min(node.data,  Math.min(l.min , r.min));
        ans.max = Math.max(node.data, Math.max(l.max , r.max));
        if(l.isBST && r.isBST && l.max< node.data && r.min > node.data){
            ans.lBstNode = node;
            ans.isBST = true;
            ans.bstSize = l.bstSize+r.bstSize+1;
        }else if(l.bstSize >= r.bstSize){
            ans.isBST = false;
            ans.lBstNode = l.lBstNode;
            ans.bstSize = l.bstSize;
        }else{
            ans.isBST = false;
            ans.lBstNode = r.lBstNode;
            ans.bstSize = r.bstSize;
        }
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

        Pair2 ans = solution(root);
        System.out.println(ans.lBstNode.data+"@"+ans.bstSize);
    }


}
