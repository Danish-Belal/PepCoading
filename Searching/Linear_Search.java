package Searching;
/*
Linear Search is a searching algo in which we check for each element from starting to end of an array.
Time Complexity
    for best case if  element present at index 0. -- > 0(1).
    if Element is not present in that array -- >0(n).

 */
public class Linear_Search {
    public static void main(String[] args) {
        int[] arr = {10, 3,4,5,2};
        int target = 100;
        System.out.println(linearSearch(arr , target));
    }
    static int linearSearch(int[] arr , int target){
//        if(arr.length == 0){
//            return  -1;
//        }

        for(int i= 0 ; i<arr.length ; i++){
            int element  = arr[i];
            if(element == target){
                return i;
            }
        }
        return -1;
    }

    // If you are given a range to search between them.
    // run the loop from starting to  end.

}
