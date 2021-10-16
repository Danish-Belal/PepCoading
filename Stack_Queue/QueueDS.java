package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class QueueDS {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(60);
        q.add(50);

        while (q.size() !=0){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
