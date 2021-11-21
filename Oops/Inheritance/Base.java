package Oops.Inheritance;

public class Base {
    double l;
    double h;
    double w;

    public Base() {
        this.h = -1;
        this.l = -1;
        this.w = -1;
    }

    public Base(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }

    public Base(double side){
        this.l = side;
        this.h = side;
        this.w = side;
    }
}
