package Oops;

// This is Demo to show static initiation of static variables
public class StaticBlocks {
    static  int a = 4;
    static int b;

    // will only run for the first time when the object is created i.e when the class is loaded for the first time.
    static {
        System.out.println("I am in a static Block");
        b  = a*5;
    }

    public static void main(String[] args) {
        StaticBlocks obj = new StaticBlocks();
        System.out.println(StaticBlocks.a + " " + StaticBlocks.b);

        StaticBlocks.b += 3;
        System.out.println(StaticBlocks.a + " " + StaticBlocks.b);

        StaticBlocks obj2 = new StaticBlocks();
        System.out.println(StaticBlocks.a + " " + StaticBlocks.b);



    }


}
