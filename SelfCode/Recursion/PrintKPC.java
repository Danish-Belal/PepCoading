package SelfCode.Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintKPC {
    static  String[] codes ={".;", "abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str= scn.nextLine();
        KPC(str , "");


    }
    public static void KPC(String  str , String ans){
        if(str.length() == 0){
            System.out.print(ans +" ");
            return;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        String code = codes[ch - '0'];
        for (int i = 0 ; i <code.length() ; i++){
            char cc = code.charAt(i);
            KPC(ros , ans+cc);
          //  KPC(ros, ans);
           
        }
    }
}
