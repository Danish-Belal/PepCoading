package SelfCode;

public class DoubliLL {
   private Node head;
   private Node tail;
    int size;

    public DoubliLL(){
        this.size = 0;
    }

    private class Node{
        int data;
        Node next;
        Node pre;

        private  Node(int val){
            this.data = val;
        }

        public Node(int data, Node next, Node pre) {
            this.data = data;
            this.next = next;
            this.pre = pre;
        }
    }

    void insertAtFirst(int val){
        Node node = new Node(val);
        if(size == 0) {
            tail = node;
        }
        node.next = head;
        node.pre = null;
        if(head != null){
            head.pre = node;
        }
        head = node;
        size++;
    }

    void insertLast(int val){
        Node node = new Node(val);
        if(tail != null)
            tail.next = node;
        else
            head = node;
        node.next = null;
        node.pre  =tail;
        tail = node;
        size++;
    }

    void insertAtIndex(int val , int index){
        Node node = new Node(val);
        if(index > size+1){
            System.out.println("Invalid Index");
            return;
        }
        if (index == 0)
            insertAtFirst(val);
        if (index == size)
            insertLast(val);
        Node temp = head;
        for(int i = 0 ; i<index-1 ; i++){
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next.pre = node;
        node.pre = temp;
        temp.next = node;
        size++;
    }


    void displayforward(){
        Node temp = head ;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void displayBackward(){
        Node temp = tail;
        while (temp != null){
            System.out.print(temp.data+ " ");
            temp = temp.pre;
        }
        System.out.println();
    }


    public static void main(String[] args) {

        DoubliLL linkList = new DoubliLL();
        linkList.insertAtFirst(50);
        linkList.insertAtFirst(40);
        linkList.insertAtFirst(30);
        linkList.insertAtFirst(20);
        linkList.insertAtFirst(10);
//        linkList.displayforward();
//        linkList.displayBackward();
        linkList.insertLast(60);
        linkList.insertLast(70);
        linkList.insertLast(80);
        linkList.insertLast(90);
//        linkList.displayforward();
//        linkList.displayBackward();
     //   linkList.insertAtIndex(56,9);
        linkList.insertAtIndex(57,3);
        linkList.displayforward();
        linkList.displayBackward();



    }
}
