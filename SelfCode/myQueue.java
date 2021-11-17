 package SelfCode;
class myQueue{
    public static class Queue{
        int[] data;
        int front;
        int size;

        public Queue(int cap){
            data = new int[cap];
            front = 0;
            size = 0;
        }
        public  void enQueue(int val){
            if(size == data.length){
                System.out.println("Queue overflow");
                int[] oa = data;
                data = new int[oa.length*2];
                for(int i = 0 ; i<size ; i++){
                    data[i] = oa[(i+front)%oa.length];
                }
            }
                int rear = (size+front)% data.length;
                data[rear] = val;
                size++;


        }
        public int deQueue(){
            if(size == 0){
                System.out.println("Queue Underflow");
                return -1;
            }
            int val = data[front];
            front = (front+1)% data.length;
            size--;
            return val;
        }
        public void display(){
            for(int i = 0 ; i<size ; i++){
                System.out.print(data[(front+i)%data.length]+ " ");
            }
            System.out.println();
        }
        public int size(){
            return size;
        }
    }
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);
        queue.display();
        queue.enQueue(50);

        queue.enQueue(60);
     int a =   queue.deQueue();
      int b=  queue.deQueue();
     int c =   queue.deQueue();
        queue.enQueue(70);
        queue.enQueue(80);
        queue.enQueue(90);
        queue.enQueue(100);
        queue.enQueue(110);
        queue.display();



    }


}



