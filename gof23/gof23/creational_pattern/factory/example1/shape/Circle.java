package gof23.creational_pattern.factory.example1.shape;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("画了个圆...");
    }
}
