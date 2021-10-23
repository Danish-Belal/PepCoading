package LinkedList;
import java.io.*;

/*
1. You are given a partially written LinkedList class.
2. You are required to complete the body of addLinkedLists function.
 The function is passed two linked lists which represent two numbers -
 the first element is the most significant digit and the last element is the least significant digit.
 The function is expected to add the two linked list and return a new linked list.

The following approaches are not allowed :
    1. Don't reverse the linked lists in order to access them from least significant digit
     to most significant.
     2. Don't use arrays or explicit extra memory.
     3. Don't convert linked lists to number, add them up and convert the result back
     to a linked list.

Hint - You are expected to take help of recursion to access digits from least significant to most significant.
 You have to tackle the challenge of unequal size of lists and manage carry where required.

3. Input and Output is managed for you.

Note-> Make sure to set head and tail appropriately because addFirst and addLast has been used to test their values in the input-output code.

Constraints

1. Time complexity -> O(n)
2. Space complexity -> Recursion space, O(n)

Sample Input
1
1
3
9 9 9
10
20

Sample Output
1
9 9 9
1 0 0 0
10 1 0 0 0 20

 */

public class AddTwoLinkedLists {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }

        public int size() {
            return size;
        }

        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        public void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
        }

        public int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        public int getLast() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return tail.data;
            }
        }

        public int getAt(int idx) {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
                return -1;
            } else {
                Node temp = head;
                for (int i = 0; i < idx; i++) {
                    temp = temp.next;
                }
                return temp.data;
            }
        }

        public void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;

            if (size == 0) {
                tail = temp;
            }

            size++;
        }

        public void addAt(int idx, int val) {
            if (idx < 0 || idx > size) {
                System.out.println("Invalid arguments");
            } else if (idx == 0) {
                addFirst(val);
            } else if (idx == size) {
                addLast(val);
            } else {
                Node node = new Node();
                node.data = val;

                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                node.next = temp.next;

                temp.next = node;
                size++;
            }
        }

        public void removeLast() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                Node temp = head;
                for (int i = 0; i < size - 2; i++) {
                    temp = temp.next;
                }

                tail = temp;
                tail.next = null;
                size--;
            }
        }

        public void removeAt(int idx) {
            if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
            } else if (idx == 0) {
                removeFirst();
            } else if (idx == size - 1) {
                removeLast();
            } else {
                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }

                temp.next = temp.next.next;
                size--;
            }
        }

        private Node getNodeAt(int idx) {
            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp;
        }

        public void reverseDI() {
            int li = 0;
            int ri = size - 1;
            while (li < ri) {
                Node left = getNodeAt(li);
                Node right = getNodeAt(ri);

                int temp = left.data;
                left.data = right.data;
                right.data = temp;

                li++;
                ri--;
            }
        }

        public void reversePI() {
            if (size <= 1) {
                return;
            }

            Node prev = null;
            Node curr = head;
            while (curr != null) {
                Node next = curr.next;

                curr.next = prev;
                prev = curr;
                curr = next;
            }

            Node temp = head;
            head = tail;
            tail = temp;
        }

        public int kthFromLast(int k) {
            Node slow = head;
            Node fast = head;
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }

            while (fast != tail) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow.data;
        }

        public int mid() {
            Node f = head;
            Node s = head;

            while (f.next != null && f.next.next != null) {
                f = f.next.next;
                s = s.next;
            }

            return s.data;
        }

        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
            LinkedList ml = new LinkedList();

            Node one = l1.head;
            Node two = l2.head;
            while (one != null && two != null) {
                if (one.data < two.data) {
                    ml.addLast(one.data);
                    one = one.next;
                } else {
                    ml.addLast(two.data);
                    two = two.next;
                }
            }

            while (one != null) {
                ml.addLast(one.data);
                one = one.next;
            }

            while (two != null) {
                ml.addLast(two.data);
                two = two.next;
            }

            return ml;
        }

        public static Node midNode(Node head, Node tail) {
            Node f = head;
            Node s = head;

            while (f != tail && f.next != tail) {
                f = f.next.next;
                s = s.next;
            }

            return s;
        }

        public static LinkedList mergeSort(Node head, Node tail) {
            if (head == tail) {
                LinkedList br = new LinkedList();
                br.addLast(head.data);
                return br;
            }

            Node mid = midNode(head, tail);
            LinkedList fsh = mergeSort(head, mid);
            LinkedList ssh = mergeSort(mid.next, tail);
            LinkedList sl = mergeTwoSortedLists(fsh, ssh);
            return sl;
        }

        public void removeDuplicates() {
            LinkedList res = new LinkedList();

            while (this.size() > 0) {
                int val = this.getFirst();
                this.removeFirst();

                if (res.size() == 0 || val != res.tail.data) {
                    res.addLast(val);
                }
            }

            this.head = res.head;
            this.tail = res.tail;
            this.size = res.size;
        }

        public void oddEven() {
            LinkedList odd = new LinkedList();
            LinkedList even = new LinkedList();

            while (this.size > 0) {
                int val = this.getFirst();
                this.removeFirst();

                if (val % 2 == 0) {
                    even.addLast(val);
                } else {
                    odd.addLast(val);
                }
            }

            if (odd.size > 0 && even.size > 0) {
                odd.tail.next = even.head;

                this.head = odd.head;
                this.tail = even.tail;
                this.size = odd.size + even.size;
            } else if (odd.size > 0) {
                this.head = odd.head;
                this.tail = odd.tail;
                this.size = odd.size;
            } else if (even.size > 0) {
                this.head = even.head;
                this.tail = even.tail;
                this.size = even.size;
            }
        }

        public void kReverse(int k) {
            LinkedList prev = null;

            while (this.size > 0) {
                LinkedList curr = new LinkedList();

                if (this.size >= k) {
                    for (int i = 0; i < k; i++) {
                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addFirst(val);
                    }
                } else {
                    int sz = this.size;
                    for (int i = 0; i < sz; i++) {
                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addLast(val);
                    }
                }

                if (prev == null) {
                    prev = curr;
                } else {
                    prev.tail.next = curr.head;
                    prev.tail = curr.tail;
                    prev.size += curr.size;
                }
            }

            this.head = prev.head;
            this.tail = prev.tail;
            this.size = prev.size;
        }

        private void displayReverseHelper(Node node) {
            if (node == null) {
                return;
            }
            displayReverseHelper(node.next);
            System.out.print(node.data + " ");
        }

        public void displayReverse() {
            displayReverseHelper(head);
            System.out.println();
        }

        private void reversePRHelper(Node node) {
            if (node == tail) {
                return;
            }
            reversePRHelper(node.next);
            node.next.next = node;
        }

        public void reversePR() {
            reversePRHelper(head);
            Node temp = head;
            head = tail;
            tail = temp;
            tail.next = null;
        }

        public static int addTwoListsHelper(Node n1 , Node n2 , LinkedList ans , int size1 , int size2){
            if(n1 == null && n2 == null ){
                return 0 ;
            }
            int sum = 0 ;
            int carry =0 ;

            if(size1 > size2){
                carry = addTwoListsHelper(n1.next , n2 , ans , size1-1,size2);
                sum = n1.data+carry;
            }else if(size2 > size1){
                carry = addTwoListsHelper(n1 , n2.next , ans , size1,size2-1);
                sum = n2.data+carry;
            }else{
                carry = addTwoListsHelper(n1.next , n2.next , ans , size1-1,size2-1);
                sum = n1.data + n2.data + carry;
            }
            int c = sum/10;
            sum =sum%10;
            ans.addFirst(sum);
            return c;

        }
        public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
            // write your code here
            LinkedList ans = new LinkedList();
            int c = addTwoListsHelper(one.head , two.head ,ans, one.size(),two.size());
            if(c> 0){
                ans.addFirst(c);
            }

            return ans;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(br.readLine());
        LinkedList l1 = new LinkedList();
        String[] values1 = br.readLine().split(" ");
        for (int i = 0; i < n1; i++) {
            int d = Integer.parseInt(values1[i]);
            l1.addLast(d);
        }

        int n2 = Integer.parseInt(br.readLine());
        LinkedList l2 = new LinkedList();
        String[] values2 = br.readLine().split(" ");
        for (int i = 0; i < n2; i++) {
            int d = Integer.parseInt(values2[i]);
            l2.addLast(d);
        }

        LinkedList sum = LinkedList.addTwoLists(l1, l2);

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        l1.display();
        l2.display();
        sum.display();
        sum.addFirst(a);
        sum.addLast(b);
        sum.display();
    }
}
