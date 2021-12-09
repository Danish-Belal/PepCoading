package LeetCode;
/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class RemoveNthNodeFromLast {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        if(head.next == null && n ==1 ) return null;

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode f = dummyHead;
        ListNode  s = dummyHead ;

        ListNode pre = null;
        for(int i = 0; i<n ; i++){
            f = f.next;
        }
        while(f != null){
            f = f.next;
            pre = s;
            s = s.next;
        }
        pre.next = s.next;
        return dummyHead.next;
    }

}
