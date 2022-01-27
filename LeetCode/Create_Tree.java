package LeetCode;
import java.util.List;
import java.util.ArrayList;
/*
https://leetcode.com/problems/path-sum-ii/
Given the root of a binary tree and an integer targetSum,
return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
 */
public class Create_Tree {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

    public static void sum(TreeNode root , int targetSum , ArrayList<Integer> l  ,List<List<Integer>> ans ){
        if(root == null) return;
        l.add(root.val);
        int currVal = targetSum-root.val;
        if(currVal == 0 && root.left == null && root.right == null  ){
               ans.add(new ArrayList<>(l));
            }
        else {
            sum(root.left, currVal, l , ans);
            sum(root.right, currVal, l , ans);
        }
        l.remove(l.size()-1);

    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null || targetSum == 0) return new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        sum(root , targetSum ,  l , ans);
        return ans;
    }


        public static void main(String[] args){
            TreeNode root= new TreeNode(5);

            // Left SubTree
            root.left = new TreeNode(4);
            root.left.left = new TreeNode(11);
            root.left.left.left = new TreeNode(7);
            root.left.left.right = new TreeNode(2);

            // Right Subtree
            root.right = new TreeNode(8);
            root.right.left = new TreeNode(13);
            root.right.right = new TreeNode(4);
            root.right.right.left = new TreeNode(5);
            root.right.right.right = new TreeNode(1);

            List<List<Integer>> ans = pathSum(root ,22 );
            System.out.println(ans);


        }
 }


}

