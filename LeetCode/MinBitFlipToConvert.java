package LeetCode;

public class MinBitFlipToConvert {
    public int minBitFlips(int start, int goal) {

        int target = start^goal;


        //   System.out.println(Integer.toBinaryString(target));
        return Integer.bitCount(target);




    }
}
