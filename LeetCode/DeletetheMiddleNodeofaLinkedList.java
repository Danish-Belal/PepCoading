package LeetCode;

public class DeletetheMiddleNodeofaLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val,ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;

        int ct =1 ;
        ListNode temp = head.next;
        while(temp != null){
            temp = temp.next;
            ct++;
        }

        ct /= 2;
        System.out.println(ct);

        ListNode f = head.next;
        ListNode s = head;
        ListNode pre = s;

        for(int i = 0 ; i<ct ; i++){
            f = f.next;
            pre= s;
            s = s.next;
        }
        pre.next = s.next;
      //  return head;


        // Another Approach.
        ListNode fast=head;
        ListNode slow=head;
        if(head.next==null)
            return null;
        int count=0;
        while(fast!=null && fast.next!=null)
        {
            slow=(count==0)?head:slow.next; //To make slow point to (mid-1)th node instead of mid
            count++;
            fast=fast.next.next;
        }
        ListNode toDel=slow.next;
        slow.next=toDel.next;
        toDel.next=null;
       // return head;

        // Another Approach.
        ListNode f1 = head ;
        ListNode s1 = head ;
        ListNode pre1 = null;

        if(head.next ==null){
            return null;
        }

        while(f1 != null && f1.next != null){
            f1 = f1.next.next;
            pre1 = s1;
            s1 = s1.next;
        }
        pre1.next = s1.next;
        return head;

    }
}
