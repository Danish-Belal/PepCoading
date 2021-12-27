package SelfCode.Recursion;

import java.util.Scanner;

public class PrintEncoading {
    public static void main(String[] args) throws Exception {
//        Scanner scn = new Scanner(System.in);
//        String str = scn.nextLine();
//        printEncodings(str , "");

        String str = "1203";
        printEncodings(str , "");

    }

    public static void printEncodings(String str , String ans ) {
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        if(str.charAt(0) == '0'){
            return;
        }

        String ch = str.substring(0,1);
        String ros1 = str.substring(1);
        printEncodings(ros1 , ans+ (char)(Integer.parseInt(ch)-1 + 'a'));


        if(str.length() >= 2) {
            String ch2 = str.substring(0, 2);
            String ros2 = str.substring(2);
            if (Integer.parseInt(ch2) <= 26)
                printEncodings(ros2, ans + (char) (Integer.parseInt(ch2) - 1 + 'a'));
        }



    }

}
