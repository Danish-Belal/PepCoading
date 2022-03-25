package LeetCode;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String[] args){
        int[] people = {1,2,3,4,5,6,7,8};
        int limit = 8;
        System.out.println(numRescueBoats(people , limit));

    }
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count=0;

        int l = 0;
        int r = people.length-1;

        while(l<=r){
            int sum = people[l]+people[r];
            if(sum <= limit){
                l++;
               // r--;
            }else{
               // r--;
            }
            r--;
            count++;
        }
        return count;
    }
}
