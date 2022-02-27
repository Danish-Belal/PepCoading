package LeetCode;

public class MinNoAnagram {
    public static void main(String[] args){
        String s = "leetcode" , t = "coats";
        System.out.println(minSteps(s,t));

    }

    public static  int minSteps(String s, String t) {

        int[] hash = new int[26];

      //  System.out.println(--hash[0]);

        for(int i = 0 ; i<s.length() ; i++){
            hash[s.charAt(i)-'a']++;
        }


        int ct = 0;

        for(int i = 0 ; i < t.length() ; i++){
            --hash[t.charAt(i)-'a'];
        }

        for(int  i : hash){
           ct += Math.abs(i);
        }

       return ct;
    }
}
