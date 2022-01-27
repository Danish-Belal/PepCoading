package LeetCode;

public class RemoveError {

    public static int remove(int[] nums){
        int i = 0 ;
        int j = nums.length-1;
        int error = 0;
        while(i<=j){

            while((i+1 < nums.length-1  && nums[i] < nums[i+1])){
                i++;
            }
            while(j-1 > 0 && nums[j]<nums[j-1]){
                j--;
            }

            error = j-i;
        }

        return error;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,1};
        System.out.println(remove(arr));

    }
}
