package Inheritance;

public class Main {
    public static void main(String[] args) {
      //  Box B = new Box();
     //   System.out.println(B.h + " " + B.l + " " + B.w);

//        Box B = new Box(5);
//        System.out.println(B.h + " " + B.l + " " + B.w);

//
//        Box B2 = new Box(B);
//        System.out.println(B2.h + " " + B2.l + " " + B2.w);

        BoxWeight box = new BoxWeight(2,3,4,5);
        System.out.println(box.h + " " + box.l + " " + box.w + " " + box.weight);

    }
}
