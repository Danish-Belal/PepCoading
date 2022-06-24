package DSAS.Arrays;
/*
Given a string A, rotate the string B times in clockwise direction and return the string.
Problem Constraints

1 <= |A| <= 105

1 <= B <= 109

String A consist only of lowercase characters.
 */
public class RotateString {
    public static void main(String[] args){
        String s = "academy";
        System.out.println(solve(s, 1));
    }

    public static String solve(String A, int B) {
        if(B== A.length()) return A;

        B = B%A.length();

        String b = A.substring(A.length()-B);
        String a = A.substring(0,A.length()-B);
        b += a;
        return b;

    }
}
