package LeetCode;

public class InsertioSortList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next)
        {
            this.val = val; this.next = next;
        }
    }
    public ListNode insertionSortList(ListNode head) {
        if(head.next == null ) return head;
        ListNode dummy = new ListNode(-1);
        ListNode curr = head;

        while(curr != null){
            ListNode temp = curr.next;
            ListNode prev = dummy;
            ListNode nxt = dummy.next;

            while(nxt != null){
                if(nxt.val > curr.val)
                    break;
                prev = nxt;
                nxt = nxt.next;
            }

            curr.next = nxt;
            prev.next = curr;
            curr = temp;
        }
        return dummy.next;
    }
}
