package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;

public class MaximumFrequencyStack {
    public static void main(String[] args){



    }
    HashMap<Integer , LinkedList<Integer>> st ;
    HashMap<Integer , Integer> fre ;
    int maxFre;
//    public   FreqStack() {
//        st = new HashMap<>();
//        maxFre = 0;
//        fre = new HashMap<>();
//    }

    public void push(int val) {

       // int currval = fre.getOrDefault(val , 0);
        fre.put(val , fre.getOrDefault(val , 0)+1);

        if(!st.containsKey(fre.get(val))){
            st.put(fre.get(val) , new LinkedList<Integer>());
        }

        st.get(fre.get(val)).addFirst(val);

        maxFre = Math.max(maxFre , fre.get(val));
    }

    public int pop() {
        int ans = st.get(maxFre).removeFirst();
        fre.put(ans , fre.get(ans)-1);

        if(st.get(maxFre).size() == 0)  maxFre--;
        return ans;

    }
}
