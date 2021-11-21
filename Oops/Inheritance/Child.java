package Oops.Inheritance;

public class Child extends Base{
    double wight;


    public Child(){
        this.wight = -1;
    }
    public Child(double wight) {
        this.wight = wight;
    }

    public Child(double l, double h, double w, double wight) {
        super(l, h, w);
        this.wight = wight;
    }

    public Child(double side, double wight) {
        super(side);
        this.wight = wight;
    }

    public static void main(String[] args) {
        Child child = new Child(10 , 20,30 ,40);
        System.out.println(child.wight+ " " + child.w + " " + child.h + " " + child.l);
    }
}
