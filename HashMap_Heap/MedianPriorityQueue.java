package HashMap_Heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
1. You are required to complete the code of our MedianPriorityQueue class. The class should mimic the behaviour of a PriorityQueue and give highest priority to median of it's data.
2. Here is the list of functions that you are supposed to complete
2.1. add -> Should accept new data.
2.2. remove -> Should remove and return median value, if available or print "Underflow" otherwise and return -1
2.3. peek -> Should return median value, if available or print "Underflow" otherwise and return -1
2.4. size -> Should return the number of elements available
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

Output:

20
30
30
20
20
40
40
10
10
50
 */


public class MedianPriorityQueue {

    public static class MedianPriorityQueuee {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public MedianPriorityQueuee() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void add(int val) {
            // write your code here
//           if(left.size() == 0){
//               if( right.size() > 0) {
//                   right.add(val);
//               }
//               else{
//                   left.add(val);
//               }
//
//           }else if(val < left.peek()){
//               left.add(val);
//           }else{
//               right.add(val);
//           }
//           int diff = Math.abs(left.size() - right.size());
//           if(diff > 1){
//               if(left.size() > right.size()){
//                   right.add(left.remove());
//               }else{
//                   left.add(right.remove());
//               }
//           }


            if(left.isEmpty() || val < left.peek()){
                left.add(val);
            }else{
                right.add(val);
            }

            if(left.size() > right.size()+1){
                right.add(left.poll());
            }else if(right.size() > left.size() +1){
                left.add(right.poll());
            }
        }

        public int remove() {
            // write your code here
            if(left.size() == 0 && right.size() == 0){
                System.out.println("Underflow");
                return -1;
            }
            int diff = Math.abs(left.size()-right.size());
            if(diff == 0) return left.poll();
            else{
                if(left.size()  >right.size()  ){
                     return left.poll();
                }else{
                    return right.poll();
                }
            }

        }

        public int peek() {
            // write your code here
            if(left.size() == 0 && right.size() == 0){
                System.out.println("Underflow");
                return -1;
            }
            int diff = Math.abs(left.size()-right.size());
            if(diff == 0) return left.peek();
            else{
                if(left.size()  >right.size()  ){
                    return left.peek();
                }else{
                    return right.peek();
                }
            }
        }

        public int size() {
            // write your code here
            return left.size()+right.size();
        }

        public double findMedian() {
            int size = left.size()+right.size();
            if(size == 1){
                if(left.size() == 0){
                    return right.peek();
                }else{
                    return left.peek();
                }
            }

            if(size%2 == 0){
                return (left.peek()+right.peek())/2;
            }else{
                if(left.size() < right.size()){
                    return right.peek();
                }else{
                    return left.peek();
                }
            }

        }


    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MedianPriorityQueuee qu = new MedianPriorityQueuee();

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
            }else if(str.startsWith("Median")){
                System.out.println(qu.findMedian());
            }
            str = br.readLine();
        }
    }

}



