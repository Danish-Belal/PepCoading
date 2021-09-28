package BitwiseOperations;

public class MagicNumber {
    public static void main(String[] args) {
        int n = 6;

        int ans = 0;
        int base  =5 ;
        while( n > 0){
            int lastDigit =  n &1;
            ans += base*lastDigit;
            n = n>>1;
            base *= 5;
        }
        System.out.println(ans);
    }
}
