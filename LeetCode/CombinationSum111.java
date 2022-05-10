package LeetCode;

import java.util.ArrayList;
import java.util.List;
/*
https://leetcode.com/problems/combination-sum-iii/
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations.
The list must not contain the same combination twice, and the combinations may be returned in any order.



Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.

 */
public class CombinationSum111 {
    public static void main(String[] args){
        System.out.println(combinationSum3(3,7));
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
      //  if(k > n)  return result;


        combi( k , n , 1  , new ArrayList<>() ,  result);
        return result;
    }
    private static void combi(int k , int n , int start  ,ArrayList<Integer> temp , List<List<Integer>> result){

        if(k < 0 || n < 0) return;
        if( k == 0 && n ==0){

            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start ; i <=9 ; i++){
            temp.add(i);
            combi(k-1 , n-i , i+1 , temp , result);
            temp.remove(temp.size()-1);
        }

    }
}
