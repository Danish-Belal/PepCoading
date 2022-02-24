package DynamicProgramming;

import java.util.Scanner;

/*
1. You are given a string str of digits. (will never start with a 0)
2. You are required to encode the str as per following rules
    1 -> a
    2 -> b
    3 -> c
    ..
    25 -> y
    26 -> z

3. You are required to calculate and print the count of encodings for the string str.

     For 123 -> there are 3 encodings. abc, aw, lc
     For 993 -> there is 1 encoding. iic
     For 013 -> This is an invalid input. A string starting with 0 will not be passed.
     For 103 -> there is 1 encoding. jc
     For 303 -> there are 0 encodings. But such a string maybe passed. In this case

     print 0.

Example
Sample Input
123

Sample Output
3
 */
public class CountEncodings {


    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String s= in.nextLine();
       // System.out.println(countEncodings(s , 0));
        System.out.println(countENcodintTab(s ));

    }

    private static int countEncodings(String s , int idx) {

        if(idx == s.length()) return 1;

        if(s.charAt(idx) == '0') return 0;

       int f1 = countEncodings(s , idx+1);
       int f2 = 0 ;
       if(idx+1 <s.length() && Integer.parseInt(s.substring(idx , idx+2)) <=26){
           f2 = countEncodings(s , idx+2);
       }
       return (f1+f2);
    }

    private static int countENcodintTab(String s){
        int[] dp = new int[s.length()+1];
        dp[0] = dp[1] = 1;

        for(int i = 2 ; i<dp.length ; i++){
          int pc = s.charAt(i-2) - '0';
          int cc = s.charAt(i-1) - '0';

          if(pc == 0 && cc == 0){
              dp[i] = 0;
          }else if(pc == 0){
                dp[i] = dp[i-1];
          }else if(cc == 0){
              if((pc*10+cc) <=26)
                  dp[i] = dp[i-2];

          }else{
              dp[i] = dp[i-1];
              if(pc*10+cc <=26)
                  dp[i] += dp[i-2];
          }
        }
        return dp[dp.length-1];
    }

}
