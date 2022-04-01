package LeetCode;

public class Reversestring {

public static void main(String[] args){
    char[] c = {'h', 'e','l','l','o'};
    reverseString(c);
    for(char ch : c)
        System.out.print(ch+" ");



    }
    public static void reverseString(char[] s) {

        int i = 0  ;
        int j = s.length-1;

        while(i<j){
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
            i++;
            j--;
        }
    }
}
