package Stack_Queue;
import java.io.*;
import java.util.Stack;

/*
1. You are given a postfix expression.
2. You are required to evaluate it and print it's value.
3. You are required to convert it to infix and print it.
4. You are required to convert it to prefix and print it.

Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.
Constraints

1. Expression is a valid postfix expression
2. The only operators used are +, -, *, /
3. All operands are single digit numbers.

Sample Input

264*8/+3-

Sample Output

2
((2+((6*4)/8))-3)
-+2/*6483
 */

public class PostfixEvaluationAndConversions {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
       // String exp = "264*8/+3-";
      Evalution(exp);
    }
    public static void Evalution(String str){
        Stack<Integer> st = new Stack<>();
        Stack<String > infix = new Stack<>();
        Stack<String> prefix  = new Stack<>();

        for(int i = 0 ; i<str.length() ; i++){
            char ch = str.charAt(i);
            if(ch >= '0' && ch<= '9'){
                st.push(ch-'0');

                prefix.push(ch+"");

                infix.push(ch+"");

            } else if(ch == '+' || ch == '-' || ch== '*' || ch=='/'){

                // For value.
                int c2 = st.pop();
                int c1 = st.pop();
                int ans = solve( c1 ,  c2 , ch);
                st.push(ans);

                // For infix.
                String  st2 = infix.pop();
                String st1 = infix.pop();
                infix.push('('+st1+ch+st2 + ')');

                // For prefixtfix
                String s2 = prefix.pop();
                String s1 = prefix.pop();
                prefix.push(ch + s1+s2);
            }
        }
        System.out.println(st.peek());
        System.out.println(infix.peek());
        System.out.println(prefix.peek());

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

}
