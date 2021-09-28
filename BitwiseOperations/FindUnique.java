package BitwiseOperations;
/*
Given an array find unique Element.
 */
public class FindUnique {

    public static void main(String[] args) {
        int[] arr = {2,3,3,4,2,6,4 ,6,7};
        System.out.println(Unique(arr));

    }
    public static int Unique(int[] arr){
        int unique = 0;
        for(int n : arr){
            unique ^=n;
        }
        return  unique;
    }
}
