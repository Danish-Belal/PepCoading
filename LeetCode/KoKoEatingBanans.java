package LeetCode;
/*
https://leetcode.com/problems/koko-eating-bananas/
Koko loves to eat bananas. There are n piles of bananas,
the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k.
 Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas,
  she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.



Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
 */
public class KoKoEatingBanans {
    public static boolean isPossible(int[] piles , int sp , int h){
        int time = 0;
        for(int i =0 ; i<piles.length ; i++){
            time += (int)Math.ceil(piles[i]*1.0/sp);
        }
        return time <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int max = Integer.MIN_VALUE;

        for(int i : piles){
            max = Math.max(i , max);
        }

        if(h ==  piles.length){
            return max;
        }

        int lo= 0;
        int hi = max;
        int speed= Integer.MAX_VALUE;

        while( lo <= hi){
            int sp = lo +(hi-lo)/2;

            if(isPossible(piles , sp , h)){
                speed = sp;
                hi = sp-1;
            }else{
                lo = sp+1;
            }
        }
        return speed;
    }

}
