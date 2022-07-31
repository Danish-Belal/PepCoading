package LeetCode;

/*
https://leetcode.com/problems/range-sum-query-mutable/\

Given an integer array nums, handle multiple queries of the following types:

Update the value of an element in nums.
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
void update(int index, int val) Updates the value of nums[index] to be val.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 */
public class RangeSumQuery {
    public static void main(String[] args){

    }
    static int[] array;
    public void NumArray(int[] nums) {
        this.array = nums;
    }

    public void update(int index, int val) {
        array[index] = val;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        while(left <= right){
            sum += array[left++];

        }
        return sum;
    }

}
