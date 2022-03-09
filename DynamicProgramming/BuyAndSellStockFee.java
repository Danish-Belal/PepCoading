package DynamicProgramming;

import java.util.Scanner;

/*
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are give a number fee, representing the transaction fee for every transaction.
4. You are required to print the maximum profit you can make if you are allowed infinite transactions,
 but has to pay "fee" for every closed transaction.
Note - There can be no overlapping transaction.
 One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).

 Sample Input

12
10
15
17
20
16
18
22
20
22
20
23
25
3

Sample Output

13
 */
public class BuyAndSellStockFee {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i<n ; i++){
            arr[i] = scn.nextInt();
        }

        // Pay fee.
       // int tf = scn.nextInt();
       // System.out.println(pwithFee(arr , tf));

        // Cool Down
        System.out.println(coolDown(arr));


    }

    private static int pwithFee(int[] arr , int tf) {

        int[] buy = new int[arr.length];
        int[] sell = new int[arr.length];

        buy[0] = -arr[0];
        sell[0] = 0;

        for(int i = 1 ; i<arr.length ; i++){
            sell[i]  = Math.max(sell[i-1] , buy[i-1]+arr[i] - tf);
            buy[i] = Math.max(buy[i-1] , sell[i-1]-arr[i]);
        }
        return sell[sell.length-1];
    }

    // buy and sell cooldown (if you made transaction today you can not buy tomorrow , you have to wait for day after tomorrow.
    static int coolDown(int[] arr){

        int[] buy = new int[arr.length];
        int[] sell = new int[arr.length];

        buy[0] = -arr[0];
        sell[0] = 0;

        for(int i = 1 ; i<arr.length ; i++){
            sell[i]  = Math.max(sell[i-1] , buy[i-1]+arr[i] );
            buy[i] = Math.max(buy[i-1] , (i-2 >=0 ? sell[i-2] : 0 )-arr[i]);
        }
        return sell[sell.length-1];


    }

}
