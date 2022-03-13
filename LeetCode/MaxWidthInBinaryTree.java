package LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxWidthInBinaryTree {

      public class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val;}
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public int widthOfBinaryTree(TreeNode root) {

        Queue<TreeNode> Q= new ArrayDeque<>();
        Q.add(root);

        int max = Integer.MIN_VALUE;

        while(Q.size() > 0){

            for(int i = 0 ; i<Q.size() ; i++){
                if(Q.size() > max) max = Q.size();
                TreeNode n = Q.poll();
                if(n.left != null || n.right != null){
                    if(n.left != null) Q.add(n.left);
                    else
                        Q.add(new TreeNode());
                    if(n.right != null) Q.add(n.right);
                    else
                        Q.add(new TreeNode());
                }
            }
        }

        return max;

    }
}
