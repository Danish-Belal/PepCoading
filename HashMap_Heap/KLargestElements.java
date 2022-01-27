package HashMap_Heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are given a number k.
4. You are required to find and print the k largest elements of array in increasing order.

Constraints

1 <= n <= 30
0 <= n1, n2, .. n elements <= 100
0 < k <= n

Sample Input

13
12
62
22
15
37
99
11
37
98
67
31
84
99
4
 */
public class KLargestElements {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        // write your code here

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : arr){
            pq.offer(i);
        }

        for(int i = 0 ; i<arr.length-k ; i++){
            pq.poll();
        }
        while(pq.size() != 0){
            System.out.println(pq.poll());
        }



    }
}
