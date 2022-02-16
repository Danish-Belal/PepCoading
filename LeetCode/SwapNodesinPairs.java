package LeetCode;

/*
https://leetcode.com/problems/swap-nodes-in-pairs/
Given a linked list, swap every two adjacent nodes and return its head.
 You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
 */
public class SwapNodesinPairs {

    public class ListNode {
             int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;


        ListNode dummyHead = new ListNode(0);
        ListNode dummy  = dummyHead;
        ListNode c = head;

        dummy.next = head;

        while(c != null && c.next != null){
            dummy.next = c.next;
            c.next = c.next.next;
            dummy.next.next = c;
            c = c.next;
            dummy = dummy.next.next;


        }

        return dummyHead.next;


    }
}
