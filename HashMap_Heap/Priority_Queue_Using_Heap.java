package HashMap_Heap;
/*
1. You are required to complete the code of our Priority Queue class using the heap data structure.
    Please watch the question video carefully. The theoretical details of required functionality is explained in detail there.
    Implement the functions to achieve what is explained in the theoretical discussion in question video.

2. Here is the list of functions that you are supposed to complete:
    2.1. add -> Should accept new data.
    2.2. remove -> Should remove and return smallest value, if available or print
     "Underflow" otherwise and return -1.
     2.3. peek -> Should return smallest value, if available or print "Underflow"
     otherwise and return -1.
     2.4. size -> Should return the number of elements available.
3. Input and Output is managed for you.

Sample Input

add 10
add 20
add 30
add 40
peek
add 50
peek
remove
peek
remove
peek
remove
peek
remove
peek
quit

Sample Output

10
10
10
20
20
30
30
40
40
50
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Priority_Queue_Using_Heap {
    public static class PriorityQueue {
        ArrayList<Integer> data;

        public PriorityQueue() {
            data = new ArrayList<>();
        }

        public void add(int val) {
            // write your code here
            data.add(val);
            unheapfy(data.size()-1);
        }

        public void unheapfy( int ci){
            if(ci == 0) {
                return;
            }

            int pi = (ci-1)  /2;
            if( data.get(ci) < data.get(pi)){
               swap(ci , pi);
                unheapfy(pi);
            }
        }

        public void swap(int i , int j){
            int temp = data.get(i);
            data.set(i, data.get(j));
            data.set(j , temp);
        }
        public int remove() {
            // write your code here
            if(data.size() == 0){
                System.out.println("Underflow");
                return -1;
            }

            swap(0 , data.size()-1);
            int ans = data.remove(data.size()-1);
            downheapfy(0);
            return ans;

        }
        public void downheapfy(int pi){
            int li = 2*pi +1;
            int ri = 2*pi +2;

            int minidx = pi;

            if(li < data.size() && data.get(li) < data.get(minidx)){
                minidx = li;
            }
            if(ri < data.size() &&data.get(ri) < data.get(minidx)) {
                minidx = ri;
            }

            if(minidx != pi){
                swap(pi , minidx);
                downheapfy(minidx);
            }
        }

        public int peek() {
            // write your code here
            if(data.size() == 0){
                System.out.println("Underflow");
                return -1;
            }
            return data.get(0);
        }

        public int size() {
            // write your code here
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}
