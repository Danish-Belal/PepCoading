package SelfCode;

public class ReverseLL {
    Node head;
    Node tail;
    int size;

    public ReverseLL(){

        this.size =0;
    }

    private class Node{
        int data;
        Node next;

        public  Node(int val){
            this.data = val;
        }

        public Node(int val , Node next){
            this.data = val;
            this.next = next;
        }

        public Node() {

        }
    }
    public void insertAtFirst(int val){
       Node n = new Node(val);
        n.next = head;
        head = n;

        if(tail == null){
            tail =head;
        }
        size+=1;
    }
    public void display(){
        Node n = head;
        while(n != tail){
            System.out.print(n.data+" --> ");
            n = n.next;
        }
        System.out.println(n.data );
        System.out.println();
    }
    // Recursion Reverse.
    public void reverselist(Node node){
        if(node  == tail){
            head = tail;
            return;
        }
        reverselist(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    // Inplace Reverse.
    public void reverseListInplace(Node node){
       if(size <2){
           return;
       }
       Node pre = null;
       Node curr = head;
       Node currnext = curr.next;

       while (curr != null ){
           curr.next = pre;
           pre = curr;
           curr = currnext;
           if(currnext != null){
               currnext = currnext.next;
           }
       }
        head = pre;

//        ListNode prev = null, curr = head, next = null;
//        while(curr != null){
//            next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;
    }

    public static void main(String[] args) {
        ReverseLL l = new ReverseLL();
        l.insertAtFirst(10);
        l.insertAtFirst(20);
        l.insertAtFirst(30);
        l.insertAtFirst(40);
        l.display();
//        l.reverselist(l.head);
//        l.display();
        l.reverseListInplace(l.head);
        l.display();
    }
}
