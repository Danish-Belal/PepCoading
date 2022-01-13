package Binary_Tree;

import java.util.*;

public class Create_Tree {
    private static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
        public Node(int val , Node left , Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public static void display(Node root){
        if(root == null) return;
        System.out.print(root.val+"  ");

        display(root.left);

        display(root.right);
        // System.out.println(".");
    }

    static  void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    static void  PreOrder(Node root){
        if(root == null) return;
        System.out.print(root.val+" ");
        PreOrder(root.left);
        PreOrder(root.right);
    }

    static void  PostOrder(Node root){
        if(root == null) return;
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.val+" ");
    }


    public static void BSFPrint(Node root){
        if(root == null) return;
        Queue<Node> Q = new ArrayDeque<>();
        Q.offer(root);
        while (Q.size() > 0){
           Node n = Q.poll();
            System.out.print(n.val +" ");
            if(n.left != null)  Q.add(n.left);
            if(n.right != null)Q.add(n.right);

        }

    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);

        System.out.print("Print Tree -> ");
        display(root);
        System.out.println();

        System.out.print("Inorder Traversal ->");
        inOrder(root);
        System.out.println();
        System.out.print("preorder Traversal -> ");
        PreOrder(root);
        System.out.println();
        System.out.print("Postorder Traversal -> ");
        PostOrder(root);
        System.out.println();

        System.out.print("BSF Traversal -> ");
        BSFPrint(root);


    }
}
