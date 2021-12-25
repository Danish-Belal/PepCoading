package SelfCode.Recursion;

public class Problems {

    // Fib
    public static int fib(int n){
//        if(n == 1 || n == 0) return n;
//        return n*fib(n-1);

       return ((n== 1 || n==0) ? n : n*fib(n-1));
    }

    // Sum of Array.
    public static int sum(int[] arr , int s , int idx){
        if(idx == arr.length-1){
            return s;
        }
        s += arr[idx];
        return sum(arr , s , idx+1);
    }

    //



    public static void main(String[] args) {

        System.out.println(fib(5));
        int[] arr = {1,4,6,3,5,1};
        System.out.println(sum(arr , 0 , 0));


    }
}
