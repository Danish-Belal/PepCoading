package GoldManShahs;

import java.util.Arrays;

public class MinOperation {
    public static void main(String[] args){

        int[] arr = {3,-1,8,-2,-3};
        int b = 1;

        Arrays.sort(arr);

        int ct = 0;

        int i = 0 ;
        int j = arr.length-1;

        while(i < j){

            int val =  arr[i] < 0 ? 1+arr[i] : 1-arr[i];

            arr[i] = arr[i]+val;
            arr[j] = arr[j]-val;

            ct++;
            i++;

            if(arr[j] == b){
                j--;
            }

        }
        System.out.println(ct);

    }
}
