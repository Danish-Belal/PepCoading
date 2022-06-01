package ArraysAndString2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayReverse {


    public static void main(String[] args){
        Integer[] arr = {1,2,3,4};
        Collections.reverse(Arrays.asList(arr));
        System.out.println(Arrays.toString(arr));
    }
}
