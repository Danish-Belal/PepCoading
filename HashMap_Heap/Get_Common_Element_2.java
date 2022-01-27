package HashMap_Heap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
1. You are given a number n1, representing the size of array a1.
2. You are given n1 numbers, representing elements of array a1.
3. You are given a number n2, representing the size of array a2.
4. You are given n2 numbers, representing elements of array a2.
5. You are required to find the intersection of a1 and a2. To get an idea check the example below:

if a1 -> 1 1 2 2 2 3 5
and a2 -> 1 1 1 2 2 4 5
intersection is -> 1 1 2 2 5

 */
public class Get_Common_Element_2 {
    public static void main(String[] agrs) {

        Scanner scn = new Scanner(System.in);
        int a1 = scn.nextInt();
        int[] arr1 = new int[a1];
        for (int i = 0; i < a1; i++) {
            arr1[i] = scn.nextInt();
        }
        int a2 = scn.nextInt();
        int[] arr2 = new int[a2];
        for (int i = 0; i < a2; i++) {
            arr2[i] = scn.nextInt();
        }

        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i = 0 ;i < a1 ; i++){
            mp.put(arr1[i] , mp.getOrDefault(arr1[i] , 0)+1);
        }

        for(int i = 0 ; i<a2 ; i++){
//            int val = mp.getOrDefault(arr2[i] , 0);
//            if(val != 0){
//                System.out.println(arr2[i]);
//                mp.put(arr2[i] , val-1);
//            }

            if(mp.containsKey(arr2[i])){
                System.out.println(arr2[i]);
                mp.put(arr2[i],mp.get(arr2[i])-1);
                if(mp.get(arr2[i]) ==0){
                    mp.remove(arr2[i]);
                }

            }
        }

    }
}
