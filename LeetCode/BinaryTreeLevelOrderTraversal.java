package LeetCode;

import Binary_Tree.LevelOrderPrinting;
import Oops.Greet.A;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


/*
https://leetcode.com/problems/binary-tree-level-order-traversal/

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 */
public class BinaryTreeLevelOrderTraversal {
    private  static class Node{
        int data;
        Node left;
        Node right;

        Node(int val){
            this.data = val;
            this.left = null;
            this.right = null;
        }
        Node(int val , Node  l , Node r){
            this.data = val;
            this.left = l;
            this.right = r;
        }
    }

    public static List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> ans = new ArrayList<>();

        Queue<Node> Q = new ArrayDeque<>();
        Q.offer(root);

        while (Q.size() != 0){
            int sz = Q.size();
            ArrayList<Integer> l = new ArrayList<>();
            for(int i =0 ; i<sz ; i++){
                Node rn = Q.poll();
                l.add(rn.data);
                if(rn.left != null){
                    Q.offer(rn.left);
                }
                if(rn.right != null){
                    Q.offer(rn.right);
                }
            }
            ans.add(l);
        }
        return ans;

    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        List<List<Integer>> ans = levelOrder(root);
        System.out.println(ans);
    }

}
