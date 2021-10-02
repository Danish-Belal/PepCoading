package Math;

public class BinarySearchSQRT {
    public static void main(String[] args) {
        int n = 40;
        int p =3 ;
        System.out.println(Squre(n,p));
    }

    public static double Squre(int n, int p) {
        int st = 0;
        int end = n;
        double root = 0.0;
        while (st<=end){
            int mid = st+ (end-st)/2;
            if(mid*mid == n) {
                root = mid;
                return root;
            }
            if(mid*mid > n) {
                end = mid-1;
            }
            else{
              st = mid+1;
            }
        }

        root = end;
        int count = 0;
        double incr = 0.1;
        for (int i = 0; i < p; i++) {
            while (root*root <=n){
                root += incr;
                count++;
            }
            root -= incr;
            incr /=10;
        }
        System.out.println(count);
        return root;
    }

}
