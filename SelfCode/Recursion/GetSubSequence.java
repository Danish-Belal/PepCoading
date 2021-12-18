package SelfCode.Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetSubSequence {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
      //  ArrayList<String> ans = gss(str);

        System.out.println(gss(str));

    }

    public static ArrayList<String> gss(String str) {

        if(str.length() == 0){
           ArrayList<String> ans =  new ArrayList<>();
           ans.add("");
           return ans;
        }
        char c = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> rr = gss(ros);

        ArrayList<String> mr = new ArrayList<>();
       for(int i = 0 ; i<rr.size() ; i++){
           mr.add(rr.get(i));
       }

        for(int i = 0 ; i<rr.size() ; i++){
            mr.add(c+rr.get(i));
        }
        return mr;
    }

}
