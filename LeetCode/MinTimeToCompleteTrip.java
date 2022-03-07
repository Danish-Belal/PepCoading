package LeetCode;

public class MinTimeToCompleteTrip {
    public static void main(String[] args){
        int[] trip = {1,2,3};
        int t = 5;

        System.out.println(minimumTime(trip , t));

    }

   // static long r = (long)10e14 ;
    public static long minimumTime(int[] time, int tt) {

        long l = 0 ;
        long r =  Long.MAX_VALUE;
        long ans = r;

        while(l < r){
            long mid = l+r/2;
            long ct = 0;
            for(int i : time){
                ct += mid/i;
            }
            if(ct > tt){
                ans = Math.min(mid , ans);
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;

    }
}
