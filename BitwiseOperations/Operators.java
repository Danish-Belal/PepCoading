package BitwiseOperations;

public class Operators {
    public static void main(String[] args) {
        int a  = 12;
        int b = 10;

        // & (AND) Operator.
        System.out.println(a&b);
        // | (OR) Operator
        System.out.println(a|b);
        // ~(NOT) Operator
        System.out.println(~a);
        System.out.println(~b);
        System.out.println(~7);

        // XOR(^) Operator.  give 1 if both operand are opposite
        System.out.println(a^b);


        // Left sift Operator.
        // <<1 means multiplication with 2^1 , <<2 means multiplication with 2 power 2.
        System.out.println(a<<1);
        System.out.println(b<<2);

        // Right sift operator.
        // >>1 means it divide with 2^1. >>2 means divide operand with 2^^2.
        System.out.println(a>>1);
        System.out.println(b>>2);
    }

}
