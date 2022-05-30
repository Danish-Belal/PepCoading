package ArraysAndString2;

/*
https://leetcode.com/problems/reverse-vowels-of-a-string/
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.

Example 1:

Input: s = "hello"
Output: "holle"
 */
public class RemoveVowelFromString {
    public static void main(String[] args){

    }
    boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ){
            return true;
        }else if( ch == 'A' || ch == 'E'|| ch == 'I' || ch == 'O' || ch == 'U'){
            return true;
        }
        else
            return false;
    }
    public String reverseVowels(String s) {

        char[] arr = s.toCharArray();

        int i = 0  , j = arr.length-1;

        while(i < j){
            while( i < j &&isVowel(arr[i]) == false) i++;

            while(i < j && isVowel(arr[j]) == false) j--;

            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return String.valueOf(arr);

    }
}
