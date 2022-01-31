package CodeForces;

import java.util.Scanner;

/*
Polycarp has 3 positive integers a, b and c. He can perform the following operation exactly once.

Choose a positive integer m and multiply exactly one of the integers a, b or c by m.
Can Polycarp make it so that after performing the operation,
the sequence of three numbers a, b, c (in this order) forms an arithmetic progression?
 Note that you cannot change the order of a, b and c.

Formally, a sequence x1,x2,…,xn is called an arithmetic progression (AP)
if there exists a number d (called "common difference") such that xi+1=xi+d for all i from 1 to n−1. In this problem, n=3.

For example, the following sequences are AP: [5,10,15], [3,2,1], [1,1,1], and [13,10,7].
 The following sequences are not AP: [1,2,4], [0,1,0] and [1,3,2].

You need to answer t independent test cases.

Input
The first line contains the number t (1≤t≤104) — the number of test cases.

Each of the following t lines contains 3 integers a, b, c (1≤a,b,c≤108).

Output
For each test case print "YES" (without quotes) if Polycarp can choose a positive integer m and multiply exactly one of the integers a, b or c by m to make [a,b,c] be an arithmetic progression. Print "NO" (without quotes) otherwise.

You can print YES and NO in any (upper or lower) case (for example, the strings yEs, yes, Yes and YES will be recognized as a positive answer).
 */
public class MakeAP {

    public static void AP(long a , long b , long c){
        long x= ( (2*b) - c)/a;
        if(((2*b)-c) == (x*a) && x >0){
            System.out.println("YES");
            return;
        }

        x = (c+a) / (2*b);
        if((c+a) == (2*b*x) && x>0){
            System.out.println("YES");
            return;
        }

        x = ((2*b) - a) /c;
        if(((2*b) - c) == (x*c) && x>0){
            System.out.println("YES");
            return;

        }

        System.out.println("NO");
        return;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while( t != 0){

            long a = scn.nextLong();
            long b = scn.nextLong();
            long c = scn.nextLong();

            AP(a ,b , c);

            t--;
        }
    }

}
