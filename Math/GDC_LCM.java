package Math;
/*
HCF = Highest common factor , which divies both values. hcf(a,b) = hcf(remender(b,a) , a).
LCM = Least common Multiple , Minimum number which can be divided by both a and b.  lcm(a,b) = a*b/hcf(a,b).
 */
public class GDC_LCM {
    public static void main(String[] args) {
      //  System.out.println(GCD(10,224));
        System.out.println(LCM(2,7));

    }
    static int GCD(int a , int b){
        if(a==0){
            return b;
        }
        return GCD(b%a , a);
    }
    static int LCM(int a , int b){
        return a*b/GCD(a,b);
    }
}
