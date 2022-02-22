package LeetCode;

/*
https://leetcode.com/problems/excel-sheet-column-number/

Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...

Example 1:
Input: columnTitle = "A"
Output: 1

Example 2:
Input: columnTitle = "AB"
Output: 28

Example 3:
Input: columnTitle = "ZY"
Output: 701


Constraints:

1 <= columnTitle.length <= 7
columnTitle consists only of uppercase English letters.
columnTitle is in the range ["A", "FXSHRXW"].
 */
public class ExcelSheetColnNumber {

    public static int titleToNumber(String s) {
        if(s.length() == 1) return (s.charAt(0)-'A'+1 );


     int no = 0;
     for(int i = 0 ; i<s.length() ; i++){
         char ch = s.charAt(i);
         no = no*26+ch-'A'+1;
     }

        return no;
    }
    public static void main(String[] a){
        String s = "FXSHRXW";
        System.out.println(titleToNumber(s));
    }
}
