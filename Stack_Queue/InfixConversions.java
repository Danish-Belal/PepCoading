package Stack_Queue;
import java.io.*;
import java.util.Stack;
/*
1. You are given an infix expression.
2. You are required to convert it to postfix and print it.
3. You are required to convert it to prefix and print it.
Constraints

1. Expression is balanced
2. The only operators used are +, -, *, /
3. Opening and closing brackets - () - are used to impact precedence of operations
4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
5. In two operators of equal precedence give preference to the one on left.
6. All operands are single digit numbers.

Sample Input
a*(b-c+d)/e

Sample Output
abc-d+*e/
/*a+-bcde

 */

public class InfixConversions {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        conversion(exp);
    }
    public static void conversion(String str){
        Stack<String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (int i = 0; i<str.length() ; i++){
            char ch = str.charAt(i);

            if(ch >= 'a' && ch<='z'){
                prefix.push(ch+"");
                postfix.push(ch+"");
            }else if(ch == '('){
                operator.push(ch);

            }else if(ch == ')'){
                while (operator.peek() != '('){
                    char oprt = operator.pop();

                    String ch2 = prefix.pop();
                    String ch1 = prefix.pop();
                    prefix.push(oprt+ch1+ch2);

                    String ch3 = postfix.pop();
                    String ch4 = postfix.pop();
                    postfix.push(ch4 + ch3 + oprt);

                }
                // pop (
                operator.pop();

            }else if(ch == '+' || ch == '-' || ch== '*' || ch=='/'){
               while (operator.size() > 0 && precedene(operator.peek()) >= precedene(ch)){
                   char oprt = operator.pop();

                   String ch2 = prefix.pop();
                   String ch1 = prefix.pop();
                   prefix.push(oprt+ch1+ch2);

                   String ch3 = postfix.pop();
                   String ch4 = postfix.pop();
                   postfix.push(ch4 + ch3 + oprt);
               }
               operator.push(ch);


            }
        }
        while (operator.size() != 0){
            char oprt = operator.pop();

            String ch2 = prefix.pop();
            String ch1 = prefix.pop();
            prefix.push(oprt+ch1+ch2);

            String ch3 = postfix.pop();
            String ch4 = postfix.pop();
            postfix.push(ch4 + ch3 + oprt);
        }

        System.out.println(postfix.peek());
        System.out.println(prefix.peek());


    }

    public static int precedene(char ch){
        if (ch == '*' || ch == '/') {
            return 2;
        }else if(ch == '+' || ch == '-'){
            return 1;
        }else{
            return 0;
        }
    }



}
