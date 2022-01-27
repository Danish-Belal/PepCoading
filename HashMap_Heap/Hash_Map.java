package HashMap_Heap;
// Hash Map is a key Value Pair.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hash_Map {

    public static void main(String[] args){

        Map<String , Integer> mp  = new HashMap<>();
        HashMap<String , Integer> hmp  = new HashMap<>();

//        mp.put("UK" ,70);
//        mp.put("USA" ,65);
//        mp.put("India" ,130);
//        mp.put("Pakistan" ,40);
//
//        int val = mp.getOrDefault("UKA" , 0);
//        System.out.println(val);


        hmp.put("UK" ,70);
        hmp.put("USA" ,65);
        hmp.put("India" ,130);
        hmp.put("Pakistan" ,40);
        int val = hmp.getOrDefault("Indi" , 0);
        System.out.println(val);
        ArrayList<String> keys = new ArrayList<>(hmp.keySet());
        System.out.println(keys);

        System.out.println(hmp.get("Pakistan"));


    }
}
