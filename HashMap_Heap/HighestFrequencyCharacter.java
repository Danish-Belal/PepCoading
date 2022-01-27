package HashMap_Heap;

import java.util.HashMap;

/*

1. You are given a string str.
2. You are required to find the character with maximum frequency.

Constraints
0 < str.length() <= 100
There will be a single character with highest frequency

Sample Input

zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc

 */
public class HighestFrequencyCharacter {
    public static void main(String[] args) throws Exception {
        // write your code here
        String s = "zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitcccc";

        HashMap<Character , Integer> mp = new HashMap<>();

        int maxfre = 0;
        char maxfrech = s.charAt(0);

        mp.put(s.charAt(0) , 1);
        for(int i = 1 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            mp.put( ch , mp.getOrDefault(ch , 0)+1);
            if(mp.get(ch) > maxfre){
                maxfre = mp.get(ch);
                maxfrech = ch;
            }
        }
        System.out.println(maxfrech);

    }
}
