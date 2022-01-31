package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

  static  PriorityQueue<Integer> left = new PriorityQueue(Collections.reverseOrder());;
  static  PriorityQueue<Integer> right = new PriorityQueue();


     private static void insertInQueue(int n){
         if(left.isEmpty()){
             left.add(n);
         }else{
             if(left.size() > right.size()){
                 if(left.peek() < n){
                     right.add(n);
                 }else{
                     right.add(left.poll());
                     left.add(n);
                 }
             }else{
                 if(left.size() <= n){
                     right.add(n);
                     left.add(right.poll());
                 }else{
                     left.add(n);
                 }
             }
         }
     }

     private static void removeFromQueue(int n){
         if(n <= left.peek()){
             if(left.peek() > right.peek()){
                 left.remove(n);
             }else{
                 left.remove(n);
                 left.add(right.poll());
             }
         }else{
             if(left.size() > right.size()){
                 right.remove(n);
                 right.add(left.poll());
             }else{
                 right.remove(n);
             }
         }

     }

    private static double findMedian() {
        if(left.size()>right.size()) {
            return left.peek();
        }
        long sum = (long)left.peek() + (long)right.peek();
        return ((sum)/2.0);

    }

  public static double[] medianSlidingWindow(int[] nums, int k) {

        double[] ans = new double[nums.length-k+1];
        for(int i = 0 ; i<nums.length ; i++){
            if(i >= k ){
                ans[i-k] = findMedian();
                removeFromQueue(nums[i-k]);
            }
            if(i<nums.length){
                insertInQueue(nums[i]);
            }
        }
        System.out.println(left);
        System.out.println(right);
        ans[nums.length-k] = findMedian();
        return ans;
    }



    public static void main(String[] args){
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        double[] ans = medianSlidingWindow(arr , k);
        System.out.println(Arrays.toString(ans));
        System.out.println(left);
        System.out.println(right);

    }
}
