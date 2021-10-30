package GenericTree;
import java.io.*;
import java.util.*;

/*
1. You are given a partially written GenericTree class.
2. You are required to complete the body of height function.
The function is expected to find the height of tree.
 Depth of a node is defined as the number of edges it is away from the root (depth of root is 0).
 Height of a tree is defined as depth of deepest node.
3. Input and Output is managed for you.

12
10 20 -1 30 50 -1 60 -1 -1 40 -1 -1

Sample Output

2
 */
public class HeightOfAGenericTree {
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

    public static int size(Node node) {
        int s = 0;

        for (Node child : node.children) {
            s += size(child);
        }
        s += 1;

        return s;
    }

    public static int max(Node node) {
        int m = Integer.MIN_VALUE;

        for (Node child : node.children) {
            int cm = max(child);
            m = Math.max(m, cm);
        }
        m = Math.max(m, node.data);

        return m;
    }

    public static int height(Node node) {
        // write your code here
        int max = -1;
        for(Node child : node.children){
            int ht= height(child);
            max = Math.max(max , ht);
        }
        return max+1;
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
        int h = height(root);
        System.out.println(h);
        // display(root);
    }
}
