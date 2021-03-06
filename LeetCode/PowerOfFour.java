package LeetCode;
/*
https://leetcode.com/problems/power-of-four/

Given an integer n, return true if it is a power of four. Otherwise, return false.
An integer n is a power of four, if there exists an integer x such that n == 4x.

Example 1:
Input: n = 16
Output: true
Example 2:

Input: n = 5
Output: false
 */
public class PowerOfFour {
    public static void main(String[] args) {
      //  int n = 56;
        int n = 16;
        boolean ans = isPowerOfFour(n);
        System.out.println(ans);

    }
    public static boolean isPowerOfFour(int n) {
//        if(n <= 0) return false;
//        if(n==1 || n==4 ) return true ;
//        return n%4 == 0 && isPowerOfFour(n/4) ;

        // Another Approach
//        if(n==1||n==4) return true ;
//        if(n==0||n<0) return false;
//        if(n%4==0){
//            return isPowerOfFour(n/4);
//        }else return false ;



        // Another Approach
        if(n <= 0) return false;
        else {
            while (n>1) {
                if(n%4!=0) return false;
                n/=4;
            }
        }
        return true;

    }
}
