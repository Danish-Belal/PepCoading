package Stack_Queue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the elements of array a.
3. You are given a number k, representing the size of window.
4. You are required to find and print the maximum element in every window of size k.

e.g.
for the array [2 9 3 8 1 7 12 6 14 4 32 0 7 19 8 12 6] and k = 4, the answer is [9 9 8 12 12 14 14 32 32 32 32 19 19 19]
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {2 ,9, 3, 8, 1, 7, 12, 6 ,14, 4 ,32, 0 ,7 ,19, 8, 12, 6};
        int k = 4;
//        ArrayList<Integer> ans = window1(arr,k);
//        for (int i = 0; i < ans.size(); i++) {
//            System.out.print(ans.get(i) + " ");
//        }

        System.out.println(Arrays.toString(window2(arr,k)));

    }
    public static ArrayList<Integer> window1(int[] arr , int k){
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i<= arr.length-k ; i++){
            int max  =0 ;
            for(int j = i ; j<i+k ; j++){
                if(i+k > arr.length){
                    max = arr[j];
                }else {
                    max = Math.max(max, arr[j]);
                }
            }
            ans.add(max);
        }
        return ans;

    }

    public static int[] window2(int[] arr , int k){
        // Find next greater element.
        int[] ngr = new int[arr.length];

        Stack<Integer> s = new Stack<>();
        for (int i = arr.length-1 ; i>=0 ; i--){
            // Pop smaller ELement.
            while(s.size() > 0 && arr[s.peek()]< arr[i]){
                s.pop();
            }
            //Update ans.
            if(s.size() == 0){
                ngr[i] = arr.length;
            }else{
                ngr[i] = s.peek();
            }

            // Update your ans.
            s.push(i);
        }

        // Now our next greaget element is ready.
        int[] ans = new int[arr.length-k+1];
        for (int i = 0 ,j =0 ; i<= arr.length-k ; i++){
            if(j < i){
                j = i;
            }
            while(ngr[j] < i+k){
                j = ngr[j];
            }
            ans[i] = arr[j];
        }
        return ans;
    }
}
