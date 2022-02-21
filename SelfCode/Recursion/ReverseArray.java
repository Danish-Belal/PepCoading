package SelfCode.Recursion;

public class ReverseArray {
    public static void swap1(int[] arr , int i){

        int t = arr[i];
        arr[i] = arr[arr.length-i-1];
        arr[arr.length-i-1] = t;

    }
    public static void swap(int[] arr , int i){

        if(i >= arr.length/2) return ;
         swap1(arr , i);
        swap(arr , i+1);
    }
    public static void main(String[] args){
        int[] arr  ={1,2,3,4,50};
        swap(arr , 0 );
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}
