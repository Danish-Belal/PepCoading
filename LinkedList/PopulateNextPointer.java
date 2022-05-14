package LinkedList;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node,
 just like in Figure B.
 The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 */
public class PopulateNextPointer {
    public static void main(String[] args){

    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        if(root == null) return root;

        Queue<Node> Q= new LinkedList<>();

        Q.add(root);
        while(Q.size() !=0){

            int size = Q.size();
            Node dummy = new Node(0);

            while(size-->0){
                Node n = Q.remove();
                dummy.next = n;
                dummy = dummy.next;
                if(n.left != null) Q.add(n.left);
                if(n.right != null) Q.add(n.right);
            }
        }
        return root;
    }

}
