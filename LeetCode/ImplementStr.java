package LeetCode;

public class ImplementStr {
    public static int strStr(String haystack, String needle) {

        if(needle.length() ==0) return 0;
        if(haystack.equals(needle)) return 0;

        for(int i = 0 ; i<haystack.length()-needle.length() ;i++){
           if(haystack.substring(i,i+needle.length()).equals(needle)) return i;
        }
        return -1;

    }
    public static void main(String[] args){
        String s = "l";
        String n = "l";
        System.out.println(strStr(s , n));
    }
}
