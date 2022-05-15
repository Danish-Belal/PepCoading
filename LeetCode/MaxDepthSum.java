package LeetCode;
/*
https://leetcode.com/problems/deepest-leaves-sum/
Given the root of a binary tree, return the sum of values of its deepest leaves.
Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
 */
public class MaxDepthSum {
      public class TreeNode {
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
  }

    int sum = 0 ;
    public int deepestLeavesSum(TreeNode root) {
        int max =  maxDepth(root);
        findSum(root , 1,max);
        return sum;

    }
    int maxDepth(TreeNode node){
        if(node == null) return 0;
        return 1+Math.max(maxDepth(node.left) , maxDepth(node.right));
    }
    void findSum( TreeNode node, int currDepth , int maxdepth) {
        if (node != null) {
            if (currDepth == maxdepth) {
                sum += node.val;

            }
            findSum(node.left, currDepth + 1, maxdepth);
            findSum(node.right, currDepth + 1, maxdepth);
        }
    }

    public static void main(String[] args){

    }

}
