package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CountSmallestNo {
    public static void main(String[] args){
        int[] num = {-1,-1};
        List<Integer> ans =  countSmaller(num);
        System.out.println(ans);
    }

    public static  List<Integer> countSmaller(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int i = nums.length-1;
       stack.add(nums[i--]);
        ans.add(0);

        while(i >=0){
            if(stack.peek() < nums[i]){
                ans.add(stack.peek());
                stack.add(nums[i]);
            }else{
                while(stack.size() > 0 && stack.peek() > nums[i]){
                    stack.pop();
                }
                if(stack.size() > 0){
                    ans.add(stack.peek());
                    stack.add(nums[i]);
                }else{
                    ans.add(0);
                    stack.add(0);
                }
            }
            i--;
        }

        Collections.reverse(ans);
        return ans ;
    }
}
