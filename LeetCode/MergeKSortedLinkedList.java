package LeetCode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLinkedList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }

    }

    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(0);
        ListNode n = dummy;

        PriorityQueue<ListNode> Q = new PriorityQueue<ListNode>(lists.length , new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        for(int i = 0; i<lists.length ; i++){
            ListNode l = lists[i];
           if(l != null) Q.add(l);
        }

        while(Q.size() > 0){
            ListNode small = Q.poll();
            n.next = small;
            n = n.next;

            if(small.next != null){
                Q.add(small.next);
            }
        }
        n.next = null;
        return dummy.next;
    }

//    public static void main(String[] args){
//       ListNode a = new ListNode(1);
//       ListNode a1 = new ListNode(4);
//       ListNode a2 = new ListNode(5);
//
//       a.next = a1;
//       a1.next = a2;
//       a2.next = null;
//
//        ListNode b = new ListNode(1);
//        ListNode b1 = new ListNode(3);
//        ListNode b2 = new ListNode(4);
//
//        b.next = b1;
//        b1.next = b2;
//        b2.next = null;
//
//        ListNode c = new ListNode(2);
//        ListNode c1 = new ListNode(6);
//        ListNode c2 = new ListNode(8);
//
//        c.next = c1;
//        c1.next = c2;
//        c2.next = null;
//
//        ListNode[] l = {a,c,b};
//        ListNode ans =  mergeKLists(l);
//
//        while(ans.next != null){
//            System.out.print(ans.val+" ");
//        }

  // Main is not running . other code is working good.






}
