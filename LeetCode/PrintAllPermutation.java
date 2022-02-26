package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintAllPermutation {
    public static void main(String[] args){
        int[] arr = {1,2,3};
        List<List<Integer>> ans = new ArrayList<>();
//        ArrayList<Integer> curr = new ArrayList<>();
//
//        boolean[] visited = new boolean[arr.length];
//        permutations(arr ,  visited , ans , curr);
//        System.out.println(ans);

//        Map<Integer , Integer> mp = new HashMap<>();
//        permutations(arr ,  mp , ans );

        // without using many spaces.
        permutations(arr , 0 , ans);
       System.out.println(ans);

    }

    private static void permutations(int[] arr,  boolean[] visited, List<List<Integer>> ans, ArrayList<Integer> curr) {

        if(curr.size() == arr.length){
            ans.add(new ArrayList<>(curr));
            return ;
        }

        for(int i = 0 ; i<arr.length ; i++){

            if(visited[i]) continue;
            curr.add(arr[i]);
            visited[i] = true;
            permutations(arr , visited , ans , curr);
            visited[i] = false;
            curr.remove(curr.size()-1);

        }
    }



    // Not working good.
    private static void permutations(int[] arr,  Map<Integer , Integer> mp, List<List<Integer>> ans) {

        if(mp.size() == arr.length){
            ArrayList<Integer> curr = new ArrayList<>();
           for(Map.Entry<Integer , Integer> e : mp.entrySet()){
               curr.add(e.getKey());
           }
           ans.add(new ArrayList<>(curr));
            return ;
        }

        for(int i = 0 ; i<arr.length ; i++){

            if(mp.getOrDefault(arr[i] , 0) == 0) {
                mp.put(arr[i], 1);
                permutations(arr, mp, ans);
                mp.remove(arr[i]);
            }

        }
    }

    static void permutations(int[] arr , int idx , List<List<Integer>> ans){

        if(idx == arr.length){
            ArrayList<Integer> curr = new ArrayList<>();
            for(int i : arr){
                curr.add(i);
            }
            ans.add(curr);
            return;
        }

        for(int i = idx ; i<arr.length ; i++){
            swap(arr , i , idx);
            permutations(arr  , idx+1 , ans);
            swap(arr , idx , i);

        }
    }
    static void swap(int[] arr , int i , int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

