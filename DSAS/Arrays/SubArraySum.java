package DSAS.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SubArraySum {
    public static void main(String[] args){
        int[] A = {1,2,3,-3,4};
        System.out.println(solve3(A));
    }
    public static int solve(int[] A) {
        int[] subArray = new int[A.length];
        subArray[0] = A[0];
        for(int i =1 ; i<A.length ; i++){
            subArray[i] = subArray[i-1]+A[i];
        }
       // System.out.println(Arrays.toString(subArray));

        for(int i = subArray.length-1 ; i>=0 ; i--){
            if(A[i] == 0 || subArray[i] == 0) return 1;
            for(int j =0 ; j<i ; j++){
               if(subArray[i]-subArray[j] == 0) return 1;
            }
        }
        return 0;

    }
    public static int solve2(int[] A) {
        if(A[0] == 0) return 1;

        HashMap<Long , Long> mp = new HashMap<>();
        mp.put(0L,0L);

        Long[] preSum = new Long[A.length];
        preSum[0] = (long)A[0];
        mp.put(preSum[0], 0l);
        for(int i =1 ; i<A.length ; i++){
            preSum[i] = preSum[i-1]+A[i];
            if(mp.containsKey(preSum[i])) return 1;
            else mp.put(preSum[i], 0l);
        }
        return 0;
    }

    // Best way .
    public static int solve3(int[] A) {

        Set<Long> set = new HashSet<Long>();

        long sum =0;
        for(int i =0 ; i<A.length; i++){
            sum +=A[i];
            if(sum == 0 || A[i] == 0 || set.contains(sum)) return 1;
            set.add(sum);
        }
        return 0;
    }
}
