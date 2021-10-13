package Stack_Queue;
import java.io.*;
import java.util.Stack;

/*
1. You are given a prefix expression.
2. You are required to evaluate it and print it's value.
3. You are required to convert it to infix and print it.
4. You are required to convert it to postfix and print it.

Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.
Constraints

1. Expression is a valid prefix expression
2. The only operators used are +, -, *, /
3. All operands are single digit numbers.

Sample Input
-+2/*6483

Sample Output
2
((2+((6*4)/8))-3)
264*8/+3-
 */



public class PrefixEvaluationAndConversions {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
      //  String exp = "-+2/*6483";
        Evalution(exp);
    }

    private static void Evalution(String str) {
        Stack<Integer> st = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<String > Infix = new Stack<>();

        for(int i = str.length()-1 ; i>=0 ; i--){
            char ch = str.charAt(i);
            if(ch >= '0' && ch<= '9'){
                st.push(ch-'0');
                postfix.push(ch+"");
                Infix.push(ch+"");
        }else if(ch == '+' || ch == '-' || ch== '*' || ch=='/'){
                // For value.
                int c1 = st.pop();
                int c2 = st.pop();
                int ans = solve( c1 ,  c2 , ch);
                st.push(ans);

                // For infix.
                String  st1 = Infix.pop();
                String st2 = Infix.pop();
                Infix.push('(' + st1 + ch + st2 + ')');

                // For prefixtfix
                String s1 = postfix.pop();
                String s2 = postfix.pop();
                postfix.push( s1+s2 + ch);
            }
        }
        System.out.println(st.peek());
        System.out.println(Infix.peek());
        System.out.println(postfix.peek());

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
