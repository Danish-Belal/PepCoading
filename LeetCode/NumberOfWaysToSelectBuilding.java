package LeetCode;
/*
https://leetcode.com/problems/number-of-ways-to-select-buildings/
You are given a 0-indexed binary string s which represents the types of buildings along a street where:

s[i] = '0' denotes that the ith building is an office and
s[i] = '1' denotes that the ith building is a restaurant.
As a city official, you would like to select 3 buildings for random inspection. However,
to ensure variety, no two consecutive buildings out of the selected buildings can be of the same type.

For example, given s = "001101", we cannot select the 1st, 3rd,
 and 5th buildings as that would form "011" which is not allowed due to having two consecutive buildings of the same type.
Return the number of valid ways to select 3 buildings.
 */
public class NumberOfWaysToSelectBuilding {
    public static void main(String[] args){
        System.out.println(numberOfWays("001101"));
    }
    public static long numberOfWays(String s) {

        int[] preZero = new int[s.length()];
        int[] preOne = new int[s.length()];

        for(int i = 0 ; i<s.length() ; i++){

            if(i ==0 ){
                preZero[0] = s.charAt(i) == '0' ? 1 : 0;
                preOne[0] = s.charAt(i) == '1' ? 1 : 0;
                continue;
            }
            preZero[i] = preZero[i-1]+(s.charAt(i) == '0' ? 1:0);
            preOne[i] = preOne[i-1]+(s.charAt(i) == '1' ? 1 : 0);
        }

        long ans = 0 ;

        for(int i = 1 ; i<s.length()-1 ; i++){
            if(s.charAt(i) == '1'){
                long x = preZero[i-1];
                long y = preZero[s.length()-1]-preZero[i];
                ans += (x*y);
            }else{
                long x = preOne[i-1];
                long y = preOne[s.length()-1]-preOne[i];
                ans += (x*y);


            }
        }
        return ans;

    }
}
