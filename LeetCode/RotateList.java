package LeetCode;
/*
https://leetcode.com/problems/rotate-list/
Given the head of a linked list, rotate the list to the right by k places.
 */
public class RotateList {
    public class ListNode {
        int val;
       ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }


        ListNode temp = head;
        int ct = 0;

        while (temp != null) {
            temp = temp.next;
            ct++;
        }

        k = k % ct;
        System.out.println(ct);
        System.out.println(k);

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode f = dummy;
        ListNode s = dummy;
        ListNode pre = null;

        for (int i = 0; i < k; i++) {
            f = f.next;

        }
        ListNode temp1 = null;
        while (f != null) {
            if (f.next == null) {
                temp1 = f;
            }
            f = f.next;
            pre = s;
            s = s.next;
        }
        if (k == 0) {
            return head;
        } else {
            temp1.next = head;
            head = s;
            pre.next = null;
            return head;
        }
    }
}
