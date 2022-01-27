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
5. You are required to print all elements of a2 which are also present in a1 (in order of their occurence in a2).
 Make sure to not print duplicates (a2 may have same value present many times).
 Constraints

1 <= n1, n2 <= 100
0 <= a1[i], a2[i] < 10
Time complexity should be O(n)

Sample Input

9
5
5
9
8
5
5
8
0
3
18
9
7
1
0
3
6
5
9
1
1
8
0
2
4
2
9
1
5
 */
public class Get_Common_Elements_1 {

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner scn = new Scanner(System.in);
        int a1 = scn.nextInt();
        int[] arr1  = new int[a1];
        for(int i = 0 ; i< a1 ; i++){
            arr1[i] = scn.nextInt();
        }
        int a2 = scn.nextInt();
        int[] arr2  = new int[a2];
        for(int i = 0 ; i< a2 ; i++){
            arr2[i] = scn.nextInt();
        }

//        HashMap<Integer, Integer> mp = new HashMap<>();
//
//        for(int i = 0 ;i < a1 ; i++){
//            mp.put(arr1[i] , -1);
//        }
//
//        for(int i = 0 ; i<a2 ; i++){
//           int val = mp.getOrDefault(arr2[i] , 0);
//           if(val == -1){
//               System.out.println(arr2[i]);
//               mp.put(arr2[i] , 0);
//           }
//        }
       // System.out.println(mp);

        // Another Method using set.
        Set<Integer> S = new HashSet<>();
        for( int i : arr1){
            S.add(i);
        }

        for(int i : arr2){
            if(S.contains(i)){
                System.out.println(i);
                S.remove(i);
            }
        }
    }
}
