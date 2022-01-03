package Hasing;
import  java.util.*;


public class Hash {

    public static int Max( Hashtable<Integer , Integer> map){
        Object maxKey=null;
        int maxValue = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxValue;
    }
    public static int Min( Hashtable<Integer , Integer> map){
        Object minKey=null;
        int minValue = Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue() < minValue) {
                minValue = entry.getValue();
                minKey = entry.getKey();
            }
        }
        return minValue;
    }

    public static int size( Hashtable<Integer , Integer> map){
        return map.size();
    }
    
    public static void main(String args[])

    {
        Hashtable<Integer , Integer> map = new Hashtable<>(10);
        map.put(1,10);
        map.put(4,20);
        map.put(3,50);
        map.put(2,40);
        map.put(5,180);
        map.put(6,160);
        map.put(9,105);
        map.put(10,155);
        map.put(7,155);
        map.put(8,155);


        System.out.println("Mapping "+ map);


        // Size of Hash
        int s = size(map);
        System.out.println("Size "+s);

        // Max Value in Hash
        int max = Max(map);
        System.out.println("Max Value" +max);

        // Min Value in Hash.
        int min = Min(map);
        System.out.println("Min Value "+min);


    }
}
