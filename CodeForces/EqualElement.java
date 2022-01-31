package CodeForces;

import java.util.Scanner;

public class EqualElement {

    public static int check(int[] nums){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i<nums.length ; i++){
            max = Math.max(max , nums[i]);
            min = Math.min(min , nums[i]);
        }
        return max-min;

    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t != 0 ){
            int n = scn.nextInt();
            int[] arr = new int[n];

            for(int i = 0 ; i<n ; i++){
                arr[i] = scn.nextInt();
            }

            int ans = check(arr);
            System.out.println(ans);
            t--;

        }

    }
}
