package LeetCode;

import java.util.Arrays;

/*
https://leetcode.com/problems/destroying-asteroids/
You are given an integer mass, which represents the original mass of a planet.
You are further given an integer array asteroids, where asteroids[i] is the mass of the ith asteroid.

You can arrange for the planet to collide with the asteroids in any arbitrary order.
 If the mass of the planet is greater than or equal to the mass of the asteroid,
 the asteroid is destroyed and the planet gains the mass of the asteroid. Otherwise, the planet is destroyed.

Return true if all asteroids can be destroyed. Otherwise, return false.
 */

public class DestoringAsteroids {
    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long masses = mass;
        for(int i = 0 ; i<asteroids.length ; i++){
            if(masses < asteroids[i]){
                return false;
            }else{
                masses += asteroids[i];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int mass =10;
        int[] asteroids = {3,9,19,5,21};
        boolean result = asteroidsDestroyed(mass , asteroids);
        System.out.println(result);
    }
}
