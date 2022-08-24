package CodeForces;

import java.util.Scanner;

public class MathematicalCircle {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int x=0;x<t;x++){
            int n=sc.nextInt();
            int k=sc.nextInt();
            if(k%4==0){
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
            if(k%2==1){
                for(int i=1;i<=n;i+=2){
                    System.out.println(i+" "+(i+1));
                }
            }else{
                for(int i=1;i<=n;i+=2){
                    if(i%4==1){
                        System.out.println((i+1)+" "+i);
                    }else{
                        System.out.println(i+" "+(i+1));
                    }
                }
            }
        }
    }
}
