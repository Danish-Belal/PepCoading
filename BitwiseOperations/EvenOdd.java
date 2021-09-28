package BitwiseOperations;
/*
You are given a num , find its even or odd.
 */
public class EvenOdd {
    public static void Binary(int n) {
       if((n & 1) == 1){
           System.out.println("Odd");
       }else
           System.out.println("Even");

    }

    public static boolean isOdd(int n){
        return (n&1)==1;
    }
    public static void main(String[] args) {
        Binary(11);
        System.out.println(isOdd(11));

    }
}
