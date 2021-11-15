package SelfCode;

public class Queue {
    int[] data;
    int front;
    int size;

    Queue (int cap){
        data = new int[cap];
         front = 0;
         size = 0;
    }
    int size(){
        return size;
    }
    void EnQueue(int val){
        if(data.length == size){
            System.out.println("Queue Overflow");
            int[] oa = data;
            data = new int[oa.length *2];
            for(int i =  0 ; i<oa.length ; i++){
                data[i] = oa[(front+i)%oa.length];
            }

//            int rear = (front+size)%data.length;
//            data[rear] = val;
//            size++;


        }else{
            int rear = (front+size)%data.length;
            data[rear] = val;
            size++;
        }
    }

    int DeQueue(){
        if(size == 0){
            System.out.println("Queue Underflow");
            return -1;
        }else{
            int val = data[front];
            front = (front+1)%data.length;
            size--;
            return val;
        }
    }

    void Display(){
        for(int i = 0; i<size ; i++){
            System.out.print(data[(front+i)%data.length] + " ");

        }
        System.out.println();
    }


    public static void main(String[] args) {
        Queue Q = new Queue(5);
        Q.EnQueue(10);
        Q.EnQueue(20);
        Q.EnQueue(30);
        Q.EnQueue(40);
        Q.EnQueue(50);
        Q.EnQueue(60);
        Q.EnQueue(70);
        Q.EnQueue(80);
        Q.EnQueue(90);
        Q.Display();



    }
}
