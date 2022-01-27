package Binary_Tree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeaf {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(){}
        Node(int val){
            this.val = val;
        }
        Node(int val , Node left , Node right){
            this.val = val;
            this.left = left;
            this.right = left;
        }
    }

    public static void paths(Node root , ArrayList<Integer> leaf , List<List<Integer>> paths){
        if(root == null) return ;

        leaf.add(root.val);

        if(root.left == null && root.right == null){
            paths.add(new ArrayList<>(leaf));
        }

        paths(root.left , leaf , paths);
        paths(root.right , leaf , paths);
        leaf.remove(leaf.size()-1);

    }
    public static void main(String[] args){
        Node root= new Node(5);

        // Left SubTree
        root.left = new Node(4);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);

        // Right Subtree
        root.right = new Node(8);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.left = new Node(5);
        root.right.right.right = new Node(1);

        List<List<Integer>> path = new ArrayList<>();
        ArrayList<Integer> leaf = new ArrayList<>();
        paths(root , leaf , path);
        System.out.println(path);



    }
}
