package LeetCode;

import java.util.Stack;

public class RemoveDuplicateLetter {
    public static void main(String[] args){
        String s = "bcbacxbd";
        System.out.println(removeDuplicateLetters(s));
    }
    public static String removeDuplicateLetters(String s) {

        Stack<Character> st = new Stack<>();
        int[] fre = new int[26];
        boolean[] exist = new boolean[26];

        for(char c : s.toCharArray()){
            fre[c-'a']++;
        }
        //   System.out.println(Arrays.toString(fre));

        for(char c : s.toCharArray()){
            fre[c-'a']--;
            if(exist[c-'a']) continue;

            while(st.size()>0 && st.peek() > c && fre[st.peek()-'a'] > 0){
                exist[st.pop()-'a'] = false;
            }
            st.push(c);
            exist[c-'a'] = true;
        }

        char[] ans = new char[st.size()];
        int i = st.size()-1;
        while(i >=0) ans[i--] = st.pop();

        return new String(ans);

    }
}
