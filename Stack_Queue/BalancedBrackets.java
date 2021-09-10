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
        String  str = "[(a + b) + {(c + d) * (e / f)}]";
        boolean ans = isBalanced(str);
        System.out.println(ans);

    }
    public static boolean isBalanced(String  str){
        Stack<Character> stk = new Stack<>();
        for (int i =0 ; i < str.length() ; i++){
            char ele = str.charAt(i);
            if(ele == ')' || ele == '}' || ele == ']'){
                if(ele == ')'){
                    if(stk.peek() == '('){
                        stk.pop();
                    }else{
                       return false;
                    }
                }else if( ele == '}'){
                    if(stk.peek() == '{'){
                        stk.pop();
                    }else{
                        return false;
                    }

                }else if(ele == '['){
                    if(stk.peek() == ']'){
                        stk.pop();
                    }
                    else{
                        return false;
                    }
                }



            }else if(ele == '(' || ele == '{' || ele == '['){
                stk.push(ele);
            }
        }

     if(stk.empty()) return true;

        return   false;
    }

}
