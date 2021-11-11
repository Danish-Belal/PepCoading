package SelfCode;

import java.util.Arrays;
import java.util.Stack;

public class NGE {
    public  static  int[] nge(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

       st.push(0);
       for(int i = 1 ; i<arr.length ; i++){
           while(st.size() > 0 && arr[st.peek()] < arr[i]){
               ans[st.pop()] = arr[i];
           }
           st.push(i);
       }
       while (st.size() !=0){
           ans[st.pop()] = -1;

       }

       return ans;
    }
    public static void main(String[] args) {
        int [] arr = {5,3,8,-2,7};
        int[] ans = nge(arr);
        System.out.println(Arrays.toString(ans));

    }
}
