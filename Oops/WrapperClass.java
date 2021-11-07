package Oops;

// Wrapper class used for converting a Primitive into object. and object into java.
public class WrapperClass {
    public static void main(String[] args) {
        int a = 10;  // Primitive.

        Integer num = 20;   // this is an object not primitive.

        A obj = new A("Danish");

        System.out.println(obj.name);
        System.out.println(obj.num);

        obj.name = "Fb";   // This is possible cause this is not final but
      //  obj.num = 20;    // This is not possible , cause num is final value.



        // This will show how garbage collection delete an objects.
//        for (int i = 0; i < 1000000000; i++) {
//            obj = new A("Random name");
//        }


    }
}
    class A {
        final int num = 10;
        String name;

        public A(String name) {
//        System.out.println("object created");
            this.name = name;
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("Object is destroyed");
        }
    }


