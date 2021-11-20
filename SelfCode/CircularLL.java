package SelfCode;

public class CircularLL {
    private Node head;
    private Node tail;

    CircularLL() {
        this.head = null;
        this.tail = null;
    }

    private class Node{
        int data;
        Node next;

        public Node(int val){
            this.data = val;
        }
    }

    public void insertionAtHead(int val){
        Node node = new Node(val);

        if(head == null ){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void deleteVal(int val){
        Node temp = head;
        if(temp== null)
            return;
        if(temp.data == val){
            head = head.next;
            tail.next = head;
            return;
        }

        do{
            Node n = temp.next;
            if(n.data == val){
                temp.next = n.next;
                break;
            }
            temp = temp.next;
        }while ( temp != head);

    }

    public void display(){
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp =temp.next;
        } while (temp != head);
        System.out.println();

    }
    public static void main(String[] args) {
        CircularLL list = new CircularLL();
        list.insertionAtHead(10);
        list.insertionAtHead(20);
        list.insertionAtHead(30);
        list.insertionAtHead(40);
        list.display();
        list.insertionAtHead(50);
        list.insertionAtHead(60);
        list.deleteVal(10);
        list.deleteVal(30);
        list.display();
        list.insertionAtHead(70);
        list.display();


    }
}
