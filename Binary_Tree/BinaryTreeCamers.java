package Binary_Tree;
/*
https://leetcode.com/problems/binary-tree-cameras/
You are given the root of a binary tree.
We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.

Return the minimum number of cameras needed to monitor all nodes of the tree.

Input: root = [0,0,null,0,0]
Output: 1
Explanation: One camera is enough to monitor all nodes if placed as shown.

 */
public class BinaryTreeCamers {
    public static void main(String[] args){

    }
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
  }


    int camera  ;

    int minCameraCover_(TreeNode root){
        if(root == null) return 1;

        int lcall = minCameraCover_(root.left);
        int rcall = minCameraCover_(root.right);

        if(lcall == -1 || rcall == -1){
            camera++;
            return 0;
        }

        if(lcall == 0 || rcall ==0 ){
            return 1;
        }
        return -1;
    }
    public int minCameraCover(TreeNode root) {
        camera =0;
        if(minCameraCover_(root) == -1) camera++;
        return camera;
    }
}
