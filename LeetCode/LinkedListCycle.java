package LeetCode;

public class LinkedListCycle {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public boolean hasCycle(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        if(head == null) return false;
        if(head.next == null) return false;

        while(f != null && f.next != null ){
            f = f.next.next;
            s = s.next;

            if( f == s){
                return true;
            }
        }
        return false;
    }

    // If there is a cycle , find length of the cycle.
    public int CycleLength(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        while(f != null && f.next != null ){
            f = f.next.next;
            s = s.next;

            if( f == s){
               // Calculate the Length.
                ListNode temp = s;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                }while(temp != f);
                return  length;
            }
        }
        return 0;
    }
}
