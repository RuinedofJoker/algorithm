package gof23.creational_pattern.prototype.example1;

public class Square extends Shape {
    public Square() {
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println("画了个正方型...");
    }
}
