package LeetCode;

import Binary_Tree.Create_Tree;

/*
https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.

 Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]
 */
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class AllElementsinTwoBinarySearchTrees {
    private static class Node{
        int val;
        Node left;
       Node right;

        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
        public Node(int val , Node left ,Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
//    public static void nodes(Node root , List<Integer> l ){
//        if(root == null){
//           return;
//        }
//
////        nodes(root.left , l);
////        l.add(root.val);
////        nodes(root.right , l);
//
//        l.addAll(nodes(root.left , l));
//        l.add(root.val);
//        l.addAll(nodes(root.right , l));
//
//
//    }


   static List al = new ArrayList<>();

    public static void nodes(Node root){
        if(root == null){
            return;
        }
        nodes(root.left);
        al.add(root.val);
        nodes(root.right);

    }
    public static List<Integer> getAllElements(Node root1, Node root2) {

        nodes(root1);

        nodes(root2);

        Collections.sort(al);
        return al;
    }


//    public static List<Integer> getAllElements(Node root1,Node root2) {
//
//        List<Integer> ans  = new ArrayList<>();
//
//        List<Integer> l = new ArrayList<>();
//        nodes(root1.left , l);
//        System.out.println(l);
//        List<Integer> r =  new ArrayList<>();
//        nodes(root2.right , r);
//        System.out.println(l);
//
//        merge(l,r,ans);
//        return ans;
//
//
//    }
    public static void display(Node root){
        if(root == null) return;
        System.out.print(root.val+"  ");

        display(root.left);

        display(root.right);
        // System.out.println(".");
    }
    public static void main(String[] args){
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left= new Node(24);
     //   display(root);
//
      List<Integer> ans =   getAllElements(root , root);
      System.out.println(ans);

    }
}
