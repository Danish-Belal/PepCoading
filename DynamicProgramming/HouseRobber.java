package DynamicProgramming;

import java.util.ArrayList;

public class HouseRobber {
    public static void main(String[] args){
        int[] val = {2};
        System.out.println(houseRobber(val));

    }
    public static long houseRobber(int[] valueInHouse) {
        // Write your code here.
        int n = valueInHouse.length;

        if(n == 1) return valueInHouse[0];
      ArrayList<Integer> temp1 = new ArrayList<>() , temp2 = new ArrayList<>();

        for(int i  = 0 ; i< n ; i++){
            if(i != 0) temp1.add( valueInHouse[i]);
            if(i != n-1 ) temp2.add(valueInHouse[i]);
        }

        return Math.max(includeExclude(temp1) , includeExclude(temp2));

    }
    static long includeExclude(ArrayList<Integer> arr){
        long inc = arr.get(0);
        long exc = 0;

        for(int i = 1 ; i<arr.size() ; i++){
            long ninc  = arr.get(i)+exc;
            long nexc = Math.max(inc , exc);

            inc = ninc;
            exc = nexc;

        }
        return Math.max(inc , exc);
    }
}
