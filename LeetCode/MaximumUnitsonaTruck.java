package LeetCode;

import java.util.PriorityQueue;

public class MaximumUnitsonaTruck {
    public static void main(String[] args){
        int[][] arr = {
                {1,3},
                {2,2},
                {3,1}
        };
        System.out.println(maximumUnits(arr , 4));
    }
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->b[1]-a[1]);
        for(int[] i : boxTypes){
            queue.add(i);
        }

        int unit =0 ;
        while(queue.size() >0 && truckSize>0){
            int[] val = queue.poll();
            if(val[0] <= truckSize){
                truckSize -= val[0];
                unit += (val[0]*val[1]);
            }else {
              //  int v = val[0]-truckSize;
                unit += (truckSize*val[1]);
                return unit;
            }
        }
        return unit;
    }


}
