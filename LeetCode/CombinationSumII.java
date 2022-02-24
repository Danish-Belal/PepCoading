package LeetCode;

import java.util.*;

/*
Given a collection of candidate numbers (candidates) and a target number (target),
 find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]
 */
public class CombinationSumII {

    // Using through simple recursion call using set , time limit excided.
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> ans = new HashSet<>();
        ArrayList<Integer> curr = new ArrayList<>();
        combi(candidates , 0 , target , ans , curr);

        List<List<Integer>> ans2 = new ArrayList<>(ans);

        return ans2;

    }
    public static void combi(int[] c,int idx, int target , Set<List<Integer>> ans ,  ArrayList<Integer> curr ){

        if(idx == c.length){
            if( target == 0){
               // Collections.sort(curr);
                ans.add(new ArrayList<>(curr));
            }
            return ;
        }

        if(c[idx]<=target) {
            curr.add(c[idx]);
            combi(c, idx + 1, target - c[idx], ans, curr);
            curr.remove(curr.size() - 1);
        }
        combi(c , idx+1 , target , ans , curr);


    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target){

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
      //  System.out.println(Arrays.toString(candidates));
        combination(candidates , 0 , target , ans , new ArrayList<>());
        return ans;


    }

    private static void combination(int[] c, int idx, int t, List<List<Integer>> ans, ArrayList<Integer> curr) {

        if(t == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = idx ; i<c.length ; i++){
            if(i > idx && c[i] == c[i-1]) continue;
            if(c[i] >t) break;

            curr.add(c[i]);
            combination(c , i+1 , t-c[i] , ans , curr);
            curr.remove(curr.size()-1);

        }

    }

    public static void main(String[] args){
        int[] arr = {10,1,2,7,6,1,5};
        int t = 8;

        List<List<Integer>> ans = combinationSum(arr ,t);

        System.out.println(ans);



    }
}
