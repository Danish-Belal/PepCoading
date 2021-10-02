package Math;

public class isPrime {
    public static void main(String[] args) {
        int n = 40;
        for(int i =2 ; i<= n ; i++){
            System.out.println(  i +"  "+ isPrime(i));
        }

    }
    public static boolean isPrime(int n){
        if(n <=0 ) return false;
        for(int i= 2 ; i*i < n ; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}
