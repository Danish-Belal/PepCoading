package ArraysAndString2;

import java.util.ArrayList;
import java.util.List;

public class NextGreaterElement3 {
    public static void main(String[] args){
        System.out.println(nextGreaterElement(12345));
    }
    public static int nextGreaterElement(int n) {
        List<Integer> list = new ArrayList<>();

        while (n > 0) {
            int val = n % 10;
            list.add(0, val);
            n /= 10;

        }

        int i = list.size()-2;
        while(i>=0 && list.get(i) >= list.get(i+1)) i--;
        if(i >=0){
            int j = list.size()-1;
            while(list.get(i) >= list.get(j)) j--;
            swap(list , i , j);
            reverse(list , i+1 , list.size()-1);
            return  isInInt(list);
           // return list;
        }
        return -1;
    }



    private static void swap(List<Integer> nums, int i, int j) {
        int t = nums.get(i);
        nums.set(i,  nums.get(j));
        nums.set(j , t);
    }

    private static void reverse(List<Integer> nums, int i, int j) {
        while(i<j) swap(nums , i++ , j--);
    }


    static int isInInt(List<Integer> list){

        int ans  = 0;
        int i = 0 ;
        while(i < list.size()){
            if(ans >= 214748364){
                return -1;
            }
            ans = ans*10+list.get(i++);
        }
        return ans;

    }


}
