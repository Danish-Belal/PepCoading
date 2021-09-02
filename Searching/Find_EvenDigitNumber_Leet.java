package Searching;

public class Find_EvenDigitNumber_Leet {
    public static void main(String[] args) {
        int[] num = {12,345,21,6,7896};
       int ans = findNumbers(num);
        System.out.println(ans);

        System.out.println(findDigit(1234334));

    }
    static int findNumbers(int[] nums) {

        int ans = 0 ;
        for(int i = 0 ; i<nums.length ; i++){
            int sz = 0;
            int num = nums[i];

//            if(num <0){
//                num = num* -1;
//            }
//
//            while(num>0){
//                num /=10;
//                sz++;
//
//            }

           sz= findDigit(num);
            if(sz%2 == 0){
                ans++;
            }
        }
        return ans;

    }

    // ShortCut method to find digit of a number.
    static int findDigit(int num){
        if(num <0){
            num *=-1;
        }
        return (int)(Math.log10(num))+1;
    }
}
