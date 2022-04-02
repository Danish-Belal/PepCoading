package LeetCode;

public class MinBitFlipToConvert {
    public static void main(String[] args){
        System.out.println(minBitFlips(10,7));
    }
    public static int minBitFlips(int start, int goal) {

        int target = start^goal;
        //   System.out.println(Integer.toBinaryString(target));
        return Integer.bitCount(target);    // Use to Count no of 1's in bits .




    }
}
