package Stack_Queue;
import java.io.*;
import java.util.*;

/*
1. You are given a string exp representing an expression.
2. You are required to check if the expression is balanced i.e. closing brackets and opening brackets match up well.

e.g.
[(a + b) + {(c + d) * (e / f)}] -> true
[(a + b) + {(c + d) * (e / f)]} -> false
[(a + b) + {(c + d) * (e / f)} -> false
([(a + b) + {(c + d) * (e / f)}] -> false

Constraints
0 <= str.length <= 100
Sample Input
[(a + b) + {(c + d) * (e / f)}]
Sample Output
true

 */
public class BalancedBrackets {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        String  str = in.nextLine();
        boolean ans = isBalanced(str);
        System.out.println(ans);

    }
    public static boolean isBalanced(String  str){
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i<str.length() ; i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stk.push(ch);

            }else if(ch == ')' || ch == '}' || ch == ']'){
                if(stk.size() == 0){
                    return false;
                }else if(ch == ')'){
                    if(stk.peek() != '(' ){
                        return false;
                    }

                }else if(ch == '}'){
                    if(stk.peek() != '{' ){
                        return false;
                    }

                }else if(ch == ']') {
                    if(stk.peek() != '[' ){
                        return false;
                    }

                }
                stk.pop();
            }else{
                // ignore
            }
        }
      if(stk.size() == 0){
          return true;
      }else{

          return false;
      }

    }

}
