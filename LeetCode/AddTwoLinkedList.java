package LeetCode;

import Oops.Greet.A;

/*
https://leetcode.com/problems/add-two-numbers/
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoLinkedList {
    Node head;
    Node tail;
    int size;

    private class Node {
        int data;
        Node next;

        public Node(int val) {
            this.data = val;
        }

        public Node(int val, Node next) {
            this.data = val;
            this.next = next;
        }

        public Node() {

        }
    }

    public void display() {
       Node n = head;
        while (n != tail) {
            System.out.print(n.data + " --> ");
            n = n.next;
        }
        System.out.println(n.data);
        System.out.println();
    }

    public void insertAtFirst(int val) {
        Node n = new Node(val);
        n.next = head;
        head = n;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

//    public Node list(int val){
//        if(val == 0){
//            return null;
//        }
//        Node temp = new Node();
//        temp.data = val%10;
//        val /=10;
//      return temp;
//    }

    public Node addTwoNumbers(Node l1, Node l2) {
//        int sum1 = 0;
//        int sum2 = 0;
//        int pow =1;
//
//        while (l1 != null && l2 != null){
//            sum1 += (l1.data)*pow;
//            sum2 += (l2.data)*pow;
//
//            l1 = l1.next;
//            l2 = l2.next;
//            pow *= 10;
//        }
////        System.out.println(sum1);
////        System.out.println(sum2);
//        int sum3 = sum1+sum2;
//        System.out.println(sum3);
//
//       Node dummyHead= new Node(sum3%10);
//       Node dNext = dummyHead;
//       sum3 /=10;
//        while (sum3 != 0){
//            Node temp= new Node();
//            temp.data = sum3%10;
//            sum3 /=10;
//           dNext.next = temp;
//           dNext = temp;
//        }
//        return dummyHead;
        // This have some type problem.

        //ANother Approach.

        Node dummyHead= new Node(0);
        Node dNext = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null){
            int l1_val = (l1 != null) ? l1.data : 0;
            int l2_val = (l2 != null) ? l2.data : 0;

            int currSUm = l1_val+l2_val+carry;
            carry = currSUm/10;

            int last_digit = currSUm%10;

            Node new_Node = new Node(last_digit);
            dNext.next = new_Node;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            dNext = dNext.next;
        }

        if(carry > 0){
            Node new_Node = new Node(carry);
            dNext.next = new_Node;
            dNext = dNext.next;
        }
        return dummyHead.next;

    }

    public static void main(String[] args) {
        AddTwoLinkedList l1 = new AddTwoLinkedList();
        AddTwoLinkedList l2 = new AddTwoLinkedList();
        l1.insertAtFirst(3);
        l1.insertAtFirst(4);
        l1.insertAtFirst(2);
        l2.insertAtFirst(4);
        l2.insertAtFirst(6);
        l2.insertAtFirst(5);


        AddTwoLinkedList l3 = new AddTwoLinkedList();
        l3.addTwoNumbers(l1.head,l2.head);
        l3.display();



    }
}
