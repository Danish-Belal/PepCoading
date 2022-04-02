package LeetCode;
/*
https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPali_ll {
    public static void main(String[] args){
        String s = "abab";
        System.out.println(validPalindrome(""));
    }

    static boolean isPali(String s , int i , int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public static boolean validPalindrome(String s) {

        int i = 0 ;
        int j = s.length()-1;

        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                boolean l1 = isPali(s , i+1 , j);
                if(l1) return true;

                boolean r1 = isPali(s , i , j-1);
                if(r1) return true;
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
