package Binary_Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;
/*
1. You are given a partially written BinaryTree class.
2. You are given a value data and a value k.
3. You are required to complete the body of printKNodesFar function.
The function is expected to print all nodes which are k distance away in any direction from node with value equal to data.
Sample Input

19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
37
2

Sample Output

12
50
 */
public class PrintNodesKDistanceAway {
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

    public static ArrayList<Node> nodeToRoot(Node root , int data){
        if(root== null){
            return new ArrayList<>();
        }

        if(root.data == data){
            ArrayList<Node> bans = new ArrayList<>();
            bans.add(root);
            return bans;
        }

       ArrayList<Node> l =  nodeToRoot(root.left , data);
        if(l.size()>0){
            l.add(root);
            return l;
        }

      ArrayList<Node> r =   nodeToRoot(root.right , data);
        if(r.size()>0){
            r.add(root);
            return r;
        }

      return new ArrayList<>();
    }

    public static void printKLevelDOwn(Node  node , int k , Node blocker){
        if(node == blocker || node == null){
            return;
        }
        if(k == 0){
            System.out.println(node.data+" ");
            return;
        }
        printKLevelDOwn(node.left , k-1 , blocker);
        printKLevelDOwn(node.right , k-1 , blocker);

    }

    public static void printKNodesFar(Node node, int data, int k) {
        // write your code here
        ArrayList<Node> ntroot = nodeToRoot(node , data);
        for(int i = 0 ; i<ntroot.size() ; i++){
            Node n = ntroot.get(i);
            Node blocker = i == 0 ? null : ntroot.get(i-1);
            printKLevelDOwn(n , k-i,blocker);

        }

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

        int data = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        printKNodesFar(root, data, k);
    }
}
