package LeetCode;
/*
https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
public class MinRemoveTomakeValidPar {
    public static void main(String[] str){
       String s = "lee(t(c)o)de)";
       System.out.println(minRemoveToMakeValid(s));

    }
    public static String minRemoveToMakeValid(String s) {

        StringBuilder str = new StringBuilder();
        int open = 0 ;

        for(char c : s.toCharArray()){
            if(c == '(')
                open++;
            else if(c == ')'){
                if(open == 0) continue;
                open--;
            }
            str.append(c);
        }

        StringBuilder res = new StringBuilder();

        for(int i = str.length()-1 ; i>=0 ; i--){
            if(str.charAt(i) == '(' && open-->0) continue;
            res.append(str.charAt(i));
        }

        return res.reverse().toString();

    }
}
