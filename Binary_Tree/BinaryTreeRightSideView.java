package Binary_Tree;

import java.util.ArrayList;
import java.util.List;
/*
https://leetcode.com/problems/binary-tree-right-side-view/
Given the root of a binary tree, imagine yourself standing on the right side of it,
    return the values of the nodes you can see ordered from top to bottom.

Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

Example 2:
Input: root = [1,null,3]
Output: [1,3]

Example 3:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */
public class BinaryTreeRightSideView {
    public static void main(String[] args){

    }
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
        public List<Integer> rightSideView(TreeNode root) {

            List<Integer> res = new ArrayList<>();
            right(root , res , 0);

            return res;
        }
        private void right(TreeNode root , List<Integer> res , int level){
            if(root == null) return;
            if(level==res.size()){
                res.add(root.val);
            }
            right(root.right , res , level+1);
            right(root.left , res , level+1);
        }
}
