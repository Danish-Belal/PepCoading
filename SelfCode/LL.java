package SelfCode;

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
        n.data = val;
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

   public void display(){
        Node n = head;
        while(n != tail){
            System.out.print(n.data+" --> ");
            n = n.next;
        }
       System.out.println(n.data );
       System.out.println();
   }


    public static void main(String[] args) {
        LL l = new LL();
        l.insertAtFirst(10);
        l.insertAtFirst(20);
        l.insertAtFirst(30);
        l.insertAtFirst(40);
        l.insertdAtEnd(50);
        l.insertdAtEnd(60);
        l.insertdAtEnd(70);
        l.insertdAtEnd(80);
        l.insertAtIndex(65 , 3);
        l.insertAtIndex(5,0);
        l.insertAtIndex(8,0);
        l.insertAtIndex(9,12);
        l.display();
        System.out.println(l.size);


    }

}
