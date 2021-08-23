
/*
1. You are given a string str.
2. Complete the body of printSS function - without changing signature -
to calculate and print all subsequences of str.
Use sample input and output to take idea about subsequences.
Constraints

0 <= str.length <= 7

Sample Input

yvTA

Sample Output

yvTA
yvT
yvA
yv
yTA
yT
yA
y
vTA
vT
vA
v
TA
T
A


 */
package Recursion_on_the_Way_up;

import java.util.Scanner;

public class PrintSubsequence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String ans = "";
        printSS(str , ans);

    }

    public static void printSS(String str, String ans) {
        if(str.length() == 0){
            System.out.println(ans);
            return ;
        }


      char ch = str.charAt(0);
      String ros = str.substring(1);
        printSS(ros , ans+ch);
      printSS(ros , ans);

    }


}
