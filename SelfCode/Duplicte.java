package SelfCode;

import java.util.Stack;

public class Duplicte {
    public static  boolean isDuplicate(String s){
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == ')'){
                if(st.peek() == '(')return  true;
                else{
                    while (st.peek() != '('){
                        st.pop();
                    }
                    st.pop();
                }
            }else{
                st.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "((a + b) + (c + d))";
   //   String str = "(a + b)+((c + d))";
        boolean ans = isDuplicate(str);
        System.out.println(ans);

    }
}
