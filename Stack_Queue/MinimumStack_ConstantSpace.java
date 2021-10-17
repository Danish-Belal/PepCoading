package Stack_Queue;
import java.io.*;
import java.util.*;
/*
1. You are required to complete the code of our MinStack class.
2. As data members you've one stack and a min element available in the class. (This is cryptic - take hint from video)
3. Here is the list of functions that you are supposed to complete
      3.1. push -> Should accept new data in LIFO manner.
      3.2. pop -> Should remove and return data in LIFO manner. If not available, print
       "Stack underflow" and return -1.
      3.3. top -> Should return data in LIFO manner. If not available, print "Stack
      underflow" and return -1.
     3.4. size -> Should return the number of elements available in the stack.
     3.5. min -> Should return the smallest element available in the stack. If not
     available, print "Stack underflow" and return -1.
4. Input and Output is managed for you.

Note -> The judge maynot be able to check if all your functions are O(1) in time,
 but that is what the expectation is. Also, you can only use constant space.r
 Sample Input

push 10
push 20
push 5
push 8
push 2
push 4
push 11
top
min
pop
top
min
pop
top
min
pop
top
min
pop
top
min
pop
top
min
pop
top
min
pop
quit

Sample Output
11
2
11
4
2
4
2
2
2
8
5
8
5
5
5
20
10
20
10
10
10
 */
public class MinimumStack_ConstantSpace {
    public static class MinStack {
        Stack<Integer> data;
        int min;

        public MinStack() {

            data = new Stack<>();
        }

        int size() {
            // write your code here
            return data.size();
        }

        void push(int val) {
            // write your code here
            if(data.size() == 0){
                data.push(val);
                min = val;
            }else {
                if(val >= min){
                    data.push(val);
                }else{

                    int mv = val + (val-min);
                    data.push(mv);
                    min = val;
                }
            }

        }

        int pop() {
            // write your code here
            if(data.size() == 0){
                System.out.println("Stack underflow");
                return -1;
            }else {

                if(data.peek() >= min){
                    return data.pop();
                }else {
                    int v = min;
                   int prvmin = min + min-data.peek();
                   min = prvmin;
                   data.pop();
                   return v;
                }
            }

        }

        int top() {
            // write your code here
            if(data.size() == 0){
                System.out.println("Stack underflow");
                return -1;
            }
            if(data.peek() >= min){
                return data.peek();
            }else {
                return min;
            }
        }

        int min() {
            // write your code here
            if(data.size() == 0){
                System.out.println("Stack underflow");
                return -1;
            }
              return min;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("min")) {
                int val = st.min();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }
}
