package LeetCode;
/*
https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FIndDuplicate {
    public static void main(String[] args){
        int[] n = {3,2,5,4,1,2};
    }
    public int findDuplicate(int[] nums) {

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
}
