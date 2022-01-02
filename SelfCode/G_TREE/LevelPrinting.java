package SelfCode.G_TREE;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class LevelPrinting {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
        public Node(){};
        public Node(int n){
            Node a  = new Node();
            a.data = n;
        }

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

    // BSF is level wise searching , but we are printing here data of that given node.
    public static void BSFPrint(Node node){
        Queue<Node> Q = new ArrayDeque<>();
        Q.offer(node);
        while (Q.size() != 0){
           Node n = Q.poll();
            System.out.print(n.data+ " , ");
            for(Node child : n.children){
                Q.offer(child);
            }
        }
        System.out.println(".");

    }

    public static void BSFPrintLineWise(Node node){
        Queue<Node> Q = new ArrayDeque<>();
        Q.offer(node);

        while (Q.size() > 0){
            int sz = Q.size();
            for(int i = 1 ; i<=sz ; i++){
                Node n = Q.remove();
                System.out.print(n.data+" ");
                for (Node child : n.children){
                    Q.add(child);
                }
            }
            System.out.println();
        }
    }


    public static void levelOrderLinewiseZZ(Node node){
        // write your code here
       Stack<Node> s1 = new Stack<>();
       Stack<Node> s2 = new Stack<>();

       s1.push(node);
       int level = 0;

       while(s1.size() > 0){
           while (s1.size() > 0){
               Node n = s1.pop();
               System.out.print(n.data+" ");
               if(level %2 == 0){
                   for(Node child : n.children){
                       s2.push(child);
                   }
               }else{
                   for(int i = n.children.size()-1 ; i>= 0 ;i--){
                       Node rn = n.children.get(i);
                       s2.push(rn);
                   }
               }
           }
           System.out.println();
           level++;
           s1 = s2;
           s2 = new Stack<>();
        }
    }
    public static void main(String[] args) {
        int[] arr = {10,20,50,-1 , 60 , -1,-1,30 , 70,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = createTree(arr);
        //display(root);
       // BSFPrint(root);
        BSFPrintLineWise(root);
        levelOrderLinewiseZZ(root);



    }
}
