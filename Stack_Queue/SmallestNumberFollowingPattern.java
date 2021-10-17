package Stack_Queue;
import java.io.*;
import  java.util.*;
/*
1. You are given a pattern of upto 8 length containing characters 'i' and 'd'.
2. 'd' stands for decreasing and 'i' stands for increasing
3. You have to print the smallest number, using the digits 1 to 9 only without repetition, such that
the digit decreases following a d and increases follwing an i.

e.g.
d -> 21
i -> 12
ddd -> 4321
iii -> 1234
dddiddd -> 43218765
iiddd -> 126543


Constraints

0 < str.length <= 8
str contains only 'd' and 'i'

Sample Input
ddddiiii

Sample Output
543216789
 */
public class SmallestNumberFollowingPattern {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // code
       //String  str = "ddddiiii";
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();

        int val = 1 ;
        st.push(val);
        for(int i = 0 ; i<str.length() ; i++){
            int ch = str.charAt(i);
            val +=1;
            if(ch == 'd'){
                st.push(val);
            }else{
                while(st.size() !=0){
                    arr.add(st.pop());
                }
                st.push(val);
            }
        }
        while (st.size() !=0){
            arr.add(st.pop());
        }

        for(int i : arr){
            System.out.print(i);
        }

    }

}
