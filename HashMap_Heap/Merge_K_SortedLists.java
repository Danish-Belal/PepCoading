package HashMap_Heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

/*
1. You are given a list of lists, where each list is sorted.
2. You are required to complete the body of mergeKSortedLists function.
    The function is expected to merge k sorted lists to create one sorted list.

    Sample Input

4
5
10 20 30 40 50
7
5 7 9 11 19 55 57
3
1 2 3
2
32 39

Sample Output

1 2 3 5 7 9 10 11 19 20 30 32 39 40 50 55 57
 */
public class Merge_K_SortedLists {
    public static class pair implements Comparable<pair>{
        int val;
        int di;
        int  li;
        pair(int val , int li , int di){
            this.val = val;
            this.di = di;
            this.li = li;
        }
       public int compareTo(pair o1){

            return this.val-o1.val;
        }
    }
    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<pair> Q = new PriorityQueue<>();

       for(int i = 0 ; i<lists.size() ; i++){
           ArrayList<Integer> list = lists.get(i);
           Q.add(new pair(list.get(0) , i , 0));
       }
       
       while(Q.size() > 0){
           pair rp = Q.poll();
           ans.add(rp.val);
           if(rp.di+1 < lists.get(rp.li).size()){
               Q.add(new pair(lists.get(rp.li).get(rp.di+1) , rp.li , rp.di+1));
           }
       }
       return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < k; i++){
            ArrayList<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                list.add(Integer.parseInt(elements[j]));
            }
            lists.add(list);
        }

        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for(int val: mlist){
            System.out.print(val + " ");
        }
        System.out.println();
    }


}
