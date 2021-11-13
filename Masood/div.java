package Masood;

public class div {
    public static void main(String[] args) {
        int[] arr = {85,25,65,21,80};
        int ans = 0 ;
        int pow = 1;

        for(int i = 0 ; i< arr.length ; i++){
            int ld = arr[i]%10;
            ld = ld*pow;
            ans+= ld;
            pow *=10;
        }


        System.out.println(ans);
     if(ans%10 == 0){
         System.out.println("YES");
     }else{
         System.out.println("NO");
     }
    }
}
