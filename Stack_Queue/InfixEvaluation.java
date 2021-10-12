package Stack_Queue;
import java.util.*;
import java.io.*;

/*
1. You are given an infix expression.
2. You are required to evaluate and print it's value.
Constraints

1. Expression is balanced
2. The only operators used are +, -, *, /
3. Opening and closing brackets - () - are used to impact precedence of operations
4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
5. In two operators of equal precedence give preference to the one on left.
6. All operands are single digit numbers.

Sample Input

2 + 6 * 4 / 8 - 3

Sample Output

2
 */
public class InfixEvaluation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
      //  System.out.println(exp);
        System.out.println(infix(exp));

    }

    public static int infix(String str){
        Stack<Integer> st1 = new Stack<>();  // operands
        Stack<Character> st2  = new Stack<>();  // Operators

        for(int i  =0 ; i<str.length() ; i++){
            char ch = str.charAt(i);
            if(ch >= '0' && ch <= '9') {
                st1.push(ch - '0');
            }else if(ch == '('){
                st2.push(ch);
            }else if(ch == ')'){
                while (st2.peek() != ')'){
                    char oprtr = st2.pop();
                    int op2 = st1.pop();
                    int op1 = st1.pop();
                    int res = solve(op1 , op2 , oprtr);
                    st1.push(res);
                }
                // Finally pop opening brackets.
                st2.pop();
            } else if(ch == '+' || ch == '-' || ch == '*' || ch == '/' ){
                while (st2.size() > 0 && precedence(st2.peek()) >= precedence(ch)){
                    char oprtr = st2.pop();
                    int op2 = st1.pop();
                    int op1 = st1.pop();
                    int res = solve(op1 , op2 , oprtr);
                    st1.push(res);
                }
                st2.push(ch);
            }else{
                // Do Nothing.
            }

        }
        while (st2.size() != 0 ){
            char oprtr = st2.pop();
            int op2 = st1.pop();
            int op1 = st1.pop();
            int res = solve(op1 , op2 , oprtr);
            st1.push(res);
        }
        return st1.peek();
    }


    public static int solve(int op1 , int op2 , char opr){
        if (opr == '+') {
            return op1+op2;
        }else if(opr == '-'){
            return op1-op2;

        }else if(opr == '*'){
            return op1*op2;
        }else{
            return op1/op2;
        }
    }
    public static int precedence(char ch){
        if(ch == '*' || ch == '/'){
            return 2;
        }else if(ch == '+' || ch == '-'){
            return 1;
        }else{
            return 0;
        }
    }
}
