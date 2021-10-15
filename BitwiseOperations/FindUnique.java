package BitwiseOperations;
/*
Given an array find unique Element.
 */
public class FindUnique {

    public static void main(String[] args) {
        int[] arr = {2,3,3,4,2,6,4 ,6,7};
        System.out.println(Unique(arr));


        // Sorted Array,
        int nums[] = {1,1,2,3,3,4,4};
        System.out.println(uniquesorted(nums));

    }
    public static int Unique(int[] arr){
        int unique = 0;
        for(int n : arr){
            unique ^=n;
        }
        return  unique;
    }

    // If array is sorted.
    public static int uniquesorted(int[] nums){
        int xor = nums[0];
        for(int i=1 ; i< nums.length ; i++){
            xor ^=nums[i];
        }

       return xor;
    }
}
