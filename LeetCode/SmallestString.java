package LeetCode;

public class SmallestString {
    public static void main(String[] args){
        System.out.println(getSmallestString(5,73));
    }
    public static String getSmallestString(int n, int k) {

        char[] ans = new char[n];
        for(int i = n-1 ; i>=0 ; i--){
            int val = Math.min(26 , k-i);
            ans[i] = (char)('a'+val-1);
            k = k-val;
        }
        return new String(ans);
    }
}
