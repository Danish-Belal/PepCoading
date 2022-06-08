package LeetCode;

public class RemovePalindromicString {
    public static void main(String[] args){
        System.out.println(removePalindromeSub("aabbbaaa") );
    }
    public static int removePalindromeSub(String s) {
        if(s.length() == 0) return 0;
        if(isPlalindrome(s)) return 1;
        return 2;
    }
    static boolean  isPlalindrome(String s){
        int i = 0  , j = s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
