package InterviewQ_CyclicSort;

import java.util.Arrays;

/*
https://leetcode.com/problems/find-the-duplicate-number/submissions/
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3
 */
public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[]nums = {3, 1 ,2 ,5 ,3};
//        int ans = findDuplicate(nums);
//        System.out.println(ans);

        int[] ans = findDuplicate3(nums);
        System.out.println(Arrays.toString(ans));

    }

    public static int findDuplicate(int[] nums) {
        int i = 0 ;
         while(i < nums.length){

             if(nums[i] != i+1){
                int correctidx = nums[i] - 1;
                if (nums[i] != nums[correctidx]) {
                 swap( nums , i , correctidx);
                }else{
                    return nums[i];
             }}else{
                 i++;
             }
         }
//         int ans = 0 ;
//         for(int idx = 0 ; idx<nums.length ; idx++){
//             if(nums[idx] != idx+1){
//                 ans = nums[idx];
//             }
//         }
//     return  ans;
        return -1;
    }

    public static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }


    // Through slow and fast approach.
    public static int findDuplicate2(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];

        }while(slow != fast);

        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;

    }
    // through miss-rep , miss^2-rep^2
    public static int[] findDuplicate3(int[] nums) {

        int n = nums.length ;

        int Sn =( n*(n+1))/2;
        int Ssqr = n*((n+1)*(2*n+1))/6;

        int SsqrNum = 0;
        int Snum = 0;
        for(int i : nums){
            Snum +=i;
            SsqrNum += (i*i);
        }


        int miss_Plus_rep =( Ssqr-SsqrNum)/(Sn-Snum);
        System.out.println(miss_Plus_rep);

        int missNo =( miss_Plus_rep+Sn-Snum )/ 2;


        int repNo = (missNo)-(Sn-Snum);


        return new int[]{repNo,missNo};
    }

}

