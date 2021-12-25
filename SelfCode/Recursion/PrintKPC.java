package SelfCode.Recursion;

import java.util.ArrayList;

public class PrintKPC {
    static  String[] codes ={".;", "abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static void main(String[] args) {


    }
    public static void KPC(String  str , String ans){

        char ch = str.charAt(0);
        String ros = str.substring(1);

        String code = codes[ch - '0'];
        for (int i = 0 ; i <code.length() ; i++){
            char cc = code.charAt(i);
           
        }
    }
}
