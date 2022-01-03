package LeetCode;
/*
https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
You are given a list of songs where the ith song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
    Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.



Example 1:

Input: time = [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
 */
public class PairsDivisibleBy60 {

    public static int numPairsDivisibleBy60(int[] times) {
        int count = 0;

        for(int i= 0 ; i<times.length-1 ; i++){
            for(int j  = i+1 ; j<times.length ; j++){
                if((times[i] + times[j])%60 == 0 ){
                    count++;
                }
            }
        }
        return count;

    }

    public static int numPair2(int[] times){
        int[] arr = new int[60];
        for(int ele : times){
            arr[ele%60]+=1;
        }
        int count = 0;
        count += ((arr[0]-1)*arr[0])/2;  // for 0 or 60 value.
        count += ((arr[30]-1)*arr[30])/2;   // For 30 value.
        for(int i = 1 ; i<=29 ; i++){
            count += arr[i]*arr[60-i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {30,20,150,100,40};
        System.out.println(numPairsDivisibleBy60(arr));

    }

}
