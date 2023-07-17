package gof23.creational_pattern.prototype;

public class Rectangle extends Shape{

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("画了个长方形...");
    }
}
