package SelfCode.G_TREE;
/*
1. You are given a partially written GenericTree class.
2. You are required to complete the body of traversals function.
    The function is expected to visit every node. While traversing the function must print following content in different situations.
   2.1. When the control reaches the node for the first time -> "Node Pre" node.data.
   2.2. Before the control leaves for a child node from a node -> "Edge Pre"
   node.data--child.data.
   2.3. After the control comes back to a node from a child -> "Edge Post" node.data-
   -child.data.
    2.4. When the control is about to leave node, after the children have been visited
    -> "Node Post" node.data.
 */
import java.util.ArrayList;
import java.util.Stack;

public class Traversal {
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

    public static void traversals(Node node){
        // write your code here
        System.out.println("Node Pre "+node.data);
        for(Node child : node.children){
            System.out.println("Edge Pre "+node.data+ "--"+ child.data );
            traversals(child);
            System.out.println( "Edge Post " +node.data+ "--"+ child.data  );
        }
        System.out.println("Node Post "+node.data  );
    }


    public static void main(String[] args) {
        int[] arr = {10,20,50,-1 , 60 , -1,-1,30 , 70,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = createTree(arr);
        traversals(root);
    }
}
