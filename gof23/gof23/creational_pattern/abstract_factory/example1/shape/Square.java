package gof23.creational_pattern.abstract_factory.example1.shape;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("画了个长方型...");
    }
}
