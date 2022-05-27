package ArraysAndString2;

import java.util.ArrayList;
import java.util.List;

public class NextGreaterElement3 {
    public static void main(String[] args){

    }
    public int nextGreaterElement(int n) {
        List<Integer> list = new ArrayList<>();

        while(n > 0){
            int val = n%10;
            list.add(0,val);
            n /=10;

        }


        int i = list.size()-2;

        while(i >= 0){
            if(list.get(i) > list.get(i+1)){
                i--;
            }else{
                int val = check(list , i);
                swap(list , i , val);
                reverse(list , val+1);
                return isInInt(list);
            }
        }

        return -1;
    }

    int check(List<Integer> list , int i){
        int j = list.size()-1;
        int minIdx = 0;
        while(j > i){
            if(list.get(j) > list.get(i) ){
                minIdx = j;
            }
            j--;
        }
        return minIdx;
    }

    void swap(List<Integer> list , int i , int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j , temp) ;
    }

    void reverse(List<Integer> list , int i){
        int j = list.size()-1;
        while(i<=j){
            swap(list, i , j);
            i++;
            j--;
        }
    }

    int isInInt(List<Integer> list){

        int ans  = 0;
        int i = 0 ;
        while(i < list.size()){
            if(ans > 214748364 || ans < -214748364){
                return -1;
            }
            ans = ans*10+list.get(i);
        }
        return ans;

    }


}
