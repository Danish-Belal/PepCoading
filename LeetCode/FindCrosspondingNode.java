package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/

Given two binary trees original and cloned and given a reference to a node target in the original tree.

The cloned tree is a copy of the original tree.

Return a reference to the same node in the cloned tree.

Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.

 Input: tree = [7,4,3,null,null,6,19], target = 3
Output: 3
Explanation: In all examples the original and cloned trees are shown.
The target node is a green node from the original tree. The answer is the yellow node from the cloned tree.

 */
public class FindCrosspondingNode {

     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String[] args){

    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {


        Queue<TreeNode> Q= new LinkedList<>();
        Q.add(cloned);

        while(Q.size() >0){
            int sz = Q.size();

            while(sz-->0){
                TreeNode node = Q.poll();
                if(node.val == target.val) return node;

                if(node.left != null) Q.add(node.left);
                if(node.right != null) Q.add(node.right);
            }
        }

        return null;
    }
}
