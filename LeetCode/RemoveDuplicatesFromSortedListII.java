package LeetCode;

import java.util.List;

public class RemoveDuplicatesFromSortedListII {
    ListNode tail;
    ListNode head;
    int size;

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
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null){
            return  head;
        }
        ListNode dummyHead= new ListNode(0);
        ListNode pre = dummyHead;
        dummyHead.next = head;

        while(head != null){
            if(head.next != null && head.val == head.next.val){
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                pre.next = head.next;
            }else{
                pre = pre.next;
            }
            head = head.next;

        }

        return dummyHead.next;

    }

    public void insertAtFirst(int val) {
      ListNode n = new ListNode(val);
        n.next = head;
        head = n;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void display() {
       ListNode n = head;
        while (n != tail) {
            System.out.print(n.val + " --> ");
            n = n.next;
        }
        System.out.println(n.val);
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII ll = new RemoveDuplicatesFromSortedListII();
        ll.insertAtFirst(1);
        ll.insertAtFirst(2);
        ll.insertAtFirst(3);
        ll.insertAtFirst(3);
        ll.display();
        ll.deleteDuplicates(ll.head);
        ll.display();

    }
}
