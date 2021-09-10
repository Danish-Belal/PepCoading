package Stack_Queue;
import java.io.*;
import java.util.*;


/*

1. You are given a string exp representing an expression.
2. Assume that the expression is balanced  i.e. the opening and closing brackets match with each other.
3. But, some of the pair of brackets maybe extra/needless.
4. You are required to print true if you detect extra brackets and false otherwise.

e.g.'
((a + b) + (c + d)) -> false
(a + b) + ((c + d)) -> true

Sample Input

(a + b) + ((c + d))

Sample Output

true
 */
public class Duplicate_Brackets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String  str = in.nextLine();
      boolean ans =  bucket(str);
        System.out.println(ans);


    }
    static  boolean bucket(String str) {
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ele = str.charAt(i);
            if(ele == ')'){    //(a + b) + ((c + d))
                if(stk.peek() == '(') return true;
                else {
                    while (stk.peek() != '('){
                        stk.pop();
                    }
                    stk.pop();
                }

            }else{
                stk.push(ele);
            }
        }



        return false;
    }
}

