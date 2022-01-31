package HashMap_Heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. The array is nearly sorted. Every element is at-max displaced k spots left or right to it's position in the sorted array.
    Hence it is being called k-sorted array.
4. You are required to sort and print the sorted array.
 */
public class Sort_K_Sorted_Array {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        // write your code here

        PriorityQueue<Integer> Q = new PriorityQueue<>();

        for(int i = 0 ; i<=k ; i++){
            Q.add(arr[i]);
        }
        for(int i = k+1 ; i<arr.length ; i++){
            System.out.println(Q.poll());
            Q.add(arr[i]);
        }

        while(Q.size() > 0){
            System.out.println(Q.poll());
        }
    }

}
