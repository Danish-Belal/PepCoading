package LeetCode;

/*
https://leetcode.com/problems/sum-of-left-leaves/
Given the root of a binary tree, return the sum of all left leaves.
 */

public class SumOfLeftLeavs {
    private static int sum;

    public class Node{
       int data;
       Node left;
       Node right;

   }

    public static void sumOfLeftLeavs(Node root , boolean isleft){
        if(isleft && root.left== null && root.right == null ) {
            sum += root.data;
            return;
        }
        if(root.left != null) sumOfLeftLeavs(root.left , true);
        if(root.right != null) sumOfLeftLeavs(root.right , false);
    }
    public static int sumOfleftLeavs(Node root){
        if(root == null) return 0;
        sumOfLeftLeavs(root , false);
        return sum;
    }


}
