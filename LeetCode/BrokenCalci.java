package LeetCode;

public class BrokenCalci {
    public static void main(String[] args){
        System.out.println(brokenCalc(3,10));
        System.out.println(brokencal(3,10));
    }

    static int brokencal(int s , int t){
        int res = 0 ;

        while(t > s){
            res++;
            if(t%2 == 0){
                t /=2;
            }else
                t++;
        }
        return res+(s-t);
    }

    public static int brokenCalc(int s, int t) {
        if(t <= s) return (s-t);

        if(t %2 == 0){
            return 1+brokenCalc(s , t/2);
        }
        return 1+brokenCalc(s , t+1);
    }
}
