package gof23.creational_pattern.abstract_factory.example1.shape;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("画了个正方型...");
    }
}
