package gof23.creational_pattern.prototype.example1;

public class Rectangle extends Shape {

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("画了个长方形...");
    }
}
