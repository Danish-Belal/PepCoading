package Recursion;
/*
You are given a string and a character , you have to skip all char in original string.
 */
public class SkipCharInString {
    public static void main(String[] args) {
        String str = "baccadh";
        char c = 'a';

        skipChar(c , str , "");
        System.out.println(skipChar(c, str));   // Without Pasing extra ans string.

        System.out.println(skipApple("bcappleabd"));
    }
    public static void skipChar(char c , String str , String ans){
        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }
        char ch =  str.charAt(0);
        String subStr = str.substring(1);

        if(ch == c){
            skipChar(c , subStr , ans);
        }else{
            skipChar(c , subStr , ans+ch);
        }

    }

    public static String skipChar(char c , String str ){
        if(str.isEmpty()){
          ;
            return "";
        }
        char ch = str.charAt(0);
        if(ch == c){
            return skipChar( c ,  str.substring(1));
        }else{
          return  ch+ skipChar(c ,   str.substring(1));
        }

    }

    public static String skipApple( String str ){
        if(str.isEmpty()){
            return "";
        }

        if(str.startsWith("apple")){
            return skipApple(str.substring(5));
        }else{
            return  str.charAt(0)+ skipApple( str.substring(1));
        }

    }
}
