package BitwiseOperations;

public class SetgetBit {
    public static int SetBit(int n , int pos){
        int i = 1<<pos;
        return n|i;

    }
    public static int GetBit(int n , int pos){
        // set 1 by sift operator at given position.
        int i = 1<<pos;
        // Perform & between number and sift1
        int andopr = n & i;
        // If number is not 0 then given bit is 1.
        if(andopr != 0) return 1;
        return 0;


    }

    public static void main(String[] args) {
        int bitpos = GetBit(5,3);
     //   System.out.println(bitpos);

        int setbit = SetBit(5 , 3);
        System.out.println(setbit);
    }
}
