package BinarySearchTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
/*


1. You are given a partially written BST class.
2. You are given a value. You are required to print all pair of nodes which add up to the given value.
 Make sure all pairs print the smaller value first and avoid duplicacies.
 Make sure to print the pairs in increasing order. Use the question video to gain clarity.

 Sample Input

21
50 25 12 n n 37 30 n n n 75 62 60 n n 70 n n 87 n n
100

Sample Output

25 75
30 70
 */
public class TargetSumPairInBst {


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


    public static boolean isPresent(Node node  , int data){
        if(node == null) return false;
        if(node.data == data) return true;
        else if( node.data < data)return isPresent(node.right , data);
        else return isPresent(node.left , data);
    }
    public static  void isPair(Node node , int target , Node root){
        if(node == null) return;

        isPair(node.left , target , root);
        int complement = target- node.data;
        if(complement > node.data){
            if(isPresent(root , complement)){
                System.out.println(node.data +" "+ complement);
            }
        }
        isPair(node.right , target , root);
    }

    public static void solution2(Node node , ArrayList<Integer> al){
        if(node == null) return;;

        solution2(node.left , al);
        al.add(node.data );
        solution2(node.right , al);
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

        Node root = construct(arr);
        // write your code here
       // isPair(root , data , root);

        // Solution for o(n).
        ArrayList<Integer> val = new ArrayList<>();
        solution2(root  , val);

        int i = 0 ;
        int j = val.size()-1;
        while( i <j){
            int sum = val.get(i)+val.get(j);
            if(sum == data){
                System.out.println(val.get(i) + " " + val.get(j));
                i++;
                j--;
            }else if(sum > data){
                j--;
            }else{
                i++;
            }
        }

    }
}
