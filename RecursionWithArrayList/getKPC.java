/*
1. You are given a string str. The string str will contains numbers only,
 where each number stands for a key pressed on a mobile phone.
2. The following list is the key to characters map :
    0 -> .;
    1 -> abc
    2 -> def
    3 -> ghi
    4 -> jkl
    5 -> mno
    6 -> pqrs
    7 -> tu
    8 -> vwx
    9 -> yz
3. Complete the body of getKPC function - without changing signature -
 to get the list of all words that could be produced by the keys in str.
Use sample input and output to take idea about output.

Constraints

0 <= str.length <= 10
str contains numbers only

Sample Input

78

Sample Output

[tv, tw, tx, uv, uw, ux]


*/

package RecursionWithArrayList;
//import java.lang.reflect.Array;
import  java.util.*;

public class getKPC {

    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(getKPC(s));

    }
    static String[] codes = {".;" , "abc" , "def" , "ghi", "jkl","mno","pqrs", "tu","vwx","yz"};

    public static ArrayList<String> getKPC(String str) {
        if(str.length()==0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char c = str.charAt(0);
        String ros = str.substring(1);


        ArrayList<String> rr = getKPC(ros);
        ArrayList<String> mr = new ArrayList<>();
        String code = codes[c-'0'];

        for(int i = 0; i <code.length() ; i++){
            char ch = code.charAt(i);

            for (String s : rr) {
                mr.add(ch + s);
            }
        }

     return mr;

    }

}
