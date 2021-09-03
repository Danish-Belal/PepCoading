package InterviewQ_BS;
/*
Given a characters array letters that is sorted in non-decreasing order and a character target,
return the smallest character in the array that is larger than target.

Note that the letters wrap around.

For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
Example 1:

Input: letters = ["c","f","j"], target = "a"
Output: "c"
Example 2:

Input: letters = ["c","f","j"], target = "c"
Output: "f"
 */
class SmallestLatterGTarget {

    public static void main(String[] args) {
        char[]  letters = {'c' ,'f','j'};
       char  target = 'j';
       char ans = nextGreatestLetter(letters , target);
        System.out.println(ans);

    }


    public static char nextGreatestLetter(char[] letters, char target) {
        int lo = 0 ;
        int hi = letters.length-1;


        while(lo <= hi)    {
            int  mid = lo + (hi-lo) / 2;
            if (target > letters[mid]) {
                lo = mid+1;
            } else  {
                hi = mid - 1;
            }

        }
        return letters[lo%letters.length];

    }

}
