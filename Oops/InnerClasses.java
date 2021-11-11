package Oops;

// Outer classes can not be static .
//static public InnseClasses{}

//
//
//class Test{
//    String name;
//
//    public Test(String name){
//        this.name = name;
//    }
//}

public class InnerClasses {

      static class Test{   // Test class object will not been called directly cause it is dependent on InnerClasses class , but it will work if we make it static,
            String name;

            public Test(String name){

                this.name = name;
            }

            // This is known as Overriding .
          @Override
          public String toString() {
              return name;
          }

      }

        public static void main(String[] args) {
            Test A = new Test("Danish");
            Test B = new Test("Shahzeb");

//            System.out.println(A.name);
//            System.out.println(B.name);

            System.out.println(A);


        }

    }

