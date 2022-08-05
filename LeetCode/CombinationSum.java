package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
https://leetcode.com/problems/combination-sum/
Given an array of distinct integers candidates and a target integer target,
 return a list of all unique combinations of candidates where the chosen numbers sum to target.
  You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times.
 Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
 */
public class CombinationSum {
    public  static List<List<Integer>> combinationSum(int[] cands, int t) {
        Arrays.sort(cands); // sort candidates to try them in asc order
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 1; i <= t; i++) { // run through all targets from 1 to t
            List<List<Integer>> newList = new ArrayList(); // combs for curr i
            // run through all candidates <= i
            for (int j = 0; j < cands.length && cands[j] <= i; j++) {
                // special case when curr target is equal to curr candidate
                if (i == cands[j]) newList.add(Arrays.asList(cands[j]));
                    // if current candidate is less than the target use prev results
                else for (List<Integer> l : dp.get(i-cands[j]-1)) {
                    if (cands[j] <= l.get(0)) {
                        List cl = new ArrayList<>();
                        cl.add(cands[j]); cl.addAll(l);
                        newList.add(cl);
                    }
                }
            }
            dp.add(newList);
        }
        return dp.get(t-1);

    }


    static void combinationSum(int[] arr ,int idx ,  int t , List<List<Integer>> ans , List<Integer> curr){
        if(idx == arr.length){
            if( t == 0){
                ans.add(new ArrayList<>(curr));
            }
            return ;
        }
        if(arr[idx] <= t){
            curr.add(arr[idx]);
            combinationSum(arr , idx , t-arr[idx] , ans , curr);
            curr.remove(curr.size()-1);
        }
        combinationSum(arr , idx+1 , t , ans, curr);
    }

    public static void main(String[] args){
        int[] arr = {2,3,4,6,7};
        int t = 7;

       // List<List<Integer>> l  = combinationSum(arr , t);

        // For recursion.
        List<List<Integer>> ans = new ArrayList<>();
        combinationSum(arr , 0 ,  t , ans , new ArrayList<>());
        System.out.println(ans);

    }
}
