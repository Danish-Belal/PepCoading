package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.
 */
public class PartitionLabels {
    
    public static void main(String[] args){
        String s = "ababcbacadefegdehijhklij" ;
       System.out.println( partitionLabels(s));   

    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character , Integer> mp = new HashMap<>();

        for(int i = 0 ;  i<s.length() ; i++){
            char c = s.charAt(i);
            mp.put(c , i);
        }

        int pre = -1 ;
        int max = 0 ;

        for(int i = 0 ; i<s.length() ; i++){
            char c = s.charAt(i);
            if(mp.get(c) > max){
                max = mp.get(c);
            }

            if(i == max){
                ans.add(max - pre);
                pre = max;
            }

        }
        return ans;
    }
}
