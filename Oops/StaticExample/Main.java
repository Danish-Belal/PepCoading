package Oops.StaticExample;

public class Main {

    public static void main(String[] args) {
        Human Danish = new Human(20 , "Danish Belal" , 'M' , false);
        Human Uziaf = new Human(21 , "Uzaif" , 'M' , false);

       // Danish.display();

//        System.out.println(Danish.population);  // Population is same for everyone.
//        System.out.println(Uziaf.population);   // Do not use this way , it will work but not sufficient way to do.

//        //Do something like this.
//        System.out.println(Human.population);
//        System.out.println(Human.population);

        Main obj = new Main();
        obj.fun2();


    }

    // this is not depends on an Object/
    static void fun(){
       // greeting(); // You can not use this because it requires an object/instance.
        // But the fun function this really doest required an instance/object . it is static.

        // You can not access non static stuff without referencing their instance in a static context.

        // Hence we are referencing it.
        Main obj = new Main();
        obj.greeting();
    }
    void fun2(){
        greeting();  // Here can can call not static function.
    }
    void greeting(){
       // fun();  // We can use this .
        System.out.println("Hello");
    }
}


