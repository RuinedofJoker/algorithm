package gof23.creational_pattern.abstract_factory;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("画了个长方型...");
    }
}
