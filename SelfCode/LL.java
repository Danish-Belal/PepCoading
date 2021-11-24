package SelfCode;

import LeetCode.ConvertBinaryNumberinaLinkedListtoInteger;

public class LL {
    Node head;
    Node tail;
    int size;
    public LL(){
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
   public void insertdAtEnd(int val){
       if(tail==null){
           insertAtFirst(val);
           return;
       }
       Node temp = new Node(val);
       tail.next = temp;
       tail= temp;
       temp.next = null;
       size+=1;
   }

   public void insertAtIndex(int val , int index){
        if(index > size){
            System.out.println("Invalid index");
        }
        if(index == 0){
            insertAtFirst(val);
            return;
        }
        if(index == size+1){
            insertdAtEnd(val);
            return;
        }else  {
            Node temp = new Node(val);
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            temp.next = n.next;
            n.next = temp;
        }
        size++;
   }

   public int deleteFirst(){
        if(head == null){
            System.out.println("Empty Linked List");
            return -1;
        }
        if(size == 1){
            int val = head.data;
            head = null;
            tail = null;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
   }

    public int deleteLast(){
        if(tail == null){
            System.out.println("Empty linked List");
            return -1;
        }
        int val = tail.data;
        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
       }
        temp.next = null;
        tail = temp;
        size--;

        return val;
   }

   public int deleteIndex(int index){
        if(index > size){
            System.out.println("Invalid Index");
            return -1;
        }
        if(index == 0){
            return deleteFirst();
        }
        if(index == size-1){
            return  deleteLast();
        }
        Node pre = head;
        for(int i = 0 ; i<index-1 ; i++){
            pre = pre.next;
        }
        int val = pre.next.data;
        pre.next = pre.next.next;
        size--;
        return val;
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

   // USed for Leet Code
    public int getDecimalValue(Node head) {
       Node temp = head;
        int digit = 0;
        int pow =1;
        while (temp != null){
            int tempval = temp.data;
            digit *=pow;
            digit += tempval;
            pow = 10;
            temp = temp.next;
        }

        return  getDecimal(digit);
    }


        public  int getDecimal(int binary){
            int decimal = 0;
            int n = 0;
            while(true){
                if(binary == 0){
                    break;
                } else {
                    int temp = binary%10;
                    decimal += temp*Math.pow(2, n);
                    binary = binary/10;
                    n++;
                }
            }
            return decimal;
        }


    public static void main(String[] args) {
//        LL l = new LL();
//        l.insertAtFirst(10);
//        l.insertAtFirst(20);
//        l.insertAtFirst(30);
//        l.insertAtFirst(40);
//        l.insertdAtEnd(50);
//        l.insertdAtEnd(60);
//        l.insertdAtEnd(70);
//        l.insertdAtEnd(80);
//        l.insertAtIndex(65,3);
//        l.insertAtIndex(5,0);
//        l.insertAtIndex(8,0);
//        l.insertAtIndex(9,12);
//        System.out.println(l.deleteFirst());
//        System.out.println(l.deleteLast());
//        l.display();
////        System.out.println(l.size);
//        System.out.println(l.deleteIndex(4));
//        l.display();

        LL list = new LL();
        list.insertAtFirst(1);
        list.insertdAtEnd(0);
        list.insertdAtEnd(0);
        list.insertdAtEnd(1);
        list.insertdAtEnd(0);
        list.insertdAtEnd(0);
        list.insertdAtEnd(1);
        list.insertdAtEnd(1);
        list.insertdAtEnd(1);
        list.insertdAtEnd(0);
        list.insertdAtEnd(0);
        list.insertdAtEnd(0);
        list.insertdAtEnd(0);
        list.insertdAtEnd(0);
        list.insertdAtEnd(0);
        int val = list.getDecimalValue(list.head);
        System.out.println(val);
    }

}
