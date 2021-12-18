package SelfCode.Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetKPC {
    public static void main(String[] args)  {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        //  ArrayList<String> ans = gss(str);

        System.out.println(getKPC(str));
    }

    static  String[] codes ={".;", "abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

     public static ArrayList<String> getKPC(String str) {
            if(str.length() == 0){
                ArrayList<String> ans = new ArrayList<>();
                ans.add("");
                return ans;
            }

         char ch = str.charAt(0);
         String ros = str.substring(1);

         ArrayList<String> rr = getKPC(ros);
         ArrayList<String> ans = new ArrayList<>();

         String s1 = codes[ch-'0'];
        // System.out.println(s1);
         for(int i = 0 ; i<s1.length() ;i++){
            char c = s1.charAt(i);
             for(int j = 0 ; j<rr.size() ; j++){
                 ans.add(c+rr.get(j));
             }
         }

         return ans;
    }
}
