package Binary_Tree;

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

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
      //  display(root);
        inOrder(root);
        System.out.println();
        PreOrder(root);
        System.out.println();
        PostOrder(root);

    }
}
