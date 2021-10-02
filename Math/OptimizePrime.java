package Math;
/*
https://leetcode.com/problems/count-primes/
 */
public class OptimizePrime {
    public static void main(String[] args) {
        int n = 40;
        boolean[] primes = new boolean[n+1];
        sieve(n,primes);

    }

    // False in array means number is prime
    public static void sieve(int n , boolean[] primes) {
        for(int i = 2 ; i*i <=n ; i++){
            if(!(primes[i])){
                for (int j = i*2 ; j<=n ; j += i){
                    primes[j] = true;
                }
            }
        }
        for (int i = 2; i <=n; i++) {
            if(!(primes[i])){
                System.out.print(i+ " ");
            }
        }
    }
}

// Time Complexity  n* log(log(n)).
// This algo represent harmonic series.
