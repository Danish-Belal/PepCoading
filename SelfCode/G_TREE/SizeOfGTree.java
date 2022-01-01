package SelfCode.G_TREE;

import java.util.ArrayList;
import java.util.Stack;

/*
1. You are given a partially written GenericTree class.
2. You are required to complete the body of size function.
    The function is expected to count the number of nodes in the tree and return it.
3. Input and Output is managed for you.
Sample Input

12
10 20 -1 30 50 -1 60 -1 -1 40 -1 -1

Sample Output

6

 */
public class SizeOfGTree {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();

    }

    public static Node createTree(int[] arr){
        Node root = new Node();
        root.data = arr[0];

        Stack<Node> st = new Stack<>();
        st.push(root);
        for(int i = 1; i<arr.length ; i++){
            if(arr[i] == -1){
                st.pop();
            }else{
                Node n = new Node();
                n.data = arr[i];
                st.peek().children.add(n);
                st.push(n);
            }
        }
        return root;
    }
    public static int size(Node node){
        // write your code here
        int ans = 0;
        for(Node child : node.children){
          int cs =   size(child);
             ans += cs;
        }
        return ans+1;
    }

    public static  int maximum(Node node){
        int max = node.data;
        for(Node child : node.children){
            int maxc = maximum(child);
            max = Integer.max(max , maxc);
        }
        return max;
    }
    public static int hight(Node node){
        int mxh = -1;
        for(Node child : node.children){
            mxh = Math.max(mxh , hight(child));
        }
        return mxh+1;

    }
    public static void display(Node root){
        String s = "";
        s += root.data+" -> ";
        for(Node child : root.children){
            s += child.data+", ";
        }
        s += ".";
        System.out.println(s);
        for(Node child : root.children){
            display(child);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,20,50,-1 , 60 , -1,-1,30 , 70,-1,90,-1,-1,40,100,-1,-1,-1};
         Node root = createTree(arr);
        //display(root);

        System.out.println(size(root));
        System.out.println(maximum(root));
        System.out.println(hight(root));
    }
}
